package com.gwsc.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gwsc.bean.User;

public interface UserDao {
	//添加用户
	@Insert("insert into  "
			+ " s_user(username,password,orgid,roleid,state,remark,photo)  "
			+ " values(#{username},#{password},#{orgid},#{roleid},#{state},#{remark},#{photo})")
	public void insert(User user);

	//查询用户列表
	@Select("select * from s_user")
	public List<User> select();
	
	//登陆页面的账号密码匹配
	@Select("select * from s_user where username=#{username} and password=#{password}")
	public User login(User user);
	
	//删除用户
	@Delete("delete from s_user where id=#{id}")
	public void delete(User user);
	
	//修改1：预修改
	@Select("select * from s_user where id=#{id}")
	public User edit(User user);

	//修改2：上传
	@Update("update s_user set username=#{username},")
	public void update(User user);
	
}
