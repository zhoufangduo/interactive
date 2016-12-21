package interactive.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import interactive.logger.LoggerType;
import interactive.logger.LoggerUtil;
import interactive.server.exception.ServerSocketException;

public class Server {
	
	private static Logger logger = LoggerUtil.getLogger(LoggerType.LOG_TYPE);
	
	private ServerSocket server ;
	
	private boolean isAccept;
	
	public Server(Configuration configuration) {
		init(configuration);
	}

	private void init(Configuration configuration) {
		initLogger(configuration);
		this.server = createServer(configuration.getIntValue("port"));
	}

	private void initLogger(Configuration configuration) {
		LoggerUtil.init(configuration);
		logger.log(Level.INFO, "init Logger for interactive");
	}

	private ServerSocket createServer(final int port) {
		try {
			logger.info("create ServerSocket");
			return new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new ServerSocketException("create ServerSocket fail");
	}

	public void startup() {
		this.isAccept = true;
		while(this.isAccept){
			try {
				Socket socket = this.server.accept();
				System.out.println(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		this.isAccept = false;
	}
}
