package controller.食物系列;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.食物表;
import service.impl.食物表serviceimpl;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JScrollPane;

public class 新增食物UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField 增加食物名;
	private JTextField 增加GI值;
	private JTextField 增加好吃度;
	private JTextField 查詢代碼;
	private JTextField 改名稱;
	private JTextField 改GI值;
	private JTextField 改好吃度;
	private 食物選擇頁 選擇頁物件;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public 新增食物UI(食物選擇頁 選擇頁物件) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(10, 40, 416, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		增加食物名 = new JTextField();
		增加食物名.setBounds(57, 10, 96, 20);
		panel.add(增加食物名);
		增加食物名.setColumns(10);
		
		增加GI值 = new JTextField();
		增加GI值.setBounds(189, 10, 45, 20);
		panel.add(增加GI值);
		增加GI值.setColumns(10);
		
		增加好吃度 = new JTextField();
		增加好吃度.setBounds(278, 10, 45, 20);
		panel.add(增加好吃度);
		增加好吃度.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("食物名稱");
		lblNewLabel_1.setBounds(2, 13, 68, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GI值");
		lblNewLabel_1_1.setBounds(163, 13, 32, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("好吃度");
		lblNewLabel_1_1_1.setBounds(238, 13, 45, 14);
		panel.add(lblNewLabel_1_1_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(10, 93, 401, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 128));
		panel_1_1.setBounds(10, 238, 401, 70);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		查詢代碼 = new JTextField();
		查詢代碼.setBounds(63, 10, 96, 20);
		panel_1_1.add(查詢代碼);
		查詢代碼.setColumns(10);
		
		改名稱 = new JTextField();
		改名稱.setBounds(51, 40, 96, 20);
		panel_1_1.add(改名稱);
		改名稱.setColumns(10);
		
		改GI值 = new JTextField();
		改GI值.setColumns(10);
		改GI值.setBounds(215, 40, 40, 20);
		panel_1_1.add(改GI值);
		
		改好吃度 = new JTextField();
		改好吃度.setColumns(10);
		改好吃度.setBounds(336, 40, 45, 20);
		panel_1_1.add(改好吃度);
		
		JLabel lblNewLabel_2 = new JLabel("目標代號");
		lblNewLabel_2.setBounds(10, 13, 72, 14);
		panel_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("改名稱");
		lblNewLabel_2_1.setBounds(10, 43, 72, 14);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("改GI值");
		lblNewLabel_2_1_1.setBounds(171, 43, 72, 14);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("改好吃度");
		lblNewLabel_2_1_1_1.setBounds(283, 43, 72, 14);
		panel_1_1.add(lblNewLabel_2_1_1_1);
		
		
		
		JLabel lblNewLabel = new JLabel("新增與修改食物");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel.setBounds(171, 10, 159, 20);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 381, 94);
		panel_1.add(scrollPane);
		
		JTextArea 顯示查詢 = new JTextArea();
		scrollPane.setViewportView(顯示查詢);
		
		/**************************/
		
		食物表serviceimpl svc=new 食物表serviceimpl();
		
		
		JButton 修改按鈕 = new JButton("確定修改");
		修改按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("點到按鈕了");
				
				
				List<食物表> foodFromId=svc.id查食物(查詢代碼.getText());
				System.out.println("查詢回來的 list 大小 = " + foodFromId.size());
				食物表 ffi=foodFromId.get(0);
				if(!改名稱.getText().equals("")) ffi.set食物名稱(改名稱.getText());
				if(!改GI值.getText().equals(""))
				{
					int gi=Integer.parseInt(改GI值.getText());
					ffi.setGI值(gi);
				}
				if(!改好吃度.getText().equals(""))
				{
					double 好吃=Double.parseDouble(改好吃度.getText());
					ffi.set好吃度(好吃);
				}
				System.out.println("送到修改方法的代號 = '" + ffi.get食物代號() + "'");
				svc.改食物內容(ffi);
			}
		});
		修改按鈕.setBounds(297, 9, 84, 22);
		panel_1_1.add(修改按鈕);
		
		JButton 新增按鈕 = new JButton("新增");
		新增按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int gi=Integer.parseInt(增加GI值.getText());
				double 好吃度=Double.parseDouble(增加好吃度.getText());
				
				食物表 新食物=new 食物表(增加食物名.getText(),gi,好吃度);
				svc.新增食物(新食物);
				
			}
		});
		新增按鈕.setFont(new Font("新細明體", Font.PLAIN, 10));
		新增按鈕.setBounds(333, 10, 60, 22);
		panel.add(新增按鈕);
		
		JButton 查詢按鈕 = new JButton("查詢");
		查詢按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<食物表> foodForm=svc.全食物();
				String show="";
				
				for(食物表 ffs:foodForm)
				{
					show=show+"id:"+ffs.get食物代號()+
							"    名稱:"+ffs.get食物名稱()+
							"\tGI值:"+ffs.getGI值()+
							"    好吃度:"+ffs.get好吃度()+
							"\n";
				}
				顯示查詢.setText(show);
				
			}
		});
		查詢按鈕.setBounds(331, 5, 60, 22);
		panel_1.add(查詢按鈕);
		查詢按鈕.setFont(new Font("新細明體", Font.PLAIN, 10));
		
		JButton 返回 = new JButton("關閉");
		返回.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				選擇頁物件.refreshFoodComboBox(); // 刷新現有頁面的選單
			    dispose(); 
				
			}
		});
		返回.setBounds(340, 7, 87, 23);
		contentPane.add(返回);
		
		

	}
}
