package service.impl;

import java.util.List;

import dao.impl.食物連接表daoimpl;
import model.食物連接表;
import service.食物連接表service;

public class 食物連接表serviceimpl implements 食物連接表service{
	食物連接表daoimpl dao=new 食物連接表daoimpl();
	@Override
	public void 新增週食物(食物連接表 食物連接表) {
		dao.新增週食物(食物連接表);
		
	}

	@Override
	public List<食物連接表> 全週食物() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<食物連接表> id查週食物(String 食物id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void 改週食物內容(食物連接表 食物連接表) {
		// TODO Auto-generated method stub
		dao.改週食物內容(食物連接表);
	}

}
