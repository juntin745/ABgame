package service.impl;


import java.util.List;
import dao.impl.用戶daoimpl;
import model.用戶;
import service.用戶service;

public class 用戶serviceimpl implements 用戶service{
	用戶daoimpl 用戶DaoImpl=new 用戶daoimpl();
	@Override
	public void 新增用戶(用戶 用戶) {
		
		用戶DaoImpl.新增用戶(用戶);
	}

	@Override
	public 用戶 帳密確認用戶(String username, String password) {
		用戶 user=null;
		List<用戶> l=用戶DaoImpl.帳密確認用戶(username, password);
		
		if(l.size()!=0)
		{
			user=l.get(0);
		}
		
		
		
		return user;
	}

	@Override
	public boolean 帳號查用戶id(String username) {
		List<用戶> l=用戶DaoImpl.帳號查用戶id(username);
		
		return !l.isEmpty();
	}

}
