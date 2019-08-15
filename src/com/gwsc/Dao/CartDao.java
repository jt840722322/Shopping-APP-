package com.gwsc.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gwsc.bean.Cart;

public interface CartDao {
/**将登陆的id传给购物车，显示产品内容，
 * 
*/
	@Insert("insert into s_cart(gid,uid,num) values(#{gid},#{uid},#{num})")
	public int insert(Cart cart);

	@Select("select * from s_cart where gid=#{gid} and uid=#{uid}")
	public Cart Edit(Cart cart);
	
	@Update("update s_cart set num=num+${num} where id=#{id}")
	public int update(Cart cart);
	
	@Select("select c.*,g.name,g.photo,g.newprice,g.standard from s_cart c,s_good g where c.gid=g.id and c.uid=#{uid}")
	public List<Cart> selectlist(Cart cart);
}
