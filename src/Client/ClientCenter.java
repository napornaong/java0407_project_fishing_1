package Client;

import javax.swing.JOptionPane;

import Swing.Gjoin_1;
import Swing.mainCScr;
import Swing.mainGScr;

public class ClientCenter {
	Gjoin_1 gj=null;
	
	 ClientCenter(){
	 
	 }
	 
	public void setGjoin_Sin(Gjoin_1 gj) {
		 this.gj=gj;
	 }
	
	public void cRmasAna(String msg) {
		System.out.println(12193);
		if(msg.contains("clogok*")) {
			int a =msg.indexOf("*");
			String logId=msg.substring(a+1);
			new mainCScr(logId);
		
		}else if(msg.contains("glogok*")) {
			int a =msg.indexOf("*");
			String logId=msg.substring(a+1);
			new mainGScr(logId);
				
		}else if(msg.contains("logF*")) {
			JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 다시 확인하세요");
		}else if(msg.contains("okid")) {
//			gj.cksam(msg);
			JOptionPane.showMessageDialog(null,"사용 가능한 아이디 입니다");
		}else if(msg.contains("ovid")) {
//			gj.cksam(msg);
			JOptionPane.showMessageDialog(null,"10자 이하로 가능합니다");
		}else if(msg.contains("samid")) {
//			gj.cksam(msg);
			JOptionPane.showMessageDialog(null,"중복된 아이디가 있습니다");
		}
		
	}

}
