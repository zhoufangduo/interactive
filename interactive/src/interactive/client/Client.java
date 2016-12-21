package interactive.client;

import java.io.IOException;
import java.net.Socket;

public class Client {

	private Socket socket;

	public Client(final Socket socket) {
		this.socket = socket;
	}

	public void close() {
		if (this.socket == null) {
			return;
		}
		if (this.socket.isClosed()) {
			return;
		}
		if (this.socket.isConnected()) {
			try {
				this.socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.socket = null;
	}
}
