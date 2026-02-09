package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.用戶dao;

import model.用戶;
import util.Tool;

public class 用戶daoimpl implements 用戶dao{
	Connection 連結=Tool.getDb();
	@Override
	public void 新增用戶(用戶 用戶) {

		String sql="insert into 用戶 (用戶名稱,帳號,密碼) values (?,?,?)";
		String sql2="update 用戶 set 用戶id=concat('u', lpad(last_insert_id(), 3, '0')) where id = last_insert_id();";
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			ps.setString(1,用戶.getUser_name());
			ps.setString(2,用戶.get帳號());
			ps.setString(3,用戶.get密碼());
			ps.executeUpdate();
			
			PreparedStatement ps2=連結.prepareStatement(sql2);
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<用戶> 全用戶() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<用戶> 帳號查用戶id(String 帳號) {
		String sql="select * from 用戶 where 帳號=?";
		List<用戶> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ps.setString(1,帳號);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					用戶 u=new 用戶();
						u.setUser_id(rs.getString("用戶id"));
						u.setUser_name(rs.getString("用戶名稱"));
						u.set帳號(rs.getString("帳號"));
						u.set密碼(rs.getString("密碼"));
						l.add(u);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}

	@Override
	public List<用戶> 帳密確認用戶(String 帳號,String 密碼) {
		String sql="select * from 用戶 where 帳號=? and 密碼=?";
		List<用戶> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ps.setString(1,帳號);
				ps.setString(2,密碼);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					用戶 u=new 用戶();
						u.setUser_id(rs.getString("用戶id"));
						u.setUser_name(rs.getString("用戶名稱"));
						u.set帳號(rs.getString("帳號"));
						u.set密碼(rs.getString("密碼"));
						l.add(u);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}

	@Override
	public void 改資料() {
		// TODO Auto-generated method stub
		
	}
	

}
