package com.automate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.automate.xml.Configuration;
import com.automate.xml.XMLConfiguration;
import com.automate.xml.exception.ConfigurationException;

public abstract class AbstractBeanContextLoader implements BeanContextLoader {

	private Map<String, Class<?>> clazzs;

	private Configuration configuration;

	protected AbstractBeanContextLoader() {
		this.clazzs = new HashMap<String, Class<?>>();
		this.configuration = new XMLConfiguration();
	}

	public BeanContextLoader build(String resource) {
		return build(new File(resource));
	}

	public BeanContextLoader build(File file) {
		try {
			return build(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public BeanContextLoader build(InputStream inStream) {
		return build(new InputStreamReader(inStream));
	}

	public BeanContextLoader build(Reader reader) {
		try {
			configuration.parse(reader, clazzs);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return this;
	}
}
