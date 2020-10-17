package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.cChart;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	cChart ClChat=null;
	
	/**
	 * Create the frame.
	 */
	
	public login_1(cChart ClChat) {
		this.ClChat=ClChat;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(410,670);
		setVisible(true);
		
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(5, 143, 371, 255);
		setTitle("로 그 인 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		contentPane.add(lblImage, BorderLayout.CENTER);
			
		lblImage.setIcon(new ImageIcon("d.jpg"));
		contentPane.add(lblImage);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 107, 10, 291);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(373, 107, 10, 291);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 446, 377, 31);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" I  D  ");
		lblNewLabel_1.setBounds(94, 8, 68, 15);
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(161, 5, 116, 21);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(5, 487, 377, 37);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("P  W");
		lblNewLabel_2.setBounds(95, 8, 65, 15);
		panel_5.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 5, 116, 21);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(6, 534, 377, 33);
		contentPane.add(panel_6);
		
		JButton btnNewButton = new JButton("로 그 인 ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.equals("")&&!textField_1.equals("")) {
					String idck=textField.getText().trim();
					textField.setText("");
					String pwck=textField_1.getText().trim();
					textField_1.setText("");
					System.out.println("여기까지?");
					ClChat.send("checklog/"+"checkid*"+idck+"/checkpw*"+pwck);
					
				}else if(textField.equals("")){
					JOptionPane.showMessageDialog(null, "아이디가 입력되어 있지 않습니다");
				}else if(textField_1.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호가 입력되어 있지 않습니다");
				}
				
				
			}
		});
		panel_6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회 원 가 입");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new select_graph(ClChat);
			}
		});
		panel_6.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 35, 323, 59);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("맑은고딕", Font.BOLD, 34));
		panel.add(lblNewLabel);
		
		setVisible(true);
		
		
	}
	
}