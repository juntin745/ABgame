package controller.運動系列;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.超級總表;
import model.運動;
import model.運動連接表;
import service.impl.運動serviceimpl;
import service.impl.運動連接表serviceimpl;
import util.Tool;

public class 運動選擇頁 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable 查詢顯示;
	private JTextField 輸入數量;
	private JComboBox<運動> 選單;
	private JTextField 輸入分鐘;

	/**
	 * Launch the application.

	
	
	
	/**
	 * Create the frame.
	 */
	public 運動選擇頁() {
		  String userId = (String) Tool.readObject("登入暫存檔");
			
		  String 週ID = (String) Tool.readObject("週id");
		  
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(10, 42, 518, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		輸入數量 = new JTextField();
		輸入數量.setBounds(295, 10, 50, 21);
		panel.add(輸入數量);
		輸入數量.setColumns(10);
		
		
		/**********做選單*********/
		運動serviceimpl fsvc=new 運動serviceimpl();

		List<運動> foods = fsvc.全運動();
	
		選單 = new JComboBox<>();
		選單.setBounds(91, 9, 119, 23);
		panel.add(選單);
		
		for (運動 f : foods) {
			選單.addItem(f);
		}
		/****************************/
		
		JLabel lblNewLabel_1 = new JLabel("單位對應數量:");
		lblNewLabel_1.setBounds(215, 11, 81, 18);
		panel.add(lblNewLabel_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(10, 97, 518, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		/***桌子*/
		DefaultTableModel model = new DefaultTableModel(
			    new Object[]{"運動名稱","數量","分鐘"}, 0
			);
			查詢顯示 = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(查詢顯示);
			scrollPane.setBounds(10, 10, 428, 197);
			panel_1.add(scrollPane);
		
		
		JLabel lblNewLabel = new JLabel("本周有沒有運動阿?");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 19));
		lblNewLabel.setBounds(191, 2, 222, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("分鐘");
		lblNewLabel_2.setBounds(350, 13, 29, 15);
		panel.add(lblNewLabel_2);
		
		輸入分鐘 = new JTextField();
		輸入分鐘.setBounds(379, 10, 65, 21);
		panel.add(輸入分鐘);
		輸入分鐘.setColumns(10);
		

		/*****************************/
		運動連接表serviceimpl svc=new 運動連接表serviceimpl();
		
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
		刪除按鈕.setBounds(448, 14, 60, 23);
		panel_1.add(刪除按鈕);
		
		JButton 下一頁 = new JButton("確定");
		下一頁.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int 行 = 查詢顯示.getRowCount();
				for (int i = 0; i < 行; i++) {
					運動 food = (運動) model.getValueAt(i, 0); 
					double 數量 = Double.parseDouble(model.getValueAt(i, 1).toString());
					double 分鐘 = Double.parseDouble(model.getValueAt(i, 2).toString());
				    // 建立橋接表物件
				    運動連接表 連接表 = new 運動連接表(userId,週ID, food.get運動代號(), 數量,分鐘);

				    //  存入
				    svc.新增週運動(連接表);
				    
				    
				}
				超級總表 超級總表=new 超級總表();
			    超級總表.setVisible(true);
				dispose();
				
			}
		});
		下一頁.setFont(new Font("新細明體", Font.PLAIN, 10));
		下一頁.setBounds(448, 184, 60, 23);
		panel_1.add(下一頁);

		JButton 修改按鈕 = new JButton("修改");
		修改按鈕.setBounds(449, 58, 59, 23);
		panel_1.add(修改按鈕);
		修改按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int 目標行 = 查詢顯示.getRowCount();
				if (目標行 != -1) {
		                model.setValueAt(Double.parseDouble(輸入數量.getText()), 目標行, 1); // 更新第二欄（數量欄）
				} else {
				    JOptionPane.showMessageDialog(null, "請先點要動的那一行");
				}
				
			}
		});
		修改按鈕.setFont(new Font("新細明體", Font.PLAIN, 10));
		
		JButton 加入按鈕 = new JButton("加入");
		加入按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double 數數;
				double 分鐘;
		        try {
		        	數數= Double.parseDouble(輸入數量.getText());
		        	分鐘= Double.parseDouble(輸入分鐘.getText());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "數量請輸入數字");
		            return;
		        }
		        運動 food = (運動) 選單.getSelectedItem();
				model.addRow(new Object[]{
						food,   // 顯示名字
			            數數,                  // 顯示數量
			            分鐘
			        });
				
			}
		});
		加入按鈕.setFont(new Font("新細明體", Font.PLAIN, 10));
		加入按鈕.setBounds(450, 10, 58, 23);
		panel.add(加入按鈕);
		
		JButton 切換增加運動 = new JButton("更多運動");
		切換增加運動.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				新增運動UI 新增運動=new 新增運動UI(運動選擇頁.this);
				新增運動.setVisible(true);
			}
		});
		切換增加運動.setFont(new Font("新細明體", Font.PLAIN, 10));
		切換增加運動.setBounds(8, 10, 81, 22);
		panel.add(切換增加運動);
		
		
	}
	
	public void refreshFoodComboBox() {
	    選單.removeAllItems();
	    運動serviceimpl fsvc = new 運動serviceimpl();
	    List<運動> foods = fsvc.全運動();
	    for (運動 f : foods) {
	        選單.addItem(f);
	    }
	}
}
