package com.automate.mapping;

import java.lang.reflect.Method;

public class MethodMapping extends NumberMapping {

	private Method method;
	
	public MethodMapping(String name, Method method){
		this.name = name;
		this.method = method;
	}

	public Method getMethod() {
		return method;
	}

	@Override
	public void injectRef(String refId, Object instance) {
		
	}

	@Override
	public void injectVal(String value, Object instance) {
		
	}
}
