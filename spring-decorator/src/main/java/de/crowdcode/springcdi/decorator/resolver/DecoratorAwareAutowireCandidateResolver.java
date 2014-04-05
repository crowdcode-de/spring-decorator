package de.crowdcode.springcdi.decorator.resolver;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.AutowireCandidateResolver;

import de.crowdcode.springcdi.SpringCDIInfrastructure;
import de.crowdcode.springcdi.SpringCDIPlugin;
import de.crowdcode.springcdi.decorator.DecoratorAwareBeanFactoryPostProcessor;
import de.crowdcode.springcdi.decorator.resolver.rules.BeanPostProcessorCDIAutowiringRules;
import de.crowdcode.springcdi.decorator.resolver.rules.ResolverCDIAutowiringRules;

/**
 * {@link AutowireCandidateResolver} that can deal with JSR-299 patterns.
 * 
 * Clients may register custom rule sets if the wiring logic is not sufficient enough. If
 * {@link DecoratorAwareBeanFactoryPostProcessor} mode is set to 'resolver' then {@link ResolverCDIAutowiringRules} are
 * in use here. If mode is set to 'processor' then {@link BeanPostProcessorCDIAutowiringRules} are in use.
 * 
 * This class is a {@link SpringCDIInfrastructure} bean. It can deal with additional CDI rules from other Spring-CDI modules.
 * 
 * @author Niklas Schlimm
 * 
 */
public class DecoratorAwareAutowireCandidateResolver extends QualifierAnnotationAutowireCandidateResolver implements SpringCDIInfrastructure {

	private Set<SpringCDIPlugin> rulePlugins = new HashSet<SpringCDIPlugin>();

	public DecoratorAwareAutowireCandidateResolver() {
		super();
	}

	public DecoratorAwareAutowireCandidateResolver(Class<? extends Annotation> qualifierType) {
		super(qualifierType);
	}

	public DecoratorAwareAutowireCandidateResolver(Set<Class<? extends Annotation>> qualifierTypes) {
		super(qualifierTypes);
	}

	public boolean isAutowireCandidate(BeanDefinitionHolder bdHolder, DependencyDescriptor descriptor) {
		// First check qualifiers
		boolean rawResult = super.isAutowireCandidate(bdHolder, descriptor);
		// Check registered wiring rules
		boolean ruleSetResultOK = true;
		for (SpringCDIPlugin rulePlugin : rulePlugins) {
			boolean rulesResultOK = rulePlugin.executeLogic(bdHolder, descriptor);
			if (!rulesResultOK) {
				ruleSetResultOK = false;
			}
		}
		return rawResult && ruleSetResultOK;
	}

	@Override
	public void addPlugin(SpringCDIPlugin plugin) {
		rulePlugins.add(plugin);
	}

	@Override
	public Set<SpringCDIPlugin> getPlugins() {
		return rulePlugins;
	}
}
