package de.crowdcode.springcdi;

import de.crowdcode.springcdi.decorator.resolver.DecoratorAwareAutowireCandidateResolver;
import de.crowdcode.springcdi.decorator.resolver.rules.BeanPostProcessorCDIAutowiringRules;
import de.crowdcode.springcdi.decorator.resolver.rules.ResolverCDIAutowiringRules;

/**
 * Interface implemented by Spring-CDI plugins. Enables registry of rule set
 * plugin with {@link DecoratorAwareAutowireCandidateResolver}.
 * 
 * @author Niklas Schlimm
 * @see {@link ResolverCDIAutowiringRules},
 *      {@link DecoratorAwareAutowireCandidateResolver},
 *      {@link BeanPostProcessorCDIAutowiringRules}
 * 
 */
public interface SpringCDIPlugin {

	boolean executeLogic(Object... arguments);

}
