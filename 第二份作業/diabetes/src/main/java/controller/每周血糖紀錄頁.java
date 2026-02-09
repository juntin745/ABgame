package controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import controller.食物系列.食物選擇頁;
import model.WeeklyHealth;

import service.impl.每周血糖表serviceimpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class 每周血糖紀錄頁 extends JFrame {

    private JPanel contentPane;
    private JTextField 血糖;
    private JTextField 收縮壓;
    private JTextField 舒張壓;
    private JTextField 脈搏;
    private JTextField 體重;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JTable 查詢顯示;
    private boolean 已新增本頁 = false;
    private JLabel 警告;

    

    public 每周血糖紀錄頁() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 475);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 128));
        panel_1.setBounds(10, 52, 611, 376);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
                JPanel panel = new JPanel();
                panel.setBounds(10, 26, 140, 30);
                panel_1.add(panel);
                panel.setBackground(new Color(255, 255, 255));
                panel.setLayout(null);
                
                JLabel lblNewLabel = new JLabel("日期");
                lblNewLabel.setBounds(10, 10, 45, 14);
                panel_1.add(lblNewLabel);
                
                血糖 = new JTextField();
                血糖.setBounds(155, 36, 72, 20);
                panel_1.add(血糖);
                血糖.setColumns(10);
                
                收縮壓 = new JTextField();
                收縮壓.setColumns(10);
                收縮壓.setBounds(237, 36, 72, 20);
                panel_1.add(收縮壓);
                
                舒張壓 = new JTextField();
                舒張壓.setColumns(10);
                舒張壓.setBounds(319, 36, 72, 20);
                panel_1.add(舒張壓);
                
                脈搏 = new JTextField();
                脈搏.setColumns(10);
                脈搏.setBounds(401, 36, 72, 20);
                panel_1.add(脈搏);
                
                體重 = new JTextField();
                體重.setColumns(10);
                體重.setBounds(479, 36, 72, 20);
                panel_1.add(體重);
                
                lblNewLabel_2 = new JLabel("血糖");
                lblNewLabel_2.setBounds(171, 10, 45, 14);
                panel_1.add(lblNewLabel_2);
                
                lblNewLabel_3 = new JLabel("收縮壓");
                lblNewLabel_3.setBounds(247, 10, 45, 14);
                panel_1.add(lblNewLabel_3);
                
                lblNewLabel_4 = new JLabel("舒張壓");
                lblNewLabel_4.setBounds(337, 10, 45, 14);
                panel_1.add(lblNewLabel_4);
                
                lblNewLabel_5 = new JLabel("脈搏");
                lblNewLabel_5.setBounds(418, 10, 45, 14);
                panel_1.add(lblNewLabel_5);
                
                lblNewLabel_6 = new JLabel("體重");
                lblNewLabel_6.setBounds(491, 10, 45, 14);
                panel_1.add(lblNewLabel_6);
                
                
                DefaultTableModel model = new DefaultTableModel(
        			    new Object[]{"日期", "血糖", "收縮壓", "舒張壓", "脈搏","體重"}, 0
        			);
        			查詢顯示 = new JTable(model);
        			JScrollPane scrollPane = new JScrollPane(查詢顯示);
        			scrollPane.setBounds(10, 77, 591, 207);
        			panel_1.add(scrollPane);
        		
               
                JLabel lblNewLabel_1 =new JLabel("每周健康表主表");
                lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
                lblNewLabel_1.setBounds(222, 10, 194, 40);
                contentPane.add(lblNewLabel_1);

        // 建立 DatePicker
        DatePickerSettings settings = new DatePickerSettings();
        panel.setLayout(null);
        DatePicker datePicker = new DatePicker(settings);
        datePicker.setBounds(0, 0, 140, 30);
        panel.add(datePicker);
        //陳致中
        setLocationRelativeTo(null);
        
        警告 = new JLabel("");
        警告.setBounds(389, 309, 132, 18);
        panel_1.add(警告);
        
        
        /************************************/
        // 讀回 UID（存檔時是 String）
        String userId = (String) Tool.readObject("登入暫存檔");
        
        每周血糖表serviceimpl svc=new 每周血糖表serviceimpl();
        
        
        JButton 查詢按鈕 = new JButton("查詢");
        查詢按鈕.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		List<WeeklyHealth> weekForm=svc.用戶查內容(userId);
				model.setRowCount(0);

				for (WeeklyHealth s : weekForm) {
				    model.addRow(new Object[]{
				        s.getDate(),
				        s.getBlood_sugar(),
				        s.getSystolic_blood_pressure(),
				        s.getDiastolic_blood_pressure(),
				        s.getPulse(),
				        s.getWeight()
				    });
				}
        	}
        });
        查詢按鈕.setBounds(10, 305, 84, 22);
        panel_1.add(查詢按鈕);
        
        JButton 新增按鈕 = new JButton("新增");
        新增按鈕.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(已新增本頁) {
        			警告.setText("你新增過了");
        		}else {

        		try {
	
        			int 糖糖=Integer.parseInt(血糖.getText());
        			int 紓壓=Integer.parseInt(舒張壓.getText());
        			int 縮壓=Integer.parseInt(收縮壓.getText());
        			int 賣賣=Integer.parseInt(脈搏.getText());
    				double 重重=Double.parseDouble(體重.getText());
        			WeeklyHealth 新週=new WeeklyHealth(datePicker.getDate(),糖糖,縮壓,紓壓,賣賣,重重,userId);
    				try {
    			        svc.新增每周血糖(新週); // 可能丟 Exception
    			        JOptionPane.showMessageDialog(null, "新增成功！");
    			        
    			        WeeklyHealth 重新撈取= new WeeklyHealth();
    			        	重新撈取=svc.用戶日期查內容(datePicker.getDate(), userId).get(0);
    			       
    			        
    			        Tool.saveObject(重新撈取.getWeek_id(),"週id");
    			    } catch (Exception ex) {
    			        JOptionPane.showMessageDialog(null, ex.getMessage()); // 顯示錯誤訊息，JOptionPane.showMessageDialog是用來跳出小框框
    			    }
    			} catch (NumberFormatException ex) {
    		        JOptionPane.showMessageDialog(null, "請輸入全數字");
    		        return;
    		    }
    			
    		}
    		
        	}
        });
        新增按鈕.setBounds(125, 305, 84, 22);
        panel_1.add(新增按鈕);
        
        JButton 修改按鈕 = new JButton("修改");
        修改按鈕.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
    				List<WeeklyHealth> 查要修改的日期 = svc.用戶日期查內容(datePicker.getDate(),userId);
    				if(查要修改的日期.isEmpty()) {
    				    JOptionPane.showMessageDialog(null, "該日期沒有資料可修改");
    				    return;
    				}else {
    					
    				
    		
    				WeeklyHealth weekFixDate=查要修改的日期.get(0);
    				try {
    				    if(!血糖.getText().isEmpty()) {
    				        weekFixDate.setBlood_sugar(Integer.parseInt(血糖.getText()));
    				    }
    				    if(!舒張壓.getText().isEmpty()) {
    				        weekFixDate.setSystolic_blood_pressure(Integer.parseInt(舒張壓.getText()));
    				    }
    				    if(!收縮壓.getText().isEmpty()) {
    				        weekFixDate.setDiastolic_blood_pressure(Integer.parseInt(收縮壓.getText()));
    				    }
    				    if(!脈搏.getText().isEmpty()) {
    				        weekFixDate.setPulse(Integer.parseInt(脈搏.getText()));
    				    }
    				    if(!體重.getText().isEmpty()) {
    				        weekFixDate.setWeight(Double.parseDouble(體重.getText()));
    				    }
    				} catch (NumberFormatException ex) {
    				    JOptionPane.showMessageDialog(null, "請勿輸入非數字");
    				    return;
    				}
    			
    				try {
    					svc.改資料(weekFixDate,userId);
    				} catch (Exception e1) {
    					// TODO Auto-generated catch block
    					JOptionPane.showMessageDialog(null,e1.getMessage());
    				}
    				}
        		
        		
        	}
        });
        修改按鈕.setBounds(237, 305, 84, 22);
        panel_1.add(修改按鈕);
        
        JButton 下一頁 = new JButton("下一頁");
        下一頁.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		食物選擇頁 食物選擇=new 食物選擇頁();
        		食物選擇.setVisible(true);
				dispose();
        		
        	}
        });
        下一頁.setBounds(506, 344, 84, 22);
        panel_1.add(下一頁);
        
        
        
    }
}
