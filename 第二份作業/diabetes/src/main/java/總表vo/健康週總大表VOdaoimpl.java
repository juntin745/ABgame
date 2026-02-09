package 總表vo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import util.Tool;


public class 健康週總大表VOdaoimpl {

	Connection 連結=Tool.getDb();
	    public List<健康週總表VO> 查全部總大表() {
	        List<健康週總表VO> list = new ArrayList<>();
	        String sql = "SELECT * FROM blood_glucose.總大表1";

	        try (
	        	
	             PreparedStatement ps = 連結.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                健康週總表VO vo = new 健康週總表VO();
	                vo.set用戶id(rs.getString("用戶id"));
	                vo.set週ID(rs.getString("週ID"));
	                vo.set日期(rs.getDate("日期").toLocalDate());
	                vo.set血糖值(rs.getInt("血糖值"));
	                vo.set收縮壓(rs.getInt("收縮壓"));
	                vo.set舒張壓(rs.getInt("舒張壓"));
	                vo.set脈搏(rs.getInt("脈搏"));
	                vo.set體重(rs.getDouble("體重"));
	                vo.set運動名稱(rs.getString("運動名稱"));
	                vo.set單位(rs.getDouble("單位"));
	                vo.set時間(rs.getDouble("時間"));
	                vo.set食物名稱(rs.getString("食物名稱"));
	                vo.setGI值(rs.getInt("GI值"));
	                vo.set好吃度(rs.getDouble("好吃度"));
	                vo.set次數(rs.getInt("次數"));

	                list.add(vo);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	    public List<健康週總表VO> 查詢日期範圍(LocalDate start, LocalDate end, String userId) {
	        List<健康週總表VO> list = new ArrayList<>();
	        String sql = "SELECT * FROM blood_glucose.全大表1 "
	                   + "WHERE 日期 BETWEEN ? AND ? AND 用戶id = ?";
	        try (PreparedStatement ps = 連結.prepareStatement(sql)) {
	            ps.setDate(1, java.sql.Date.valueOf(start));
	            ps.setDate(2, java.sql.Date.valueOf(end));
	            ps.setString(3, userId);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	健康週總表VO vo = new 健康週總表VO();
	                vo.set用戶id(rs.getString("用戶id"));
	                vo.set週ID(rs.getString("週ID"));
	                vo.set日期(rs.getDate("日期").toLocalDate());
	                vo.set血糖值(rs.getInt("血糖值"));
	                vo.set收縮壓(rs.getInt("收縮壓"));
	                vo.set舒張壓(rs.getInt("舒張壓"));
	                vo.set脈搏(rs.getInt("脈搏"));
	                vo.set體重(rs.getDouble("體重"));
	                vo.set運動名稱(rs.getString("運動名稱"));
	                vo.set單位(rs.getDouble("單位"));
	                vo.set時間(rs.getDouble("時間"));
	                vo.set食物名稱(rs.getString("食物名稱"));
	                vo.setGI值(rs.getInt("GI值"));
	                vo.set好吃度(rs.getDouble("好吃度"));
	                vo.set次數(rs.getInt("次數"));
	                list.add(vo);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
	    
	    
	    
	}

