package controller.登入系列;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.每周血糖紀錄頁;
import controller.選擇頁;
import model.用戶;
import service.impl.用戶serviceimpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class 登入頁 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField 帳號輸入;
	private JTextField 密碼輸入;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					登入頁 frame = new 登入頁();
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
	public 登入頁() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(44, 60, 348, 165);
		contentPane.add(panel);
		panel.setLayout(null);
		
		帳號輸入 = new JTextField();
		帳號輸入.setBounds(122, 40, 96, 20);
		panel.add(帳號輸入);
		帳號輸入.setColumns(10);
		
		密碼輸入 = new JTextField();
		密碼輸入.setBounds(122, 87, 96, 20);
		panel.add(密碼輸入);
		密碼輸入.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setBounds(67, 43, 45, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1.setBounds(67, 90, 45, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("血糖監測系統");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 19, 150, 31);
		contentPane.add(lblNewLabel);
		
		
		setLocationRelativeTo(null);
		/***************************/
		
		用戶serviceimpl 用戶serviceimpl=new 用戶serviceimpl();
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username=帳號輸入.getText();
				String Password=密碼輸入.getText();
				用戶 user=用戶serviceimpl.帳密確認用戶(Username,Password);
				
				if(user!=null)
				{
					Tool.saveObject(user.getUser_id(),"登入暫存檔");
					
					選擇頁 loginSuccess=new 選擇頁();
					loginSuccess.setVisible(true);
					dispose();
				}
				else
				{
					登入失敗頁 loginerror=new 登入失敗頁();
					loginerror.setVisible(true);
					dispose();
				}

			}
		});
		btnNewButton.setBounds(45, 133, 84, 22);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				註冊頁 註冊=new 註冊頁();
				註冊.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(194, 133, 84, 22);
		panel.add(btnNewButton_1);
		
		
		
	}

}
