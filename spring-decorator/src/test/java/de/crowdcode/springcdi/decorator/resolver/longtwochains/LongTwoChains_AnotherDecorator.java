package de.crowdcode.springcdi.decorator.resolver.longtwochains;

import javax.decorator.Decorator;
import javax.decorator.Delegate;

@Decorator
public class LongTwoChains_AnotherDecorator implements
		LongTwoChains_AnotherServiceInterface {

	@Delegate
	private LongTwoChains_AnotherServiceInterface delegateInterface;

	@Override
	public LongTwoChains_AnotherServiceInterface getDelegateObject() {
		return delegateInterface;
	}

	@Override
	public String sayHello() {
		return delegateInterface.sayHello();
	}

}
