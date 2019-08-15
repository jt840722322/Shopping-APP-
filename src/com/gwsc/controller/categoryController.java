package com.gwsc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.gwsc.Dao.CategoryDao;

import com.gwsc.bean.category;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("category")
public class categoryController {
	@Resource
	private CategoryDao categoryDao;
	
	@RequestMapping("insert")
	public String insert(category category,MultipartFile up2,HttpServletRequest request) {
		//��ȡ�ļ���С
		long size=up2.getSize();
		if(size>0) {
			//��ȡ�ļ���
			String filename=up2.getOriginalFilename();
			String realpath=request.getRealPath("/images/shangpin");
			//���ļ�����ָ�����ļ���
			File dest=new File(realpath,filename);
			try {
				up2.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			category.setPhoto(filename);
		}	
		categoryDao.insert(category);
		return "forward:/category/select";
	}
	
	@RequestMapping("select")
	public String select(Model model) {
		List<category> list=categoryDao.select();
		model.addAttribute("shangpin",list);
		return "shangpinlist";
	}
	
	@RequestMapping("selectType")
	public String select2(Model model,category category) {
		List<category> list=categoryDao.select2(category);
		model.addAttribute("shangpin",list);
		return "shangpinlist";
	}
	
	/*jsonp��ʽ��ajax��ѯ
	 * category
	 * */
	@ResponseBody
	@RequestMapping(value="ajaxselect",produces="text/html;charset=utf-8")//json���������ģ�������룬������Ҫָ�����ı���
	public String ajaxselect(String callback) {
		
		List<category> list=categoryDao.select();
		
		Gson gson=new Gson();
		String str=gson.toJson(list);//��listת����json��
		String s=callback+ "("+str+")";
		
		return s;
	}
	
	@RequestMapping("delete")
	public String delete(category category) {
		categoryDao.delete(category);
		return "forward:/category/select";
	}
}
