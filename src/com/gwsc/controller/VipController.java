package com.gwsc.controller;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.gwsc.Dao.VipDao;
import com.gwsc.bean.Vip;

@RestController //全部的方法是ajax String 是返回值
@RequestMapping("vip")
public class VipController {
	@Resource
	private VipDao vipDao;
	//@Resource
	//private Gson gson;
	

	@RequestMapping(value="login",produces="text/html;charset=utf-8")
	public String select(String callback,Vip vip) {
		Vip v=vipDao.select(vip);
		Gson gson=new Gson();
		String str=gson.toJson(v);
		String s=callback+"("+str+")";
		return s;
	}
	
	@RequestMapping(value="insert",produces="text/html;charset=utf-8")
	public String insert(Vip vip,String callback) {
		int rows=vipDao.insert(vip);
		Gson gson=new Gson();
		String s=callback+"("+gson.toJson(rows)+")";
		return s;
	}
}
