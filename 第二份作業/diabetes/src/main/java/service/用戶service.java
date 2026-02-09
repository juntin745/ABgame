package service;

import model.用戶;

public interface 用戶service {
	void 新增用戶(用戶 用戶);
	用戶 帳密確認用戶(String username,String password);
	boolean 帳號查用戶id(String username);
	
}
