package dao;

import java.util.List;

import model.運動;


public interface 運動dao {
			//新增
			void 新增食物(運動 運動);
			//讀
			List<運動> 全運動();
			List<運動> id查運動(String 運動id);
			//改
			void 改運動內容(運動 運動);
}
