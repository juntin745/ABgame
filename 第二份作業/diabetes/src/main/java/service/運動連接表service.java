package service;

import java.util.List;

import model.運動連接表;

public interface 運動連接表service {
	//新增
		void 新增週運動(運動連接表 運動連接表);
		//讀
		List<運動連接表> 全週運動();
		List<運動連接表> id查週運動(String 運動ID);
		//改
		void 改週運動內容(運動連接表 運動連接表);
}
