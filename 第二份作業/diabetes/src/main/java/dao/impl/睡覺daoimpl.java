package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dao.睡覺dao;
import model.睡眠時間;
import util.Tool;


public class 睡覺daoimpl implements 睡覺dao{
	Connection 連結=Tool.getDb();
	@Override
	public void 新增睡覺(睡眠時間 睡覺) {
		String sql="insert into 睡眠時間 (日期,開始睡覺時間,起床時間,總睡眠時數) values (?,?,?,?)";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			ps.setDate(1,java.sql.Date.valueOf(睡覺.get日期()));
			ps.setTime(2,java.sql.Time.valueOf(睡覺.get開始睡覺時間()));
			ps.setTime(3,java.sql.Time.valueOf(睡覺.get起床時間()));
			ps.setDouble(4,睡覺.get總睡眠時數());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<睡眠時間> 全睡眠時間() {
		String sql="select * from 睡眠時間";
		List<睡眠時間> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					睡眠時間 s=new 睡眠時間();
						s.set日期(rs.getDate("日期").toLocalDate());
						s.set開始睡覺時間(rs.getTime("開始睡覺時間").toLocalTime());
						s.set起床時間(rs.getTime("起床時間").toLocalTime());
						s.set總睡眠時數(rs.getDouble("總睡眠時數"));
						l.add(s);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}

	@Override
	public List<睡眠時間> 日期查睡眠時間(LocalDate 起始日期, LocalDate 結束日期) {
		String sql="select * from 睡眠時間 where 日期 between ? and ?";
		List<睡眠時間> l=new ArrayList<>();
		PreparedStatement ps;
		
			try {
				ps = 連結.prepareStatement(sql);
				ps.setDate(1,java.sql.Date.valueOf(起始日期));
				ps.setDate(2,java.sql.Date.valueOf(結束日期));
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					睡眠時間 s=new 睡眠時間();
						s.set日期(rs.getDate("日期").toLocalDate());
						s.set開始睡覺時間(rs.getTime("開始睡覺時間").toLocalTime());
						s.set起床時間(rs.getTime("起床時間").toLocalTime());
						s.set總睡眠時數(rs.getDouble("總睡眠時數"));
						l.add(s);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return l;
	}

	@Override
	public void 改睡眠內容(睡眠時間 睡覺) {
		String sql="update 睡眠時間 set 開始睡覺時間=?,起床時間=?,總睡眠時數=? where 日期=?";
		
		try {
			PreparedStatement ps=連結.prepareStatement(sql);
			
			ps.setTime(1,java.sql.Time.valueOf(睡覺.get開始睡覺時間()));
			ps.setTime(2,java.sql.Time.valueOf(睡覺.get起床時間()));
			ps.setDouble(3,睡覺.get總睡眠時數());
			ps.setDate(4,java.sql.Date.valueOf(睡覺.get日期()));
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

