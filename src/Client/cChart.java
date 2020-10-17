package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import Swing.mainScr;
import Swing.select_graph;

public class cChart {
	private Socket withServer = null;
	private InputStream reMsg =null;
	private OutputStream sendMsg=null;
	private select_graph cG=null;
	private ClientCenter cCenter=null;
	private mainScr main=null;

	public cChart(Socket withServer,ClientCenter cCenter) {
		this.withServer=withServer;
		this.cCenter=cCenter;
		StartMain();
		receive();
	}
	
	private void StartMain() {
		// TODO Auto-generated method stub
		main=new mainScr(this);
	}

	private void streamSet() {
		try {
			//로그인 버튼을 누르면 아이디를 보내는
			
			
			
			reMsg=withServer.getInputStream();
			byte[]reBuffer =new byte[100];
			reMsg.read(reBuffer);
			String msg = new String(reBuffer);
			msg=msg.trim();
			//위에 띄뭐야됨
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void receive() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(true) {
						System.out.println("aaaa");
						reMsg = withServer.getInputStream();
						byte[] reBuffer = new byte[1024];
						reMsg.read(reBuffer);
						String msg = new String(reBuffer);
						msg = msg.trim();
						System.out.println(msg+"qqqq");
						cCenter.cRmasAna(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
		}).start();
		
	}
	public void send(String reMsg) {
				try {
					while(true) {
						sendMsg = withServer.getOutputStream();
						System.out.println("여기까진 왔어?");
						sendMsg.write(reMsg.getBytes());
						return;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return;
				}
			}


	
	

}
