package com.automate.mapping;

import java.util.List;

public class BeanMapping  {

	private List<MethodMapping> methodMapping;

	private List<FiledMapping> filedMapping;
	
	private Object INSTANCE;

	private Class<?> clazz;

	private String id;

	private boolean singleton;

	public Object getBean() {
		if (!singleton) {
			return getInstance();
		}
		
		return INSTANCE;
	}

	public Class<?> getBeanClass() {
		return clazz;
	}

	public BeanMapping joinBean(String id, Class<?> clazz) {
		this.id = id;
		this.clazz = clazz;
		try {
			INSTANCE = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return this;
	}

	public List<MethodMapping> getMethodMapping() {
		return methodMapping;
	}

	public List<FiledMapping> getFiledMapping() {
		return filedMapping;
	}

	public String getId() {
		return id;
	}

	public boolean isSingleton() {
		return singleton;
	}
	
	protected Object getInstance(){
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
