package service;

import java.time.LocalDate;
import java.util.List;

import model.WeeklyHealth;



public interface 每周血糖表service {
	void 新增每周血糖(WeeklyHealth 週大表) throws Exception;
	//讀
	List<WeeklyHealth> 全內容();
	List<WeeklyHealth> 用戶查內容(String 運動id);
	List<WeeklyHealth> 用戶日期查內容(LocalDate 日期,String 用戶id);
	//改
	void 改資料(WeeklyHealth 週大表,String UID) throws Exception;
}
