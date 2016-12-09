package com.automate;

public final class BeanContextLoaderFactory {
	
	/**
	 * Use the default class loader
	 * @return BeanContextLoader
	 */
	public static BeanContextLoader getBeanContextLoader() {
		return getBeanContextLoader(ClassLoader.getSystemClassLoader());
	}
	
	/**
	 * The user specified class loader
	 * @param classLoader
	 * @return BeanContextLoader
	 */
	public static BeanContextLoader getBeanContextLoader(ClassLoader classLoader) {
		return createBeanContextLoader(classLoader);
	}

	
	private static BeanContextLoader createBeanContextLoader(
			ClassLoader classLoader) {
		
		return new DefaultBeanContextLoader(classLoader);
	}

}
