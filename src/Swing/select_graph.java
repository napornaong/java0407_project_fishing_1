package Swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Client.cChart;

public class select_graph extends JFrame implements ActionListener{
	Socket withServer = null;
	JPanel P;
	JButton generalBtn, captainBtn;
	mainScr a=null;
	private cChart cc=null;
	private Gjoin_1 gj=null;
	private Cjoin_1 cj=null;
	
	public select_graph(cChart c) {
		
		this.cc=c;
		this.setLayout(new GridLayout(0,2));
		this.setBounds(300,200,300,300);
		
//		P=new JPanel();
		generalBtn=new JButton("일반모드");
//		P.add(generalBtn);
		captainBtn=new JButton("선장모드");
//		P.add(captainBtn);
		
		this.add(generalBtn,"West");
		this.add(captainBtn,"East");
		
		generalBtn.addActionListener(this);
		captainBtn.addActionListener(this);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object choice=e.getSource();
		if(choice.equals(generalBtn)) {
			dispose();
			gj=new Gjoin_1(cc);
			
		}else if(choice.equals(captainBtn)) {
			if(choice.equals(captainBtn)) {
				dispose();
				cj=new Cjoin_1(cc);
			}
		}
	}

}
