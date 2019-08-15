package com.gwsc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gwsc.Dao.UserDao;
import com.gwsc.bean.User;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserDao userDao;
	//添加用户
	@RequestMapping("insert")
	public String insert(MultipartFile up,User user,HttpServletRequest request) {
		//获取文件大小
		long size=up.getSize();
		if(size>0) {
			//获取文件名
			String filename=up.getOriginalFilename();
			String realpath=request.getRealPath("/images/head");
			//将文件拷贝到指定文件下
			File dest=new File(realpath,filename);
			try {
				up.transferTo(dest);
			} catch (IllegalStateException | IOException e) {				
				e.printStackTrace();
			}
			user.setPhoto(filename);
		}
		userDao.insert(user);
		return "forward:/user/select";
	}
	
	//用户列表
	@RequestMapping("select")
	public String select(Model model) {
		List<User> list=userDao.select();
		model.addAttribute("users",list);
		return "userList";
	}
	
	@RequestMapping("login")
	public String login(User user,HttpSession session) {
			User x=userDao.login(user);
			if(x==null) {
				return "login";
			}else{
				session.setAttribute("u", x);
				return "index";
			}
	}
	
	//删除
	@RequestMapping("delete")
	public String delete(User user) {
		userDao.delete(user);
		return "forward:/user/select";
	}
}
