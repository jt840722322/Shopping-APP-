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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.gwsc.Dao.CategoryDao;
import com.gwsc.Dao.GoodDao;
import com.gwsc.bean.Good;
import com.gwsc.bean.category;

@Controller
@RequestMapping("good")
public class GoodController {
	@Resource
	private GoodDao goodDao;
	@Resource
	private CategoryDao categoryDao;
	
	
	@RequestMapping("select")
	public String select(Model model) {
		List<Good> list=goodDao.select();
		model.addAttribute("goods",list);
		return "goodlist";
	}
	
	@RequestMapping("insert")
	public String insert(Good good,MultipartFile up3,HttpServletRequest request) {
		//获取文件大小
				long size=up3.getSize();
				if(size>0) {
					//获取文件名
					String filename=up3.getOriginalFilename();
					String realpath=request.getRealPath("/images/shangpin2");
					//将文件拷贝指定的文件下
					File dest=new File(realpath,filename);
					try {
						up3.transferTo(dest);
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					good.setPhoto(filename);
				}	
		goodDao.insert(good);
		
		return "forward:/good/select";
	}
	//adddate的分类
	@RequestMapping("addselect")
	public String addselect(Model model) {
		List<category> list=categoryDao.select();
		model.addAttribute("categorys",list);
		return "goodAdd";
	}
	
	
	@RequestMapping("delete")
	public String delete(Good good) {
		goodDao.delete(good);
		return "forward:/good/select";
	}
	
	@RequestMapping("edit")
	public String edit(Model model,Good good) {
		model.addAttribute("edit",goodDao.edit(good));
		model.addAttribute("categorys",categoryDao.select());
		return "goodEdit";
	}
	
	@RequestMapping("update")
	public String update(Good good,MultipartFile up4,HttpServletRequest request) {
		//获取文件大小
		long size=up4.getSize();
		if(size>0) {
			//获取文件名
			String filename=up4.getOriginalFilename();
			String realpath=request.getRealPath("/images/shangpin2");
			//将文件拷贝指定的文件下
			File dest=new File(realpath,filename);
			try {
				up4.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			good.setPhoto(filename);
		}
		goodDao.update(good);
		return "forward:/good/select";
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxselect",produces="text/html;charset=utf-8")
	public String ajaxselect(String callback,Good good) {
		good.setBegin((good.getPage()-1)*good.getRows());
		List<Good> list=goodDao.selectlist(good);
		int num=goodDao.count(good.getCid());
		int total=num%good.getRows()==0?num/good.getRows():num/good.getRows()+1;
		list.get(0).setCount(total);
		list.get(0).setPage(good.getPage());
		Gson gson=new Gson();
		String str=gson.toJson(list);
		String s=callback+"("+str+")";
		return s;
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxselectxq",produces="text/html;charset=utf-8")
	public String ajaxselectxq(String callback,int id) {
		
		Good good=goodDao.selectxq(id);
		Gson gson=new Gson();
		String str=gson.toJson(good);
		String s=callback+"("+str+")";
		return s;
	}
}
