package com.automate.xml;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.automate.mapping.BeanMapping;
import com.automate.xml.exception.BeanParseException;
import com.automate.xml.exception.ConfigurationException;

public interface Configuration {

	public void parse(Reader reader, Map<String, Class<?>> clazzs)throws ConfigurationException;
	
	public void parseBean(List<Element> beans) throws BeanParseException;
	
	public void parseMethod(BeanMapping  beanMapping, List<Element> methods);
	
	public void parseFiled(BeanMapping  beanMapping, List<Element> fileds);
	
	public void parseSource(List<Element> sources);
}
