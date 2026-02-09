package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.運動連接表dao;
import model.運動連接表;
import util.Tool;

public class 運動連接表daoimpl implements 運動連接表dao{
	Connection 連結=Tool.getDb();
	@Override
	public void 新增週運動(運動連接表 運動連接表) {
			String sql="insert into 運動連接表 (UID,週ID,運動ID,單位,時間) values (?,?,?,?,?)";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			ps.setString(1,運動連接表.getUID());
			ps.setString(2,運動連接表.get週ID());
			ps.setString(3,運動連接表.get運動ID());
			ps.setDouble(4,運動連接表.get單位());
			ps.setDouble(5,運動連接表.get時間());
			ps.executeUpdate();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public List<運動連接表> 全週運動() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<運動連接表> id查週運動(String 運動id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void 改週運動內容(運動連接表 運動連接表) {
String sql="update 運動連接表 set 單位=?,時間=? where UID=? and 週ID=? and 運動ID=?";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			
			ps.setDouble(1,運動連接表.get單位());
			ps.setDouble(2,運動連接表.get時間());
			ps.setString(3,運動連接表.getUID());
			ps.setString(4,運動連接表.get週ID());
			ps.setString(5,運動連接表.get運動ID());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
