package controller.睡眠系列;


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

public class 睡眠顯示 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable 查詢顯示;
    private JTextField 改時數;
    
   
    

    public 睡眠顯示(LocalDate 開開始日, LocalDate 結節束日) {
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

        JPanel 增加日期 = new JPanel();
        增加日期.setBounds(10, 30, 140, 26);
        panel.add(增加日期);
        增加日期.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        DatePickerSettings startSettings = new DatePickerSettings();
        DatePicker datePicker = new DatePicker(startSettings);
        增加日期.add(datePicker);

        JLabel lblNewLabel_2 = new JLabel("日期(上日期)");
        lblNewLabel_2.setBounds(10, 10, 101, 14);
        panel.add(lblNewLabel_2);

        JPanel 選日期 = new JPanel();
        選日期.setBounds(176, 33, 141, 23);
        panel.add(選日期);
        選日期.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        DatePickerSettings endSettings = new DatePickerSettings();
        DatePicker datePicker2 = new DatePicker(endSettings);
        選日期.add(datePicker2);
        // <span style="color:red;">新增/修正：確保 datePicker2 正確建立，不會紅字</span>

        JLabel lblNewLabel_2_2 = new JLabel("(下日期)");
        lblNewLabel_2_2.setBounds(176, 10, 141, 14);
        panel.add(lblNewLabel_2_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 128));
        panel_1.setBounds(10, 111, 697, 181);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"日期", "星期", "開始睡覺", "起床", "總時數"}, 0);
        查詢顯示 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(查詢顯示);
        scrollPane.setBounds(10, 10, 589, 161);
        panel_1.add(scrollPane);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(255, 255, 128));
        panel_1_1.setBounds(10, 302, 697, 82);
        contentPane.add(panel_1_1);
        panel_1_1.setLayout(null);

        JLabel lblNewLabel_2_1_2 = new JLabel("改睡覺開始時間");
        lblNewLabel_2_1_2.setBounds(201, 10, 95, 14);
        panel_1_1.add(lblNewLabel_2_1_2);

        JLabel lblNewLabel_2_1_1_1 = new JLabel("改睡覺結束時間");
        lblNewLabel_2_1_1_1.setBounds(350, 10, 96, 14);
        panel_1_1.add(lblNewLabel_2_1_1_1);

        JLabel lblNewLabel_1_1 = new JLabel("總睡眠時間");
        lblNewLabel_1_1.setBounds(507, 10, 77, 14);
        panel_1_1.add(lblNewLabel_1_1);

        JPanel 改開始 = new JPanel();
        改開始.setBounds(195, 34, 101, 23);
        panel_1_1.add(改開始);

        TimePickerSettings timeSettings2 = new TimePickerSettings();
        TimePicker 開始時間Picker2 = new TimePicker(timeSettings2);
        改開始.add(開始時間Picker2);

        JPanel 改結束 = new JPanel();
        改結束.setBounds(345, 34, 101, 23);
        panel_1_1.add(改結束);

        TimePickerSettings 結束2 = new TimePickerSettings();
        TimePicker 結束時間Picker2 = new TimePicker(結束2);
        改結束.add(結束時間Picker2);

        改時數 = new JTextField();
        改時數.setColumns(10);
        改時數.setBounds(487, 34, 96, 20);
        panel_1_1.add(改時數);

        JLabel lblNewLabel = new JLabel("每日睡眠紀錄");
        lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
        lblNewLabel.setBounds(297, 10, 159, 21);
        contentPane.add(lblNewLabel);

        setLocationRelativeTo(null);

        睡眠時間serviceimpl svc = new 睡眠時間serviceimpl();
        datePicker.setDate(開開始日);
        datePicker2.setDate(結節束日);
        
        
        List<睡眠時間> 查有資料 = svc.日期查睡眠時間(開開始日, 結節束日);
        model.setRowCount(0);
        for (睡眠時間 s : 查有資料) {
            model.addRow(new Object[]{
                    s.get日期(),
                    s.get星期(),
                    s.get開始睡覺時間(),
                    s.get起床時間(),
                    s.get總睡眠時數()
            });
        }

        if (!查有資料.isEmpty()) {
            睡眠時間 s = 查有資料.get(0);
            開始時間Picker2.setTime(s.get開始睡覺時間());
            結束時間Picker2.setTime(s.get起床時間());
            改時數.setText(String.valueOf(s.get總睡眠時數()));
            // <span style="color:red;">新增：自動填入修改區的時間和總時數</span>
        }

        JButton 修改按鈕 = new JButton("修改");
        修改按鈕.setBounds(603, 33, 84, 22);
        panel_1_1.add(修改按鈕);
        修改按鈕.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<睡眠時間> 查要修改的日期 = svc.日期查睡眠時間(datePicker2.getDate(), datePicker2.getDate());
                if (查要修改的日期.isEmpty()) return;
                睡眠時間 sleepFixDate = 查要修改的日期.get(0);

                if (開始時間Picker2.getTime() != null)
                    sleepFixDate.set開始睡覺時間(開始時間Picker2.getTime());
                if (結束時間Picker2.getTime() != null)
                    sleepFixDate.set起床時間(結束時間Picker2.getTime());

                if (!改時數.getText().equals("")) {
                    try {
                        double ch時數 = Double.parseDouble(改時數.getText());
                        sleepFixDate.set總睡眠時數(ch時數);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "總睡眠時數請輸入數字");
                        return;
                    }
                }

                try {
                    svc.改睡眠內容(sleepFixDate);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        JButton 查詢按鈕 = new JButton("查詢");
        查詢按鈕.setBounds(603, 10, 84, 22);
        panel_1.add(查詢按鈕);
        查詢按鈕.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LocalDate 開始日 = datePicker.getDate();
                LocalDate 結束日 = datePicker2.getDate();
                List<睡眠時間> 查有上下的日期;

                if (開始日 != null && 結束日 != null) {
                    查有上下的日期 = svc.日期查睡眠時間(開始日, 結束日);
                } else if (開始日 == null && 結束日 == null) {
                    查有上下的日期 = svc.全睡眠時間();
                } else if (開始日 == null) {
                    查有上下的日期 = svc.日期查睡眠時間(LocalDate.MIN, 結束日);
                } else {
                    查有上下的日期 = svc.日期查睡眠時間(開始日, LocalDate.parse("2999-12-31"));
                }

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
        });
    }
}
