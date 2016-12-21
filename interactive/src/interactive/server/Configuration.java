package interactive.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {
	
	public static Map<String, String> initParams = new HashMap<String, String>(30); 
	
	static{
		Properties properties = getProperties();
		Enumeration<Object> keys = properties.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			initParams.put(key, properties.getProperty(key));
		}
	}

	private static Properties getProperties() {
		Properties properties = new Properties();
		try {
			InputStream inStream = Configuration.class.getResourceAsStream("/interactive.ini");
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public int getIntValue(String key){
		return Integer.parseInt(initParams.get(key));
	}
	
	public String getValue(String key){
		return initParams.get(key);
	}

	public boolean getBoolValue(String key) {
		return Boolean.parseBoolean(initParams.get(key));
	}
}
