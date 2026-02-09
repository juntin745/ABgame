package controller.食物系列;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.運動系列.運動選擇頁;
import model.食物表;
import model.食物連接表;
import service.impl.食物表serviceimpl;
import service.impl.食物連接表serviceimpl;
import util.Tool;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 食物選擇頁 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable 查詢顯示;
	private JTextField 輸入數量;
	private JComboBox<食物表> 選單;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public 食物選擇頁() {
		  String userId = (String) Tool.readObject("登入暫存檔");
			
		  String 週ID = (String) Tool.readObject("週id");
		  
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(25, 42, 447, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		輸入數量 = new JTextField();
		輸入數量.setBounds(244, 10, 50, 21);
		panel.add(輸入數量);
		輸入數量.setColumns(10);
		
		
		/**********做選單*********/
		食物表serviceimpl fsvc=new 食物表serviceimpl();

		List<食物表> foods = fsvc.全食物();
	
		選單 = new JComboBox<>();
		選單.setBounds(91, 9, 119, 23);
		panel.add(選單);
		
		for (食物表 f : foods) {
			選單.addItem(f);
		}
		/****************************/
		
		JLabel lblNewLabel_1 = new JLabel("數量:");
		lblNewLabel_1.setBounds(212, 11, 33, 18);
		panel.add(lblNewLabel_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(25, 97, 447, 181);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		/***桌子*/
		DefaultTableModel model = new DefaultTableModel(
			    new Object[]{"食物名稱", "數量"}, 0
			);
			查詢顯示 = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(查詢顯示);
			scrollPane.setBounds(10, 10, 364, 161);
			panel_1.add(scrollPane);
		
		
		JLabel lblNewLabel = new JLabel("本周吃了啥特別的阿?");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 19));
		lblNewLabel.setBounds(151, 10, 222, 30);
		contentPane.add(lblNewLabel);
		

		/*****************************/
		食物連接表serviceimpl svc=new 食物連接表serviceimpl();
		
		JButton 刪除按鈕 = new JButton("刪除");
		刪除按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int 目標行 = 查詢顯示.getSelectedRow();
				if (目標行 != -1) {
				    model.removeRow(目標行);  
				} else {
				    JOptionPane.showMessageDialog(null, "請先點要動的那一行");
				}
				
			}
		});
		刪除按鈕.setFont(new Font("新細明體", Font.PLAIN, 10));
		刪除按鈕.setBounds(380, 14, 60, 23);
		panel_1.add(刪除按鈕);
		
		JButton 下一頁 = new JButton("確定");
		下一頁.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("目前週ID = [" + 週ID + "]");
				int 行 = 查詢顯示.getRowCount();
				for (int i = 0; i < 行; i++) {
				    食物表 food = (食物表) model.getValueAt(i, 0);  // 第 0 欄存的是食物物件
				    int 數量 = (int) model.getValueAt(i, 1);         // 第 1 欄存的是數量

				    // 建立橋接表物件
				    食物連接表 連接表 = new 食物連接表(userId,週ID, food.get食物代號(), 數量);

				    //  存入
				    svc.新增週食物(連接表);

				}
				運動選擇頁 運動選擇頁=new 運動選擇頁();
				運動選擇頁.setVisible(true);
				dispose();
				
			}
		});
		下一頁.setFont(new Font("新細明體", Font.PLAIN, 10));
		下一頁.setBounds(380, 148, 60, 23);
		panel_1.add(下一頁);

		JButton 修改按鈕 = new JButton("修改");
		修改按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int 目標行 = 查詢顯示.getSelectedRow();
				if (目標行 != -1) {
		                model.setValueAt(Integer.parseInt(輸入數量.getText()), 目標行, 1); // 更新第二欄（數量欄）
				} else {
				    JOptionPane.showMessageDialog(null, "請先點要動的那一行");
				}
				
			}
		});
		修改按鈕.setBounds(372, 10, 59, 23);
		panel.add(修改按鈕);
		修改按鈕.setFont(new Font("新細明體", Font.PLAIN, 10));
		
		JButton 加入按鈕 = new JButton("加入");
		加入按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int 數數;
		        try {
		        	數數= Integer.parseInt(輸入數量.getText());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "數量請輸入數字");
		            return;
		        }
		        食物表 food = (食物表) 選單.getSelectedItem();
				model.addRow(new Object[]{
						food,   // 顯示名字
			     
			            數數                  // 顯示數量
			        });
				
			}
		});
		加入按鈕.setFont(new Font("新細明體", Font.PLAIN, 10));
		加入按鈕.setBounds(304, 10, 58, 23);
		panel.add(加入按鈕);
		
		JButton 切換增加食物 = new JButton("更多食物");
		切換增加食物.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				新增食物UI 新增食物=new 新增食物UI(食物選擇頁.this);
				新增食物.setVisible(true);
			}
		});
		切換增加食物.setFont(new Font("新細明體", Font.PLAIN, 10));
		切換增加食物.setBounds(8, 10, 81, 22);
		panel.add(切換增加食物);
	}
	
	public void refreshFoodComboBox() {
	    選單.removeAllItems();
	    食物表serviceimpl fsvc = new 食物表serviceimpl();
	    List<食物表> foods = fsvc.全食物();
	    for (食物表 f : foods) {
	        選單.addItem(f);
	    }
	}
	
}
