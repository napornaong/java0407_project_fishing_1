package database;

import java.util.ArrayList;

import server.ServerCenter;
import server.sChart;

public class IDcheck {
	private ArrayList<gDTO> gList = new ArrayList<>();
	private ArrayList<cDTO> cList = new ArrayList<>();
	private sChart sCh = null;

	private ServerCenter sc;
	
	
	public IDcheck(sChart sCh){
		this.sCh=sCh;
	}
	
	

	public void CheckId(String a) {
//		아이디는 영어로 가능 하며 10자 이하로하고 중복되면 안된다
		String newJName = a;
		String CkId=null;

		if(newJName.length()<=10) {
			for(int i=0;i<gList.size();i++) {
				if(!gList.get(i).getId().equals(newJName)&&!cList.get(i).getId().equals(newJName)){
					CkId="okid";
					sCh.send(CkId);
				
				}else {
					//-1이면 중복
					CkId="samid";
					sCh.send(CkId);
					break;
				}
			}
		}else if(newJName.length()>10){
			//flag 0 이면 10자가 넘음
			CkId="ovid";
			sCh.send(CkId);
		}
		
		
	}

	// 비밀번호는 특수문자가 들어가야 한고 6자 이상 10자 이하로 한다
	public String Checkpw(String a) {
		String newPw = a;
		String falsePw = "비밀번호는 6자 이상 10자 이하";
		String SfalsePw = "특수문자가 미포함";
		String OKpw = "사용가능한 비밀번호";
		if (newPw.length() >= 6 && newPw.length() <= 10) {
			for (int i = 0; i < newPw.length(); i++) {
				if (newPw.charAt(i) >= 65 && newPw.charAt(i) <= 79) {

				} else {
					return SfalsePw;
				}
			}
		} else {
			return falsePw;
		}
		return OKpw;

	}

}
