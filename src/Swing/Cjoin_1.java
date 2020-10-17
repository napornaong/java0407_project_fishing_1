
package Swing;

import java.awt.Font;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.cChart;

public class Cjoin_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private cChart cc=null;
	/**
	 * Launch the application.
	 */

	public Cjoin_1(cChart c) {
		this.cc=c;
		setTitle("선장회원가입창");
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
		panel_1.setBounds(67, 174, 238, 325);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("I  D");
		lblNewLabel_1.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 25, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(95, 20, 116, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("P  W");
		lblNewLabel_2.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(23, 84, 70, 15);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 79, 116, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("이  름");
		lblNewLabel_3.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(23, 123, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 118, 116, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("폰번호");
		lblNewLabel_4.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(23, 154, 70, 18);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 151, 116, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("배 이 름");
		lblNewLabel_5.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(23, 202, 57, 15);
		panel_1.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 197, 116, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("배 번 호");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(23, 244, 57, 15);
		panel_1.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(95, 239, 116, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("선주장소");
		lblNewLabel_7.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(24, 284, 69, 15);
		panel_1.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(95, 279, 116, 21);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ID확인");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			String SamId=textField.getText().trim();
			textField.setText(SamId);
			cc.send("samib/"+SamId);
			}
		});
		btnNewButton_1.setBounds(95, 45, 105, 27);
		panel_1.add(btnNewButton_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(67, 522, 238, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.getText().toString().equals("")&&!textField_1.getText().toString().equals("")&&
						!textField_2.getText().toString().equals("")&&!textField_3.getText().toString().equals("")&&
						!textField_4.getText().toString().equals("")&&!textField_5.getText().toString().equals("")&&
						!textField_6.getText().toString().equals("")) {
							String JoinId=textField.getText().trim();
							textField.setText("");
							
							String JoinPw=textField_1.getText().trim();
							textField_1.setText("");
							
							String JoinName=textField_2.getText().trim();
							textField_2.setText("");
							
							String JoinPnum=textField_3.getText().trim();
							textField_3.setText("");
							
							String JoinShipName=textField_4.getText().trim();
							textField_4.setText("");
							
							String JoinShipNum=textField_5.getText().trim();
							textField_5.setText("");
							
							String JoinShipAddr=textField_6.getText().trim();
							textField_6.setText("");
							cc.send("*joinC/"+"id*"+JoinId+"/pw*"+JoinPw+"/cname*"+JoinName+"/ponenum*"+JoinPnum+"/spne*"+JoinShipName+"/shipnum*"+JoinShipNum+"/har*"+JoinShipAddr);
				
			}else {
			//빈곳 없이 입력하세요	
			JOptionPane.showMessageDialog(null,"빈칸 없이 입력하세요");
			}
			}
		});
		btnNewButton.setBounds(64, 10, 112, 35);
		panel_2.add(btnNewButton);
		setVisible(true);
	}
}