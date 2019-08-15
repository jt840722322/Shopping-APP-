package com.gwsc.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gwsc.bean.Good;

public interface GoodDao {

	@Select("select * from s_good")
	public List<Good> select();
	
	@Insert("insert into s_good(name,oldprice,newprice,remark,cid,num,photo,hot,createdate,sort,standard) "
			+ " values(#{name},#{oldprice},#{newprice},#{remark},#{cid},#{num},#{photo},#{hot},now(),#{sort},#{standard})")
	public void insert(Good good);
	
	@Delete("delete from s_good where id=#{id}")
	public void delete(Good good);

	@Select("select * from s_good where id=#{id}")
	public Good edit(Good good);
	
	@Update("update s_good set name=#{name},oldprice=#{oldprice},newprice=#{newprice},remark=#{remark},cid=#{cid},num=#{num},photo=#{photo},hot=#{hot},createdate=now(),sort=#{sort},standard=#{standard} where id=#{id} ")
	public void update(Good good);
	
	@Select("select * from s_good where cid=#{cid} limit #{begin},#{rows}")
	public List<Good> selectlist(Good good);
	
	@Select("select * from s_good where id=#{id}")
	public Good selectxq(int id);
	
	@Select("select count(*) from s_good where cid=#{cid}")
	public int count(int cid);
}
