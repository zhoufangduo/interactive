package com.automate.test;

import org.junit.Test;

import com.automate.BeanContextLoader;
import com.automate.BeanContextLoaderFactory;

public class DefaultBeanContextLoaderTest {
	
	@Test
	public void test(){
		BeanContextLoader loader = BeanContextLoaderFactory.getBeanContextLoader();
		loader.build("/home/zhoufd/workspace/automate/test/beans.xml");
	}
}
