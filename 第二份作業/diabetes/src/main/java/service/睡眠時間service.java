package service;

import java.time.LocalDate;
import java.util.List;

import model.睡眠時間;

public interface 睡眠時間service {
	//新增
		void 新增睡覺(睡眠時間 睡覺) throws Exception;
		//讀
		List<睡眠時間> 全睡眠時間();
		List<睡眠時間> 日期查睡眠時間(LocalDate 起始日期,LocalDate 結束日期);
		//改
		void 改睡眠內容(睡眠時間 睡覺) throws Exception;
}
