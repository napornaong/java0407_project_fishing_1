package database;

public class DAOCenter {
	gDAO gdao=null;
	cDAO cdao=null;
	allDAO alldao=null;
	public void setInsert(String Mem, Object dTOsear) {
		// TODO Auto-generated method stub
		switch(Mem) {
		case "gmem":
			gdao=new gDAO();
			gdao.insertJg(dTOsear);
			break;
		case "cmem":
			System.out.println("0001111");
			cdao=new cDAO();
			cdao.insertJc(dTOsear);
			break;
		case "allmem":
			alldao=new allDAO();
			alldao.insertAllLog(dTOsear);
			break;
		}
	}

}
