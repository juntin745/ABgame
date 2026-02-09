package service.impl;

import java.util.List;

import dao.impl.運動連接表daoimpl;
import model.運動連接表;
import service.運動連接表service;

public class 運動連接表serviceimpl implements 運動連接表service{
	運動連接表daoimpl dao=new 運動連接表daoimpl();

	@Override
	public void 新增週運動(運動連接表 運動連接表) {
		// TODO Auto-generated method stub
		dao.新增週運動(運動連接表);
	}

	@Override
	public List<運動連接表> 全週運動() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<運動連接表> id查週運動(String 運動id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void 改週運動內容(運動連接表 運動連接表) {
		// TODO Auto-generated method stub
		dao.改週運動內容(運動連接表);
	}
}
