 package Swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.ClientCenter;
import Client.cChart;

public class Gjoin_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private cChart cc=null;

	/**
	 * Create the frame.
	 * @param gMem 
	 */
	public Gjoin_1( cChart c) {
		this.cc=c;
		
		setTitle("G회원가입창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(410,670);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 35, 323, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(74, 10, 237, 46);
		lblNewLabel.setFont(new Font("맑은고딕", Font.BOLD, 34));
		panel.add(lblNewLabel);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(66, 166, 238, 272);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("I  D");
		lblNewLabel_1.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(14, 51, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(67, 46, 116, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("P  W");
		lblNewLabel_2.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(14, 118, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 113, 116, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(14, 180, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("폰 번 호");
		lblNewLabel_4.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(14, 234, 70, 15);
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 175, 116, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(67, 229, 116, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(67, 78, 142, 18);
		panel_1.add(lblNewLabel_5);
		
		
		JButton btnNewButton_1 = new JButton("ID확인");
		btnNewButton_1.setBounds(262, 209, 116, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SamId=textField.getText().trim();
				textField.setText(SamId);
			System.out.println(SamId);
				cc.send("samib/"+SamId);
				
			}
		});
	

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(66, 460, 238, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.getText().toString().equals("")&&!textField_1.getText().toString().equals("")&&
				!textField_2.getText().toString().equals("")&&!textField_3.getText().toString().equals("")) {
					String JoinId=textField.getText().trim();
					textField.setText("");
					
					String JoinPw=textField_1.getText().trim();
					textField_1.setText("");
					
					String JoinName=textField_2.getText().trim();
					textField_2.setText("");
					
					
					String JoinPnum=textField_3.getText().trim();
					textField_3.setText("");
					cc.send("*joinG/"+"id*"+JoinId+"/pw*"+JoinPw+"/name*"+JoinName+"/pnum*"+JoinPnum);
					
				}else {
					// 빈 곳 없이 입력바랍니다
					JOptionPane.showMessageDialog(null,"빈칸 없이 입력하세요");
				
				}
				
				
				
				
				
				JLabel lblNewLabel_6 = new JLabel("New label");
				lblNewLabel_6.setBounds(67, 145, 142, 18);
				panel_1.add(lblNewLabel_6);
			}
		});
		btnNewButton.setBounds(64, 10, 112, 35);
		panel_2.add(btnNewButton);
		setVisible(true);
		
	}
	
		
		
		
	}
	
	
	
	
	

