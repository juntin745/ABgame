package service.impl;

import java.time.LocalDate;
import java.util.List;

import dao.impl.睡覺daoimpl;
import model.睡眠時間;
import service.睡眠時間service;

public class 睡眠時間serviceimpl implements 睡眠時間service{
	睡覺daoimpl dao=new 睡覺daoimpl();
	@Override
	public void 新增睡覺(睡眠時間 睡覺) throws Exception {
		
		List<睡眠時間> 同日期資料 = this.日期查睡眠時間(睡覺.get日期(), 睡覺.get日期());
	    if (同日期資料.isEmpty()) {
	    		dao.新增睡覺(睡覺);
	    } else {
	    	 	throw new Exception("這一天的睡眠資料已存在，不能重複新增！");
	    }
		
		
	}

	@Override
	public List<睡眠時間> 全睡眠時間() {
		
		List<睡眠時間> l= dao.全睡眠時間();
	    for(睡眠時間 s : l) {
	        if(s.get日期() != null) {
	            s.set星期(s.get日期().getDayOfWeek());
	        }
	    }
		return l;
	}

	@Override
	public List<睡眠時間> 日期查睡眠時間(LocalDate 起始日期, LocalDate 結束日期) {
		List<睡眠時間> l= dao.日期查睡眠時間(起始日期, 結束日期);
	    for(睡眠時間 s : l) {
	        if(s.get日期() != null) {
	            s.set星期(s.get日期().getDayOfWeek());
	        }
	    }
		return l;
	}

	@Override
	public void 改睡眠內容(睡眠時間 睡覺) throws Exception {
		List<睡眠時間> 同日期資料 = this.日期查睡眠時間(睡覺.get日期(), 睡覺.get日期());
		if (同日期資料.isEmpty()) {
    			throw new Exception("不能沒選日期");
		} else {
			dao.改睡眠內容(睡覺);
		}
	}
	
}
