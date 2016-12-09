package com.automate;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

public interface BeanContextLoader {
	
	public BeanContextLoader build(String resource);
	
	public BeanContextLoader build(File file);
	
	public BeanContextLoader build(InputStream inStream);
	
	public BeanContextLoader build(Reader reader);
	
	
}
