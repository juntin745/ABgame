package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.WeeklyHealthdao;
import model.WeeklyHealth;
import util.Tool;

public class WeeklyHealthdaoimpl implements WeeklyHealthdao{
	Connection 連結=Tool.getDb();
	@Override
	public void 新增每周血糖(WeeklyHealth weeklyHealth) {
		String sql="insert into 健康紀錄表 (週ID,日期,血糖值,收縮壓,舒張壓,脈搏,體重,用戶id) "
				+ "values (concat('w', lpad(last_insert_id(), 3, '0')),?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			ps.setDate(1,java.sql.Date.valueOf(weeklyHealth.getDate()));
			ps.setInt(2,weeklyHealth.getBlood_sugar());
			ps.setInt(3,weeklyHealth.getSystolic_blood_pressure());
			ps.setInt(4,weeklyHealth.getDiastolic_blood_pressure());
			ps.setInt(5,weeklyHealth.getPulse());
			ps.setDouble(6,weeklyHealth.getWeight());
			ps.setString(7,weeklyHealth.get用戶id());
			//ps.setString(1,);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<WeeklyHealth> 全內容() {
		String sql="select * from 健康紀錄表";
		List<WeeklyHealth> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					WeeklyHealth s=new WeeklyHealth();
						s.setDate(rs.getDate("日期").toLocalDate());
						s.setSystolic_blood_pressure(rs.getInt("收縮壓"));
						s.setDiastolic_blood_pressure(rs.getInt("舒張壓"));
						s.setPulse(rs.getInt("脈搏"));
						s.setWeight(rs.getDouble("體重"));
						l.add(s);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}
	
	public List<WeeklyHealth> 用戶查內容(String 用戶id) {
		String sql="select * from 健康紀錄表 where 用戶id=?";
		List<WeeklyHealth> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ps.setString(1,用戶id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					WeeklyHealth s=new WeeklyHealth();
						s.setDate(rs.getDate("日期").toLocalDate());
						s.setBlood_sugar(rs.getInt("血糖值"));
						s.setSystolic_blood_pressure(rs.getInt("收縮壓"));
						s.setDiastolic_blood_pressure(rs.getInt("舒張壓"));
						s.setPulse(rs.getInt("脈搏"));
						s.setWeight(rs.getDouble("體重"));
						l.add(s);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}
	
	
	@Override
	public List<WeeklyHealth> 用戶日期查內容(LocalDate 日期, String 用戶id) {
		String sql="select * from 健康紀錄表 where 用戶id=? and 日期=?";
		List<WeeklyHealth> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ps.setString(1,用戶id);
				ps.setDate(2,java.sql.Date.valueOf(日期));
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					WeeklyHealth s=new WeeklyHealth();
						s.setWeek_id(rs.getString("週ID"));
						s.setDate(rs.getDate("日期").toLocalDate());
						s.setBlood_sugar(rs.getInt("血糖值"));
						s.setSystolic_blood_pressure(rs.getInt("收縮壓"));
						s.setDiastolic_blood_pressure(rs.getInt("舒張壓"));
						s.setPulse(rs.getInt("脈搏"));
						s.setWeight(rs.getDouble("體重"));
						l.add(s);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}
	
	
	
	@Override
	public void 改資料(WeeklyHealth weeklyHealth,String 用戶id) {
		String sql="update 健康紀錄表 set 血糖值=?,收縮壓=?,舒張壓=?,脈搏=?,體重=? where 日期=? and 用戶id=?";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			
			ps.setInt(1,weeklyHealth.getBlood_sugar());
			ps.setInt(2,weeklyHealth.getSystolic_blood_pressure());
			ps.setInt(3,weeklyHealth.getDiastolic_blood_pressure());
			ps.setInt(4,weeklyHealth.getPulse());
			ps.setDouble(5,weeklyHealth.getWeight());
			ps.setDate(6,java.sql.Date.valueOf(weeklyHealth.getDate()));
			ps.setString(7,weeklyHealth.get用戶id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
