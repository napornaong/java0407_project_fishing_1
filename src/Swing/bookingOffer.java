package Swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Client.cChart;

public class bookingOffer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private static  cChart cc=null;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private JComponent frame;

			public void run() {
				try {
					bookingOffer offer = new bookingOffer(cc);
			
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public bookingOffer(cChart cc) {
		this.cc=cc;
		setTitle("예약제공");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(18, 40, 147, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("예약제공", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 15, 123, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.setBounds(12, 131, 370, 273);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("예약제공");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 10, 110, 28);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 48, 370, 225);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("배번호");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 67, 57, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("배이름");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(72, 67, 57, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("예약금액");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(157, 67, 64, 15);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("인원");
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(261, 67, 57, 15);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("출항장소");
		lblNewLabel_7.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(72, 126, 57, 21);
		panel_2.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(12, 94, 45, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 93, 61, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 94, 90, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(261, 94, 49, 21);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(72, 159, 116, 21);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		
		JLabel lblNewLabel_6 = new JLabel("날짜");
		lblNewLabel_6.setBounds(202, 126, 62, 18);
		panel_2.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(202, 158, 116, 24);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("선주ID ");
		lblNewLabel_8.setBounds(12, 12, 62, 18);
		panel_2.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(59, 9, 80, 24);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		
		JLabel lblNewLabel_9 = new JLabel("선주이름");
		lblNewLabel_9.setBounds(177, 12, 62, 18);
		panel_2.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(241, 9, 80, 24);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		JButton btnNewButton = new JButton("제 공 하 기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.getText().toString().equals("")&&!textField_1.getText().toString().equals("")&&!textField_2.getText().toString().equals("")
						&&!textField_3.getText().toString().equals("")&&!textField_5.getText().toString().equals("")&&!textField_4.getText().toString().equals("")
						&&!textField_6.getText().toString().equals("")&&!textField_7.getText().toString().equals("")) {
					String OfferSnum=textField.getText().trim();
					textField.setText("");
					
					String OfferSname=textField_1.getText().trim();
					textField_1.setText("");
					
					String OfferManey=textField_2.getText().trim();
					textField_2.setText("");
					
					
					String OfferNumP=textField_3.getText().trim();
					textField_3.setText("");
					
					String OfferAddr=textField_5.getText().trim();
					textField_5.setText("");
					cc.send("*offer/"+"snum*"+OfferSnum+"/sname*"+OfferSname+"/maney*"+OfferManey+"/nump*"+OfferNumP+"/addr*"+OfferAddr);
					
				}else {
					JOptionPane.showMessageDialog(null,"빈칸 없이 입력하세요");
				}
			}
		});
		btnNewButton.setBounds(244, 416, 105, 27);
		contentPane.add(btnNewButton);
		
		
		setSize(410,670);
		setVisible(true);
	}
}
