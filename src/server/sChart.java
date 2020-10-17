package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import database.IDcheck;
import database.allDTO;
import database.cDTO;
import database.gDTO;

public class sChart extends Thread{
	private Socket withClient =null;
	private InputStream reMsg=null;
	private OutputStream sendMsg =null;
	private String id=null;
	private String psw=null;
	private ServerCenter a=null;
	
	 sChart(Socket withClient, ServerCenter a) {
		 this.withClient=withClient;
		 this.a=a;
		 
	 }
	 @Override
		public void run() {
			// TODO Auto-generated method stub
			receive();
			//send();
		}
	
	 
	 private void streamSet() {
		 try {
			reMsg = withClient.getInputStream();
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer);
			id = new String(reBuffer);
			id = id.trim();
			String reMsg=id+"님";
		
			sendMsg=withClient.getOutputStream();
			sendMsg.write(reMsg.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 public void receive() {
		 new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					try {
						while(true) {
						reMsg=withClient.getInputStream();
						byte[] reBuffer = new byte[100];
						reMsg.read(reBuffer);
						String msg= new String(reBuffer);
						msg=msg.trim();
						System.out.println("aqssqs");
						a.sRmasAna(msg);
						
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}
		 }).start();
			 
		
	 }
	
	public void send(String reMsg) {
		 try {
			sendMsg = withClient.getOutputStream();
			System.out.println(reMsg+13);
			sendMsg.write(reMsg.getBytes());
			System.out.println("갔니?");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		 
		 
	 }




	 
	 
	 
}






