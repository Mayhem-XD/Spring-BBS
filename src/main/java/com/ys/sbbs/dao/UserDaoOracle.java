package com.ys.sbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ys.sbbs.entity.User;

@Mapper
public interface UserDaoOracle {
	@Select("select count(uname) from users where isDeleted=0")
	int getUserCount();
	
	@Select("select * from users where \"uid\"=#{uid}")
	User getUser(String uid);
//	Select 순서
//	FROM WHERE GROUP BY HAVING SELECT COLUM ORDER BY 미리 순서 만들어서 잘나냄
	@Select("select * from ("
			+ " select rownum as rn, a.* from (select * from users"
			+ " where isDeleted=0 order by regDate desc, \"uid\") a"
			+ " where rownum<=#{maxrow})"
			+ " where rn > #{offset}")
	List<User> getUserList(int maxrow,int offset);
	
	@Insert("insert into users values (#{uid}, #{pwd}, #{uname}, #{email}, "
			+ "default, default, #{profile, jdbcType=VARCHAR}, #{addr, jdbcType=VARCHAR})")
	void insertUser(User user);
	
	@Update("update users set pwd=#{pwd}, uname=#{uname}, email=#{email}, \"profile\"=#{profile, jdbcType=VARCHAR}, addr=#{addr, jdbcType=VARCHAR} where \"uid\"=#{uid}")
	void updateUser(User user);
	
	@Update("update users set isDeleted=1 where \"uid\"=#{uid}")
	void deleteUser(String uid);
	
}
