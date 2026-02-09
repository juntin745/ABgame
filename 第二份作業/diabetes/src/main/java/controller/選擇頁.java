package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.睡眠系列.每日睡眠UI;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 選擇頁 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public 選擇頁() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton 血糖 = new JButton("每週健康大表");
		血糖.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				每周血糖紀錄頁 每周血糖紀錄頁=new 每周血糖紀錄頁();
				每周血糖紀錄頁.setVisible(true);
				dispose();
			}
		});
		血糖.setBounds(136, 80, 130, 23);
		contentPane.add(血糖);
		
		JButton 睡覺 = new JButton("每日睡眠表");
		睡覺.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				每日睡眠UI 每日睡眠UI=new 每日睡眠UI();
				每日睡眠UI.setVisible(true);
				dispose();
				
				
			}
		});
		睡覺.setBounds(136, 159, 113, 23);
		contentPane.add(睡覺);

	}

}
