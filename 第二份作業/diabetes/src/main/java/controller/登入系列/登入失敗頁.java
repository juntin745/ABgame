package controller.登入系列;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 登入失敗頁 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public 登入失敗頁() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("帳號密碼錯誤");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(133, 36, 182, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("再試一次");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				登入頁 登入=new 登入頁();
				登入.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(83, 144, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊新帳號");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				註冊頁 註冊=new 註冊頁();
				註冊.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(251, 144, 115, 22);
		contentPane.add(btnNewButton_1);

	}

}
