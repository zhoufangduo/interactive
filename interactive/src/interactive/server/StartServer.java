package interactive.server;

public class StartServer {
	
	private static boolean isStarted = false;
	
	public static void main(String[] args) {
		Thread startThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				new Server(new Configuration()).startup();
			}
		});
		
		if (!isStarted) {
			startThread.start();
			isStarted = true;
		}
	}
}
