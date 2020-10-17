package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class cDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private Swing.Cjoin_1 m;
	private ArrayList<cDTO>cList=null;
	
	   public cDAO() {
		 cDAOLord();
		 connect();
	 }
	 private void cDAOLord() {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");	
			 System.out.println("클래스 로딩 성공");
		 } catch (ClassNotFoundException e) {
			 // TODO Auto-generated catch block
			 System.out.println("클래스 로드 실패");
		 }
		
	}
	
	
	public boolean connect() {
		boolean cFlag=false;
		try {
			
			conn=DriverManager.getConnection(""
							+"jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
			System.out.println("연결 성공");
			return cFlag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cFlag;
	}
	public ArrayList<cDTO>setAll(){
		ArrayList<cDTO>cList=new ArrayList<>();
		cDTO searDTO=null;
		if(connect()) {
			try {
				stmt=conn.createStatement();
				String sql="select * from memberc";
				rs=stmt.executeQuery(sql);
				while(rs.next()) {
					searDTO =new cDTO();
					searDTO.setId(rs.getString("id"));
					searDTO.setPw(rs.getString("pw"));
					searDTO.setName(rs.getString("name"));
					searDTO.setPnum(rs.getString("pnum"));
					searDTO.setShipname(rs.getString("shipname"));
					searDTO.setShipnum(rs.getInt("shipnum"));
					searDTO.setShipaddr(rs.getString("shipaddr"));
					System.out.println("dydydy");
					cList.add(searDTO);
					System.out.println("dhkdn");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("DB 접속 오류!");
		}
		return cList;
	}
	
	
	public int insertJc(Object dTOsear) {
		if(connect()) {
				try {
					String sql ="insert into memberc values(?,?,?,?,?,?,?)";
					PreparedStatement psmt;
					cDTO a=(cDTO) dTOsear;
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, a.getId());
					psmt.setString(2, a.getPw());
					psmt.setString(3, a.getName());
					psmt.setString(4, a.getPnum());
					psmt.setString(5, a.getShipname());
					psmt.setInt(6, a.getShipnum());
					psmt.setString(7, a.getShipaddr());
					int k = psmt.executeUpdate();
					return k;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}else {
				System.out.println("DB 접속 오류");
			}
		
		return 0;
		
	}
	
	
	
	
	
	
}
