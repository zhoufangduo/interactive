package com.automate.xml;

import java.io.Reader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.automate.mapping.BeanMapping;
import com.automate.mapping.MethodMapping;
import com.automate.util.ObjectUtils;
import com.automate.util.PropertyUtils;
import com.automate.xml.exception.BeanParseException;
import com.automate.xml.exception.ConfigurationException;


public class XMLConfiguration implements Configuration {
	
	static{
		String source = XMLConfiguration.class.getResource("xpath.cfg").getPath();
		PropertyUtils.loadFile(source);
	}
	
	public void parse(Reader reader, Map<String, Class<?>> clazzs) throws ConfigurationException {
		SAXReader saxReader = new SAXReader();
		try {
			Map<String, String>mapspace = new HashMap<String, String>();  
			mapspace.put("automate","automate-beans");
			saxReader.getDocumentFactory().setXPathNamespaceURIs(mapspace);
			Document document = saxReader.read(reader);
			if (document != null) {
				parseElement(document.getRootElement());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void parseElement(Element root) throws ConfigurationException{
		List<Element>beans = root.selectNodes(PropertyUtils.getString("bean"));
		if (null != beans && beans.size() > 0) {
			parseBean(beans);
		}
		
		List<Element> sources = root.selectNodes(PropertyUtils.getString("bean-scanner"));
		if (null != sources && sources.size() > 0) {
			parseSource(sources);
		}
		
		if(ObjectUtils.isEmpty(beans) && ObjectUtils.isEmpty(sources)){
			throw new ConfigurationException("not find 'bean' or 'bean-scanner' tag configuration, don't parse");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void parseBean(List<Element> beans) throws BeanParseException{
		for(Element bean : beans){
			if (bean != null) {
				String id = bean.attributeValue("id");
				String className = bean.attributeValue("class");
				if (ObjectUtils.isNotEmpty(className) && ObjectUtils.isNotEmpty(id)) {
					Class<?> clazz = null;
					try {
						clazz = Class.forName(className);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					BeanMapping  beanMapping = new BeanMapping().joinBean(id, clazz);
					parseMethod(beanMapping, bean.selectNodes(PropertyUtils.getString("method")));
					parseFiled(beanMapping, bean.selectNodes(PropertyUtils.getString("method")));
				}else{
					throw new BeanParseException("id or class is empty!");
				}
			}
		}
	}
	
	public void parseSource(List<Element> sources){
		
	}

	public void parseMethod(BeanMapping beanMapping, List<Element> methods) {
		for(Element methodNode : methods){
			String name = methodNode.attributeValue("name");
			String refId = methodNode.attributeValue("ref");
			String value = methodNode.attributeValue("value");
			Method method = null;
			
			MethodMapping methodMapping = new MethodMapping(name, method);
			beanMapping.getMethodMapping().add(methodMapping);
		}
		
	}

	public void parseFiled(BeanMapping beanMapping, List<Element> fileds) {
		// TODO Auto-generated method stub
		
	}
}
