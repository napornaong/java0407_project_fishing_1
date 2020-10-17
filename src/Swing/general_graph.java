package Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import database.cDAO;

public class general_graph extends JFrame implements ActionListener{
	String header[]= {"지역","배이름","날짜","시간","돈","인원"};
	String contents[][]= null;
	
	JTabbedPane tabPane=new JTabbedPane();   //탭추가 
	
	JTable table =new JTable();  //데이터 활용
	JScrollPane tableScroll=new JScrollPane(table);//스크롤
	
	JPanel tabP=new JPanel();
	JPanel comtemtsP=new JPanel();
	
	
	ArrayList<String[]>initList=new ArrayList<>();
	

	general_graph(){
		Dimension size = new Dimension(600,400);
	}
	public void tableSetting() {
		table.setRowMargin(0);//위 아래 여백
		table.getColumnModel().setColumnMargin(0);
		table.getTableHeader().setReorderingAllowed(false);//테이블 컬럼의 이동을 방지
		table.getTableHeader().setResizingAllowed(false);//테이블 컬럼의 사이즈를 고정
		table.setShowVerticalLines(false);
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//테이블 로우를 한개만 선택
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {//클릭
					int colume = table.columnAtPoint(e.getPoint());
					int row= table.rowAtPoint(e.getPoint());
					
					
				}if(e.getClickCount()==2) {//더블클릭
					
				}if(e.getButton()==3) {//오른쪽 클릭
					
				}
						
				
			}
		});
		
		DefaultTableCellRenderer ts=new DefaultTableCellRenderer();//셀 안에 들어가는 데이터의 정렬을 조절
		ts.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc=table.getColumnModel();
		for(int i =0; i<tc.getColumnCount();i++) {
			tc.getColumn(i).setCellRenderer(ts);
		}
		
	}
	//클릭하면 mymeun에 예약된 현황하고 예약 취소할수 있게 
	//서버로 예약한 사실을 보내기
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
