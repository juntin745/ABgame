package controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import controller.登入系列.註冊頁;
import controller.睡眠系列.睡眠顯示;
import model.WeeklyHealth;
import model.睡眠時間;
import util.Tool;
import 總表vo.健康週總大表VOdaoimpl;
import 總表vo.健康週總表VO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

public class 超級總表 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    

    public 超級總表() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 690, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("大總表");
        title.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        title.setBounds(286, 10, 113, 38);
        contentPane.add(title);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 128));
        panel.setBounds(10, 58, 654, 442);
        panel.setLayout(null);
        contentPane.add(panel);

        
        JPanel panelStart = new JPanel();
        panelStart.setBounds(10, 10, 142, 30);
        panelStart.setLayout(null);
        panel.add(panelStart);

        DatePickerSettings startSettings = new DatePickerSettings();
        DatePicker startDatePicker = new DatePicker(startSettings);
        startDatePicker.setBounds(0, 0, 142, 30);
        panelStart.add(startDatePicker);

        
        JPanel panelEnd = new JPanel();
        panelEnd.setBounds(177, 10, 142, 30);
        panelEnd.setLayout(null);
        panel.add(panelEnd);

        DatePickerSettings endSettings = new DatePickerSettings();
        DatePicker endDatePicker = new DatePicker(endSettings);
        endDatePicker.setBounds(0, 0, 142, 30);
        panelEnd.add(endDatePicker);
        

        DefaultTableModel model = new DefaultTableModel(
            new Object[]{
                "日期","血糖","收縮壓","舒張壓","脈搏","體重","運動名稱","單位","時間","食物名稱","次數"},0
        );

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 634, 382);
        panel.add(scrollPane);

        setLocationRelativeTo(null);

        /***************************************/
        String userId = (String) Tool.readObject("登入暫存檔");
        健康週總大表VOdaoimpl svc=new 健康週總大表VOdaoimpl();
        System.out.println("userId=" + userId);

        JButton 查詢 = new JButton("查詢");
        查詢.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.println("start: " + startDatePicker.getDate() + ", end: " + endDatePicker.getDate() + ", userId: " + userId);

        		LocalDate 開始日 = startDatePicker.getDate();
        		LocalDate 結束日 = endDatePicker.getDate();

        		if (開始日 != null && 結束日 != null) {
        		    List<健康週總表VO> weekForm = svc.查詢日期範圍(開始日, 結束日, userId);
        		    model.setRowCount(0);
        		    for (健康週總表VO s : weekForm) {
        		        model.addRow(new Object[]{
        		            s.get日期(), s.get血糖值(), s.get收縮壓(), s.get舒張壓(),
        		            s.get脈搏(), s.get體重(), s.get運動名稱(), s.get單位(),
        		            s.get時間(), s.get食物名稱(), s.get次數()
        		        });
        		    }
        		} else if (開始日 == null && 結束日 == null) { // ← 兩個都沒填
        		    LocalDate start = LocalDate.MIN;
        		    LocalDate end =LocalDate.parse("2999-12-31");
        		    List<健康週總表VO> weekForm = svc.查詢日期範圍(start, end, userId);
        		    model.setRowCount(0);
        		    for (健康週總表VO s : weekForm) {
        		        model.addRow(new Object[]{
        		            s.get日期(), s.get血糖值(), s.get收縮壓(), s.get舒張壓(),
        		            s.get脈搏(), s.get體重(), s.get運動名稱(), s.get單位(),
        		            s.get時間(), s.get食物名稱(), s.get次數()
        		        });
        		    }
        		} else if (開始日 == null) { // 只有結束日填了
        		    LocalDate start = LocalDate.MIN;
        		    List<健康週總表VO> weekForm = svc.查詢日期範圍(start, 結束日, userId);
        		    model.setRowCount(0);
        		    for (健康週總表VO s : weekForm) {
        		        model.addRow(new Object[]{
        		            s.get日期(), s.get血糖值(), s.get收縮壓(), s.get舒張壓(),
        		            s.get脈搏(), s.get體重(), s.get運動名稱(), s.get單位(),
        		            s.get時間(), s.get食物名稱(), s.get次數()
        		        });
        		    }
        		} else { // 只有開始日填了
        		    LocalDate end =LocalDate.parse("2999-12-31");
        		    List<健康週總表VO> weekForm = svc.查詢日期範圍(開始日, end, userId);
        		    model.setRowCount(0);
        		    for (健康週總表VO s : weekForm) {
        		        model.addRow(new Object[]{
        		            s.get日期(), s.get血糖值(), s.get收縮壓(), s.get舒張壓(),
        		            s.get脈搏(), s.get體重(), s.get運動名稱(), s.get單位(),
        		            s.get時間(), s.get食物名稱(), s.get次數()
        		        });
        		    }
        		}

        		    
		
        	}
        });
        查詢.setBounds(329, 17, 66, 23);
        panel.add(查詢);

        JButton 睡眠 = new JButton("睡眠");
        睡眠.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
                int row = table.getSelectedRow();
                if (row == -1) {
                    // 改這裡
                    JOptionPane.showMessageDialog(超級總表.this, "請先選一筆資料");
                    return;
                }
             LocalDate 選取日期 = (LocalDate) table.getValueAt(row, 0);
             LocalDate 開始日 = 選取日期.minusDays(7);
             LocalDate 結束日 = 選取日期;

             睡眠顯示 註冊 = new 睡眠顯示(開始日, 結束日); 
             註冊.setVisible(true);
				
        	}
        });
        睡眠.setBounds(578, 17, 66, 23);
        panel.add(睡眠);

        
    }
}
