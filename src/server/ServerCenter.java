package server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import database.DAOCenter;
import database.IDcheck;
import database.allDAO;
import database.allDTO;
import database.cDAO;
import database.cDTO;
import database.gDAO;
import database.gDTO;

public class ServerCenter {
	gDAO DAOsear;
	gDTO DTOsear;
	cDTO cDTOsear;
	allDTO allDTOsear=new allDTO();
	String Log = null;
	DAOCenter dc = new DAOCenter();
	private Socket withClient = null;
	private sChart sCh = null;
	private ArrayList<allDTO> allList = new ArrayList<>();
	private ArrayList<cDTO> cList = new ArrayList<>();
	private ArrayList<gDTO> gList = new ArrayList<>();
	
	
	private ArrayList<sChart> sList = new ArrayList<>();
	private String remsg = null;
	private allDAO allSave = new allDAO();
	private cDAO cDAOsear= new cDAO();
	String Mem ="gmem";
	String allM="allmem";
	String Mem1 ="cmem";
	
	
	
	public void ServerCenter(sChart sCh) {
		this.sCh = sCh;
		
	}
	
	public void addServerChat(sChart s) {
		sList.add(s);
	}
	
	public void sRmasAna(String msg) {
		String id = null;
		String pw = null;
		
		if (msg.contains("samib/")) {
			int a = msg.indexOf("/");
			String reSmsg = msg.substring(a + 1);
			System.out.println(reSmsg + 111);
			CheckId(reSmsg);
		} else if (msg.contains("*joinG/")) {
			String remsgJG = msg;
			saveDB(remsgJG);
		} else if (msg.contains("*joinC/")) {
			String remsgJC = msg;
			saveCDB(remsgJC);
		}
		if (msg.contains("checklog/")) {
			System.out.println("여긴?");
			int a = msg.indexOf("/");
			String logRemsg = msg.substring(a + 1);
			StringTokenizer st = new StringTokenizer(logRemsg, "/");
			int countToken = st.countTokens();
			for (int i = 0; i < countToken; i++) {
				String remsg1 = st.nextToken();
				if (remsg1.contains("checkid*")) {
					int b = remsg1.indexOf("*");
					id = remsg1.substring(b + 1);
				} else if (remsg1.contains("checkpw*")) {
					int c = remsg1.indexOf("*");
					pw = remsg1.substring(c + 1);
				}
			}
			System.out.println("보내긴했니?");
			allSaveId(id, pw);
			
		}
	}


	private void CheckId(String reSmsg) {
		// TODO Auto-generated method stub
		String newJName = reSmsg;
		String CkId=null;
		ArrayList<allDTO> memList = allSave.initList();
		if(newJName.length()<=10) {
			System.out.println("1123123112");
			if(memList!=null) {
				for (allDTO see : memList) {
					System.out.println("qqqqwefqfvq");
					if(!see.getId().equals(newJName)) {
						System.out.println("qqweeeqqqqqq");
						CkId="okid";
						sCh.send(CkId);
						break;
					}else {
						CkId="samid";
						sCh.send(CkId);
						break;
					}
				}
			}else {
				System.out.println("123dfffff");
				CkId="okid";
				sCh.send(CkId);
			}
		}else if(newJName.length()>10) {
			CkId="ovid";
			sCh.send(CkId);
		}
		
	}

	public void saveDB(String info) {
		DTOsear = new gDTO();
		String msg = info;
		System.out.println("여기까지 온건가?");
		String msgData = null;
		String id = null;
		String pw = null;
		String name = null;
		String pnum = null;
		if (msg.contains("*joinG/")) {
			int a = msg.indexOf("/");
			remsg = msg.substring(a + 1);
		}
		StringTokenizer st = new StringTokenizer(remsg, "/");
		int countToken = st.countTokens();
		for (int i = 0; i < countToken; i++) {
			msgData = st.nextToken();
			System.out.println(msgData + 111);
			if (msgData.contains("id*")) {
				int a = msgData.indexOf("*");
				id = msgData.substring(a + 1);
				DTOsear.setId(id);
				allDTOsear.setId(id);
				System.out.println(id);
			} else if (msgData.contains("pw*")) {
				int a = msgData.indexOf("*");
				pw = msgData.substring(a + 1);
				DTOsear.setPsw(pw);
				allDTOsear.setPw(pw);
				System.out.println(pw);
			} else if (msgData.contains("name*")) {
				int a = msgData.indexOf("*");
				name = msgData.substring(a + 1);
				DTOsear.setName(name);
				System.out.println(name);
			} else if (msgData.contains("pnum*")) {
				int a = msgData.indexOf("*");
				pnum = msgData.substring(a + 1);
				DTOsear.setPhone(pnum);
				System.out.println(pnum);
			}

		}
		dc.setInsert(Mem, DTOsear);
		dc.setInsert(allM, allDTOsear);
	}

	public void saveCDB(String info) {
		String msg = info;
		cDTOsear = new cDTO();
	
		String msgData = null;
		
		if (msg.contains("*joinC/")) {
			int a = msg.indexOf("/");
			remsg = msg.substring(a + 1);
		}
		StringTokenizer st = new StringTokenizer(remsg, "/");
		int countToken = st.countTokens();
		for (int i = 0; i < countToken; i++) {
			msgData = st.nextToken();
			if (msgData.contains("id*")) {
				int a = msgData.indexOf("*");
				String id = msgData.substring(a + 1);
				cDTOsear.setId(id);
				allDTOsear.setId(id);
			} else if (msgData.contains("pw*")) {
				int a = msgData.indexOf("*");
				String pw = msgData.substring(a + 1);
				cDTOsear.setPw(pw);
				allDTOsear.setPw(pw);
			} else if (msgData.contains("cname*")) {
				int a = msgData.indexOf("*");
				String name = msgData.substring(a + 1);
				cDTOsear.setName(name);
			} else if (msgData.contains("ponenum*")) {
				int a = msgData.indexOf("*");
				String pnum = msgData.substring(a + 1);
				cDTOsear.setPnum(pnum);
			} else if (msgData.contains("spne*")) {
				int a = msgData.indexOf("*");
				String shipname = msgData.substring(a + 1);
				cDTOsear.setShipname(shipname);
			} else if (msgData.contains("shipnum*")) {
				int a = msgData.indexOf("*");
				String shipnum = msgData.substring(a + 1);
				Integer Intshipnum = Integer.valueOf(Integer.parseInt(shipnum));
				cDTOsear.setShipnum(Intshipnum);
			} else if (msgData.contains("har*")) {
				int a = msgData.indexOf("*");
				String shipaddr = msgData.substring(a + 1);
				cDTOsear.setShipaddr(shipaddr);
			}

		}
		System.out.println("!@#!@#");
		dc.setInsert(Mem1, cDTOsear);
		dc.setInsert(allM, allDTOsear);
	}


	private void allSaveId(String id, String pw) {
		ArrayList<allDTO> memList = allSave.initList();
		ArrayList<cDTO> cList= cDAOsear.setAll();
		System.out.println("확인하는데까진?");
		for (allDTO see : memList) {
			if (see.getId().equals(id) && see.getPw().equals(pw)) {
				System.out.println("아디 비번은 맞음");
				for (cDTO q : cList) {
					if (id.equals(q.getId())) {
						System.out.println("둘다 맞음");
						Log = "clogok*";
						sCh.send(Log+id);
						break;
					} else {
						System.out.println("실패");
						Log = "glogok*";
						sCh.send(Log+id);
						break;
					}
				}

			} else {
				Log="logF*";
				sCh.send(Log);
			}
		}
	}

}
