package dao;

import java.util.List;

import model.食物連接表;


public interface 食物連接表dao {
	//新增
			void 新增週食物(食物連接表 食物連接表);
			//讀
			List<食物連接表> 全週食物();
			List<食物連接表> id查週食物(String 食物ID);
			//改
			void 改週食物內容(食物連接表 食物連接表);

}
