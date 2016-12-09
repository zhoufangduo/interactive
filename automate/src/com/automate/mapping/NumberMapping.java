package com.automate.mapping;

public abstract class NumberMapping {

	protected String name;

	protected String refId;

	protected String value;

	public String getName() {
		return name;
	}

	public String getRefId() {
		return refId;
	}

	public String getValue() {
		return value;
	}
	
	public abstract void injectRef(String refId, Object instance);
	
	
	public abstract void injectVal(String value, Object instance);
}
