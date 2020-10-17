package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Swing.Gjoin_1;

public class gDAO {
private Connection conn;
private Statement stmt;
private ResultSet rs;
public ArrayList<gDTO>mList;


 gDAO(){
	 gDAOLord();
	 connect();
 }
 private void gDAOLord() {
try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("클래스 로딩 성공");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("클래스 로딩 실패");
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
		System.out.println("커넥트 실패");
	}
	return cFlag;
}

public int insertJg(Object dTOsear) {
	if(connect()) {
			try {
				
				String sql ="insert into memberg values(?,?,?,?)";
				PreparedStatement psmt;
				gDTO a=(gDTO) dTOsear;
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, a.getId());
				psmt.setString(2, a.getPsw());
				psmt.setString(3, a.getName());
				psmt.setString(4, a.getPhone());
				System.out.println(4);
				int k = psmt.executeUpdate();
				return k;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("DB 안너어 졌음");
			}
				
		}else {
			System.out.println("DB 접속 오류~~~~");
		}
	
	return 0;
	
}

public ArrayList<gDTO>setAll(){
	ArrayList<gDTO>gList=new ArrayList<>();
	gDTO searDTO=null;
	if(connect()) {
		try {
			stmt=conn.createStatement();
			String sql="select * from memberg";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				searDTO =new gDTO();
				searDTO.setId(rs.getString("id"));
				searDTO.setPsw(rs.getString("pw"));
				searDTO.setName(rs.getString("name"));
				searDTO.setPhone(rs.getString("pnum"));
				gList.add(searDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}else {
		System.out.println("DB 접속 오류!");
	}
	return gList;
}


	
}
