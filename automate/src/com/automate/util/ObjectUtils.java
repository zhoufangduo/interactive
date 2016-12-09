package com.automate.util;

import java.util.Collection;

public class ObjectUtils {
	
	public static boolean isNotNull(Object val){
		return val != null? true : false;
	}
	
	public static boolean isNull(Object val){
		return !isNotNull(val);
	}
	
	public static boolean isNotEmpty(Collection<?> val){
		if (isNull(val)) {
			return false;
		}
		if(val.size() > 0){
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(Collection<?> val){
		if (isNull(val)) {
			return true;
		}
		if(val.size() <= 0){
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String val){
		if (isNull(val)) {
			return false;
		}
		if (val.length() > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(String val){
		if (isNull(val)) {
			return true;
		}
		if(val.length() <= 0){
			return true;
		}
		return false;
	}
	
	public static boolean isNotBlank(String val){
		if (isNull(val)) {
			return true;
		}
		if (val.length() == 0) {
			return false;
		}
		return true;
	}
	
	public static boolean isBlank(String val){
		if (isNull(val)) {
			return false;
		}
		if(val.length() == 0){
			return true;
		}
		return false;
	}
	
	public static boolean equals(Object val, Object otherVal){
		return val.equals(otherVal);
	}
	
	public static boolean logicTrue(boolean [] bools){
		for(boolean bool : bools){
			if (bool) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean logicFalse(boolean [] bools){
		for(boolean bool : bools){
			if (!bool) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isBaseType(Object val){
		Class<?>clazz = val.getClass();
		if (int.class.equals(clazz)  || 
			byte.class.equals(clazz) ||
			long.class.equals(clazz) ||
			short.class.equals(clazz)||
			double.class.equals(clazz)||
			float.class.equals(clazz)||
			boolean.class.equals(clazz)||
			char.class.equals(clazz)) 
		{
			return true;
		}
		
		return false;
	}
}
