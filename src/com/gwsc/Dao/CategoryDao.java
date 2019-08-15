package com.gwsc.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.gwsc.bean.category;

public interface CategoryDao {
	@Insert("insert into s_category(name,type,photo) values(#{name},#{type},#{photo})")
	public void insert(category category);
	
	@Select("select * from s_category")
	public List<category> select();
	
	@Select("select * from s_category where type=#{type} ")
	public List<category> select2(category category);

	@Delete("delete from s_category where id=#{id}")
	public void delete(category category);
	
}
