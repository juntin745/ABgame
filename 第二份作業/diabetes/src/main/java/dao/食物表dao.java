package dao;

import java.util.List;

import model.食物表;



public interface 食物表dao {
		//新增
		void 新增食物(食物表 食物);
		//讀
		List<食物表> 全食物();
		List<食物表> id查食物(String 食物id);
		//改
		void 改食物內容(食物表 食物);
}
