package service.impl;

import java.time.LocalDate;
import java.util.List;

import dao.impl.WeeklyHealthdaoimpl;
import model.WeeklyHealth;
import service.每周血糖表service;

public class 每周血糖表serviceimpl implements 每周血糖表service{
	WeeklyHealthdaoimpl dao=new WeeklyHealthdaoimpl();
	@Override
	public void 新增每周血糖(WeeklyHealth 週大表) throws Exception {
		List<WeeklyHealth> 同日期資料 = this.用戶日期查內容(週大表.getDate(),週大表.get用戶id());
	    if (同日期資料.isEmpty()) {
	    		dao.新增每周血糖(週大表);
	    } else {
	    	 	throw new Exception("這一天的週大表已存在，不能重複新增！");
	    }
		
		
	}

	@Override
	public List<WeeklyHealth> 全內容() {
		
		return null;
	}

	@Override
	public List<WeeklyHealth> 用戶查內容(String 用戶id) {
		
		return dao.用戶查內容(用戶id);
	}
	
	@Override
	public List<WeeklyHealth> 用戶日期查內容(LocalDate 日期, String 用戶id) {
		// TODO Auto-generated method stub
		return dao.用戶日期查內容(日期,用戶id);
	}

	@Override
	public void 改資料(WeeklyHealth 週大表, String UID) throws Exception {
		List<WeeklyHealth> 同日期資料 = this.用戶日期查內容(週大表.getDate(),週大表.get用戶id());
		if (同日期資料.isEmpty()) {
    			throw new Exception("不能沒選日期");
		} else {
			dao.改資料(週大表,UID);
		}
	}
		
	

	
}
	


