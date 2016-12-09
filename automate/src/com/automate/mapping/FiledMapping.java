package com.automate.mapping;

import java.lang.reflect.Field;

public class FiledMapping extends NumberMapping {

	private Field filed;
	
	public FiledMapping(String name,Field filed){
		this.name = name;
		this.filed = filed;
	}

	public Field getFiled() {
		return filed;
	}

	@Override
	public void injectRef(String refId, Object instance) {
		this.refId = refId;
	}

	@Override
	public void injectVal(String value, Object instance) {
		this.value = value;
	}

}
