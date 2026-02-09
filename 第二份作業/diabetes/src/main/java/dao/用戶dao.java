package dao;

import java.util.List;

import model.用戶;

public interface 用戶dao {
	//新增
	void 新增用戶(用戶 用戶);
	//讀
	List<用戶> 全用戶();
	List<用戶> 帳號查用戶id(String 帳號);
	List<用戶> 帳密確認用戶(String 帳號,String 密碼);
	//改
	void 改資料();
	
}
