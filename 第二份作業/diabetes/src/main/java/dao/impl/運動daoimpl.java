package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.運動dao;
import model.運動;

import util.Tool;

public class 運動daoimpl implements 運動dao{
	Connection 連結=Tool.getDb();
	@Override
	public void 新增食物(運動 運動) {
		String sql="insert into 運動 (運動名稱) values (?)";
		String sql2="update 運動 set 運動代號=concat('e', lpad(last_insert_id(), 3, '0')) where id = last_insert_id();";
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			ps.setString(1,運動.get運動名稱());
			ps.executeUpdate();
			
			PreparedStatement ps2=連結.prepareStatement(sql2);
			ps2.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<運動> 全運動() {
		String sql="select * from 運動";
		List<運動> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					運動 e=new 運動();
						e.set運動代號(rs.getString("運動代號"));
						e.set運動名稱(rs.getString("運動名稱"));
						l.add(e);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}

	@Override
	public List<運動> id查運動(String 運動id) {
		String sql="select * from 運動 where 運動代號=?";
		List<運動> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ps.setString(1,運動id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					運動 e=new 運動();
						e.set運動代號(rs.getString("運動代號"));
						e.set運動名稱(rs.getString("運動名稱"));
						l.add(e);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}

	@Override
	public void 改運動內容(運動 運動) {
			String sql="update 運動 set 運動名稱=? where 運動代號=?";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			ps.setString(1,運動.get運動名稱());
			ps.setString(2,運動.get運動代號());
	
			ps.executeUpdate();
	    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
