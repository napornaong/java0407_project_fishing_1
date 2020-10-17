package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class cMain {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket withServer = null;
		ClientCenter cCenter = new ClientCenter();
		withServer = new Socket("10.0.0.47",8888);
		new cChart(withServer,cCenter);
	}
}
