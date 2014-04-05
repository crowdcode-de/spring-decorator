package de.crowdcode.springcdi.decorator.strategies.impl;

import de.crowdcode.springcdi.decorator.model.QualifiedDecoratorChain;
import de.crowdcode.springcdi.decorator.strategies.DecoratorOrderingStrategy;
import de.crowdcode.springcdi.decorator.strategies.DecoratorResolutionStrategy;

/**
 * Simple ordering strategy just orders decorators as found in the {@link DecoratorResolutionStrategy}.
 * 
 * @author Niklas Schlimm
 *
 */
public class SimpleDecoratorOrderingStrategy implements DecoratorOrderingStrategy {

	@Override
	public QualifiedDecoratorChain orderDecorators(QualifiedDecoratorChain chain) {
		return chain;
	}

}
