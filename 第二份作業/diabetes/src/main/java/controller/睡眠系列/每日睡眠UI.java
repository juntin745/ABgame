package controller.睡眠系列;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import model.睡眠時間;
import service.impl.睡眠時間serviceimpl;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

public class 每日睡眠UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField 新增總時數;
	private JTable 查詢顯示;
	private JTextField 改時數;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public 每日睡眠UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(10, 41, 697, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		新增總時數 = new JTextField();
		新增總時數.setBounds(489, 30, 96, 20);
		panel.add(新增總時數);
		新增總時數.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("總睡眠時間");
		lblNewLabel_1.setBounds(508, 6, 77, 14);
		panel.add(lblNewLabel_1);
		
		JPanel 增加日期 = new JPanel();
		增加日期.setBounds(10, 30, 140, 26);
		panel.add(增加日期);
		
		// 建立 DatePicker
		增加日期.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // 自動排版
		DatePickerSettings settings = new DatePickerSettings();
		DatePicker datePicker = new DatePicker(settings);
		增加日期.add(datePicker);
		
		JPanel 增加開始 = new JPanel();
		增加開始.setBounds(205, 30, 101, 26);
		panel.add(增加開始);
		
		TimePickerSettings timeSettings = new TimePickerSettings();
		TimePicker 開始時間Picker = new TimePicker(timeSettings);
		開始時間Picker.setBounds(0, 0, 140, 30); // 放進 panel
		增加開始.add(開始時間Picker);
		
		JPanel 增加結束 = new JPanel();
		增加結束.setBounds(350, 30, 101, 26);
		panel.add(增加結束);
		
		TimePickerSettings 結束 = new TimePickerSettings();
		TimePicker 結束時間Picker = new TimePicker(結束);
		結束時間Picker.setBounds(0, 0, 140, 30); // 放進 panel
		增加結束.add(結束時間Picker);
		
		JLabel lblNewLabel_2 = new JLabel("日期(上日期)");
		lblNewLabel_2.setBounds(10, 10, 101, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("睡覺開始時間");
		lblNewLabel_2_1.setBounds(215, 10, 72, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("睡覺結束時間");
		lblNewLabel_2_1_1.setBounds(346, 10, 72, 14);
		panel.add(lblNewLabel_2_1_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(10, 111, 697, 181);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		//桌子!()要對應上面的框框
		DefaultTableModel model = new DefaultTableModel(
			    new Object[]{"日期", "星期", "開始睡覺", "起床", "總時數"}, 0
			);
		查詢顯示 = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(查詢顯示);
		scrollPane.setBounds(10, 10, 589, 161);
		panel_1.add(scrollPane);
		
		
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 128));
		panel_1_1.setBounds(10, 302, 697, 82);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("選要改的日期(下日期)");
		lblNewLabel_2_2.setBounds(10, 10, 141, 14);
		panel_1_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("改睡覺開始時間");
		lblNewLabel_2_1_2.setBounds(201, 10, 95, 14);
		panel_1_1.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("改睡覺結束時間");
		lblNewLabel_2_1_1_1.setBounds(350, 10, 96, 14);
		panel_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("總睡眠時間");
		lblNewLabel_1_1.setBounds(507, 10, 77, 14);
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel 選日期 = new JPanel();
		選日期.setBounds(10, 33, 141, 23);
		panel_1_1.add(選日期);
		
		// 建立 DatePicker
		選日期.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // 自動排版
		DatePickerSettings settings2 = new DatePickerSettings();
		DatePicker datePicker2 = new DatePicker(settings2);
		選日期.add(datePicker2);
		
		
		JPanel 改開始 = new JPanel();
		改開始.setBounds(195, 34, 101, 23);
		panel_1_1.add(改開始);
		
		TimePickerSettings timeSettings2 = new TimePickerSettings();
		TimePicker 開始時間Picker2 = new TimePicker(timeSettings2);
		開始時間Picker2.setBounds(0, 0, 140, 30); // 放進 panel
		改開始.add(開始時間Picker2);
		
		JPanel 改結束 = new JPanel();
		改結束.setBounds(345, 34, 101, 23);
		panel_1_1.add(改結束);
		
		TimePickerSettings 結束2 = new TimePickerSettings();
		TimePicker 結束時間Picker2 = new TimePicker(結束2);
		結束時間Picker2.setBounds(0, 0, 140, 30); // 放進 panel
		改結束.add(結束時間Picker2);
		
		
		改時數 = new JTextField();
		改時數.setColumns(10);
		改時數.setBounds(487, 34, 96, 20);
		panel_1_1.add(改時數);
		
		
		
		JLabel lblNewLabel = new JLabel("每日睡眠紀錄");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(297, 10, 159, 21);
		contentPane.add(lblNewLabel);
		//陳致中
        setLocationRelativeTo(null);
		
		/*************************************/
        睡眠時間serviceimpl svc=new 睡眠時間serviceimpl();
        
		JButton 新增按鈕 = new JButton("新增");
		新增按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
				double 睡眠時數=Double.parseDouble(新增總時數.getText());
				睡眠時間 新睡眠=new 睡眠時間(datePicker.getDate(),開始時間Picker.getTime(),結束時間Picker.getTime(),睡眠時數);
				try {
			        svc.新增睡覺(新睡眠); // 可能丟 Exception
			        JOptionPane.showMessageDialog(null, "新增成功！");
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, ex.getMessage()); // 顯示錯誤訊息，JOptionPane.showMessageDialog是用來跳出小框框
			    }
			} catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "總睡眠時數請輸入數字！");
		        return;
		    }
				
				
				
				
			}
		});
		新增按鈕.setBounds(603, 29, 84, 22);
		panel.add(新增按鈕);
		
		
		JButton 修改按鈕 = new JButton("修改");
		修改按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<睡眠時間> 查要修改的日期 = svc.日期查睡眠時間(datePicker2.getDate(), datePicker2.getDate());
				
		
				睡眠時間 sleepFixDate=查要修改的日期.get(0);
				

				if(開始時間Picker2.getTime()!=null) sleepFixDate.set開始睡覺時間(開始時間Picker2.getTime());

				if(結束時間Picker2.getTime()!=null)
				{
					
					sleepFixDate.set起床時間(結束時間Picker2.getTime());
				}
				if(!改時數.getText().equals(""))
				{
				try {
					double ch時數=Double.parseDouble(改時數.getText());
					sleepFixDate.set總睡眠時數(ch時數);
					
				} catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null, "總睡眠時數請輸入數字");
			        return;
			    }
				}
			
				try {
					svc.改睡眠內容(sleepFixDate);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				}
				
			
		});
		修改按鈕.setBounds(603, 33, 84, 22);
		panel_1_1.add(修改按鈕);
		

		JButton 查詢按鈕 = new JButton("查詢");
		查詢按鈕.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LocalDate 開始日 = datePicker.getDate();
				LocalDate 結束日 = datePicker2.getDate();
				if(datePicker.getDate()!=null&&datePicker2.getDate()!=null)
				{
					List<睡眠時間> 查有上下的日期 = svc.日期查睡眠時間(datePicker.getDate(), datePicker2.getDate());
					model.setRowCount(0);

					for (睡眠時間 s : 查有上下的日期) {
					    model.addRow(new Object[]{
					        s.get日期(),
					        s.get星期(),
					        s.get開始睡覺時間(),
					        s.get起床時間(),
					        s.get總睡眠時數()
					    });
					}
					
				}else if(datePicker2.getDate()==null&&datePicker.getDate()==null) {
					List<睡眠時間> sleepForm=svc.全睡眠時間();
					model.setRowCount(0);

					for (睡眠時間 s : sleepForm) {
					    model.addRow(new Object[]{
					        s.get日期(),
					        s.get星期(),
					        s.get開始睡覺時間(),
					        s.get起床時間(),
					        s.get總睡眠時數()
					    });
					}
					
				}else if(開始日==null) {
					
					開始日=LocalDate.MIN;
					List<睡眠時間> 查有上下的日期 = svc.日期查睡眠時間(開始日, datePicker2.getDate());
					model.setRowCount(0);

					for (睡眠時間 s : 查有上下的日期) {
					    model.addRow(new Object[]{
					        s.get日期(),
					        s.get星期(),
					        s.get開始睡覺時間(),
					        s.get起床時間(),
					        s.get總睡眠時數()
					    });
					}
				}else{
					
					結束日 = LocalDate.parse("2999-12-31");
					List<睡眠時間> 查有上下的日期 = svc.日期查睡眠時間(datePicker.getDate(),結束日);
					model.setRowCount(0);

					for (睡眠時間 s : 查有上下的日期) {
					    model.addRow(new Object[]{
					        s.get日期(),
					        s.get星期(),
					        s.get開始睡覺時間(),
					        s.get起床時間(),
					        s.get總睡眠時數()
					    });
					}
				}		
			}
		});
		
		查詢按鈕.setBounds(603, 10, 84, 22);
		panel_1.add(查詢按鈕);
		
	}
}
