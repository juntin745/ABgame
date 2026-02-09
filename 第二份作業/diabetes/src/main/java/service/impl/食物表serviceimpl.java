package service.impl;

import java.util.List;

import dao.impl.食物表daoimpl;
import model.食物表;
import service.食物表service;

public class 食物表serviceimpl implements 食物表service{
	食物表daoimpl dao=new 食物表daoimpl();
	@Override
	public void 新增食物(食物表 食物) {
		dao.新增食物(食物);
		
	}

	@Override
	public List<食物表> 全食物() {
		return dao.全食物();
	}

	
	@Override
	public List<食物表> id查食物(String 食物id) {
		// TODO Auto-generated method stub
		return dao.id查食物(食物id);
	}
	
	@Override
	public void 改食物內容(食物表 食物) {
		// TODO Auto-generated method stub
		dao.改食物內容(食物);
	}

	

}
