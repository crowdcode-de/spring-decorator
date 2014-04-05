package de.crowdcode.springcdi.decorator.resolver.longtwoqualified;

import javax.decorator.Decorator;
import javax.decorator.Delegate;

import org.springframework.beans.factory.annotation.Qualifier;

import de.crowdcode.springcdi.decorator.resolver.longsinglechain.LongSingleChain_MyServiceInterface;

@Decorator
@Qualifier("my")
public class LongTwoQualified_MyDecorator implements
		LongSingleChain_MyServiceInterface {

	@Delegate
	@Qualifier("my")
	private LongSingleChain_MyServiceInterface delegateInterface;

	@Override
	public LongSingleChain_MyServiceInterface getDelegateObject() {
		return delegateInterface;
	}

	@Override
	public String sayHello() {
		return delegateInterface.sayHello();
	}

}
