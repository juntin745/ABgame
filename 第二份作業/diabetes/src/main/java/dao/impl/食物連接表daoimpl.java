package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.食物連接表dao;
import model.食物連接表;
import util.Tool;

public class 食物連接表daoimpl implements 食物連接表dao{
	Connection 連結=Tool.getDb();
	@Override
	public void 新增週食物(食物連接表 食物連接表) {
		String sql="insert into 食物連接表 (UID,週ID,食物ID,次數) values (?,?,?,?)";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			ps.setString(1,食物連接表.getUID());
			ps.setString(2,食物連接表.get週ID());
			ps.setString(3,食物連接表.get食物ID());
			ps.setInt(4,食物連接表.get次數());
			ps.executeUpdate();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<食物連接表> 全週食物() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<食物連接表> id查週食物(String 食物ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void 改週食物內容(食物連接表 食物連接表) {
			String sql="update 食物連接表 set 次數 where UID=? and 週ID=? and 食物ID=?";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			
			ps.setInt(1,食物連接表.get次數());
			ps.setString(2,食物連接表.getUID());
			ps.setString(3,食物連接表.get週ID());
			ps.setString(4,食物連接表.get食物ID());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
