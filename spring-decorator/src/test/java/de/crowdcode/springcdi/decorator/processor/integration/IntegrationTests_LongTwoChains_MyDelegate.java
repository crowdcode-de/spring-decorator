package de.crowdcode.springcdi.decorator.processor.integration;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.crowdcode.springcdi.decorator.resolver.longsinglechain.LongSingleChain_MyDelegate;
import de.crowdcode.springcdi.decorator.resolver.longtwochains.LongTwoChains_IntegrationTests_MyDelegate;

@ContextConfiguration(inheritLocations = false, locations = "/test-context-decorator-processor-long-two-chains-integration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class IntegrationTests_LongTwoChains_MyDelegate extends
		LongTwoChains_IntegrationTests_MyDelegate {

	@Test
	public void testInjectedObject() {
		Assert.assertTrue(LongSingleChain_MyDelegate.class
				.isAssignableFrom(AopUtils.getTargetClass(decoratedInterface)));
	}

}
