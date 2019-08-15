package com.gwsc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.gwsc.Dao.CartDao;
import com.gwsc.bean.Cart;

@RestController
@RequestMapping("cart")
public class CartController {
	@Resource
	private CartDao cartDao;
	
	@RequestMapping(value="insert",produces="text/html;charset=utf-8")
	public String insert(String callback,Cart cart) {
		int context=cartDao.insert(cart);
		Gson gson=new Gson();
		String s=callback+"("+gson.toJson(context)+")";
		return s;
	}
	
	@RequestMapping(value="edit",produces="text/html;charset=utf-8")
	public String select(String callback,Cart cart) {
		Cart c=cartDao.Edit(cart);
		Gson gson=new Gson();
		String s=callback+"("+gson.toJson(c)+")";
		return s;
	}
	
	@RequestMapping(value="update",produces="text/html;charset=utf-8")
	public String update(String callback,Cart cart) {
		int rows=cartDao.update(cart);
		Gson gson=new Gson();
		String s=callback+"("+gson.toJson(rows)+")";
		return s;
	}
	
	@RequestMapping(value="selectlist",produces="text/html;charset=utf-8")
	public String selectlist(Cart cart,String callback) {
		List<Cart> car=cartDao.selectlist(cart);
		Gson gson=new Gson();
		String s=callback+"("+gson.toJson(car)+")";
		return s;
	}
}
