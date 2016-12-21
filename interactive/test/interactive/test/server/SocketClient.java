package interactive.test.server;

import java.io.IOException;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.234.131", 4406);
			socket.setKeepAlive(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
