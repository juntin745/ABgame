package dao;

import java.time.LocalDate;
import java.util.List;


import model.WeeklyHealth;


public interface WeeklyHealthdao {
	//新增
		void 新增每周血糖(WeeklyHealth weeklyHealth);
		//讀
		List<WeeklyHealth> 全內容();
		List<WeeklyHealth> 用戶查內容(String 用戶id);
		List<WeeklyHealth> 用戶日期查內容(LocalDate 日期,String 用戶id);
		//改
		void 改資料(WeeklyHealth weeklyHealth,String 用戶id);
	
}
