package service.impl;

import java.util.List;

import dao.impl.運動daoimpl;
import model.運動;
import service.運動service;

public class 運動serviceimpl implements 運動service{
	運動daoimpl dao=new 運動daoimpl();
	@Override
	public void 新增運動(運動 運動) {
		dao.新增食物(運動);
		
	}

	@Override
	public List<運動> 全運動() {
		// TODO Auto-generated method stub
		return dao.全運動();
	}

	@Override
	public List<運動> id查運動(String 運動id) {
		// TODO Auto-generated method stub
		return dao.id查運動(運動id);
	}

	@Override
	public void 改運動內容(運動 運動) {
		dao.改運動內容(運動);
		
	}

}
