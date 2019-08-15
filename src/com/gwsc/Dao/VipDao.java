package com.gwsc.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.gwsc.bean.Vip;

public interface VipDao {
	@Insert("insert into s_vip(uname,upassword,email,photo) values(#{uname},#{upassword},#{email},#{photo})")
 	public int insert(Vip vip);
	
	@Select("select * from s_vip where uname=#{uname} and upassword=#{upassword}")
	public Vip select(Vip vip);
}
