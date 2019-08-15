package com.gwsc.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gwsc.bean.User;

public interface UserDao {
	//����û�
	@Insert("insert into  "
			+ " s_user(username,password,orgid,roleid,state,remark,photo)  "
			+ " values(#{username},#{password},#{orgid},#{roleid},#{state},#{remark},#{photo})")
	public void insert(User user);

	//��ѯ�û��б�
	@Select("select * from s_user")
	public List<User> select();
	
	//��½ҳ����˺�����ƥ��
	@Select("select * from s_user where username=#{username} and password=#{password}")
	public User login(User user);
	
	//ɾ���û�
	@Delete("delete from s_user where id=#{id}")
	public void delete(User user);
	
	//�޸�1��Ԥ�޸�
	@Select("select * from s_user where id=#{id}")
	public User edit(User user);

	//�޸�2���ϴ�
	@Update("update s_user set username=#{username},")
	public void update(User user);
	
}
