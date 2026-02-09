package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.食物表dao;
import model.食物表;
import util.Tool;

public class 食物表daoimpl implements 食物表dao{
	Connection 連結=Tool.getDb();
	@Override
	public void 新增食物(食物表 食物) {
		String sql="insert into 食物 (食物名稱,GI值,好吃度) values (?,?,?)";
		String sql2="update 食物 set 食物代號=concat('f', lpad(last_insert_id(), 3, '0')) where id = last_insert_id();";
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			ps.setString(1,食物.get食物名稱());
			ps.setInt(2,食物.getGI值());
			ps.setDouble(3,食物.get好吃度());
			ps.executeUpdate();
			
			PreparedStatement ps2=連結.prepareStatement(sql2);
			ps2.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<食物表> 全食物() {
		String sql="select * from 食物";
		List<食物表> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					食物表 f=new 食物表();
						f.set食物代號(rs.getString("食物代號"));
						f.set食物名稱(rs.getString("食物名稱"));
						f.setGI值(rs.getInt("GI值"));
						f.set好吃度(rs.getDouble("好吃度"));
						l.add(f);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}

	@Override
	public List<食物表> id查食物(String 食物id) {
		String sql="select * from 食物 where 食物代號=?";
		List<食物表> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ps.setString(1,食物id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					食物表 f=new 食物表();
						f.set食物代號(rs.getString("食物代號"));
						f.set食物名稱(rs.getString("食物名稱"));
						f.setGI值(rs.getInt("GI值"));
						f.set好吃度(rs.getDouble("好吃度"));
						l.add(f);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}
	
	
	@Override
	public void 改食物內容(食物表 食物) {
			String sql="update 食物 set 食物名稱=?,GI值=?,好吃度=? where 食物代號=?";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			ps.setString(1,食物.get食物名稱());
			ps.setInt(2,食物.getGI值());
			ps.setDouble(3,食物.get好吃度());
			ps.setString(4,食物.get食物代號());
			
			
			int rows = ps.executeUpdate();
	        System.out.println("UPDATE 影響筆數 = " + rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
	

}
