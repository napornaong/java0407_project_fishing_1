package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class allDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	 public allDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("글래스 로드 실패");;
		}
		
	}
	private boolean connect() {
		boolean cFlag=false;
		try {
			conn=DriverManager.getConnection(""
					+"jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
				return cFlag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cFlag;
	}
	
	
	

	
	public int insertAllLog(Object dTOsear) {
		if(connect()) {
				try {
					String sql ="insert into allmem values(?,?)";
					PreparedStatement psmt;
					allDTO a=(allDTO) dTOsear;
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, a.getId());
					psmt.setString(2, a.getPw());
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
	
	
	public ArrayList<allDTO>initList(){
		ArrayList<allDTO>memList=new ArrayList<>();
		allDTO searDTO=null;;
		
		if(connect()) {
			try {
				
				stmt =conn.createStatement();
				String sql="select * from allmem";
				rs=stmt.executeQuery(sql);
				while(rs.next()) {
					searDTO = new allDTO();
					searDTO.setId(rs.getString("id"));
					searDTO.setPw(rs.getString("pw"));
					memList.add(searDTO);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("DB 접속 오류");
		}
		return memList;
	}
	
	
	
	
	
}
