package interactive.logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import interactive.server.Configuration;


public class LoggerUtil {

	private static String separator ;
	
	private static String logFilePath; 
	
	private static Level log_level;
	
	private static boolean isConsole;
	
	public static void init(Configuration configuration) {
		LoggerUtil.logFilePath = configuration.getValue("files");
		LoggerUtil.log_level = getLevel(configuration.getValue("level"));
		LoggerUtil.isConsole = configuration.getBoolValue("console");
		LoggerUtil.separator = File.separator;
	}

	private static Level getLevel(String value) {
		switch (value) {
		case "ALL":
			return Level.ALL;
		case "SEVERE":
			return Level.SEVERE;
		case "OFF":
			return Level.OFF;
		case "WARNING":
			return Level.WARNING;
		case "INFO":
			return Level.INFO;
		case "CONFIG":
			return Level.CONFIG;
		case "FINE":
			return Level.FINE;
		case "FINER":
			return Level.FINER;
		case "FINEST":
			return Level.FINEST;
		default:
			return Level.ALL;
		}
	}

	private static String getFileLogName(String type) {
		StringBuffer logPath = new StringBuffer();
		logPath.append(logFilePath);
		File file = new File(logPath.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		logPath.append(separator).append(sdf.format(new Date()));
		if (LoggerType.SQL_TYPE.equals(type)) {
			logPath.append("_sql.log");
		} else if (LoggerType.LOG_TYPE.equals(type)) {
			logPath.append("_log.log");
		}
		return logPath.toString();
	}

	private static Logger setLogingProperties(Logger logger, String type) {
		try {
			FileHandler fh = new FileHandler(getFileLogName(type), true);
			logger.addHandler(fh);
			logger.setLevel(log_level);
			fh.setFormatter(new SimpleFormatter());
			if (isConsole) {
				logger.addHandler(new ConsoleHandler());
			}
		} catch (SecurityException e) {
			logger.log(Level.SEVERE, "SecurityException Error", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "IOException Error", e);
		}
		
		return logger;
	}
	
	public static Logger getLogger(String type){
		return setLogingProperties(Logger.getAnonymousLogger(), type);
	}
}