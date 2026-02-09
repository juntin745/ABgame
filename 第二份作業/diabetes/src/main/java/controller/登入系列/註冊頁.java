package controller.登入系列;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.用戶;
import service.impl.用戶serviceimpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 註冊頁 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField 輸入名字;
	private JTextField 輸入註冊帳號;
	private JTextField 輸入註冊密碼;
	
	

	/**
	 * Launch the application.
	
	/**
	 * Create the frame.
	 */
	public 註冊頁() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(58, 59, 324, 194);
		panel.setBackground(new Color(255, 255, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		輸入名字 = new JTextField();
		輸入名字.setBounds(125, 28, 96, 20);
		panel.add(輸入名字);
		輸入名字.setColumns(10);
		
		輸入註冊帳號 = new JTextField();
		輸入註冊帳號.setColumns(10);
		輸入註冊帳號.setBounds(125, 63, 96, 20);
		panel.add(輸入註冊帳號);
		
		輸入註冊密碼 = new JTextField();
		輸入註冊密碼.setColumns(10);
		輸入註冊密碼.setBounds(125, 106, 96, 20);
		panel.add(輸入註冊密碼);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("用戶名稱");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(47, 31, 56, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("用戶帳號");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(50, 67, 56, 20);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("用戶密碼");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(53, 107, 56, 20);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel = new JLabel("註冊帳號");
		lblNewLabel.setBounds(168, 10, 147, 28);
		contentPane.add(lblNewLabel);
		
		
		JLabel 顯示 = new JLabel("");
		顯示.setBounds(32, 147, 136, 23);
		panel.add(顯示);
		
		
		
		/**********************************/

		/****************************/
		用戶serviceimpl 用戶Serviceimpl=new 用戶serviceimpl();
		
		JButton btnNewButton = new JButton("確定註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username=輸入註冊帳號.getText();
				boolean 是否存在=用戶Serviceimpl.帳號查用戶id(Username);
				
				if(!是否存在)
				{	
					String UserName=輸入註冊帳號.getText();
					String Password=輸入註冊密碼.getText();
					
					用戶 User=new 用戶(輸入名字.getText(),UserName,Password);
					用戶Serviceimpl.新增用戶(User);
					顯示.setText("註冊成功");

				}
				else if(輸入註冊帳號.getText().equals(""))
				{
					顯示.setText("帳號不可空白");
				}else
				{
					顯示.setText("已有相同帳號");
				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 12));
		btnNewButton.setBounds(183, 141, 104, 17);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回登入頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				登入頁 loginpage = new 登入頁();
			    loginpage.setVisible(true);
			    dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 12));
		btnNewButton_1.setBounds(183, 162, 104, 17);
		panel.add(btnNewButton_1);
		
		
		
	}
}
