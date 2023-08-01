package com.ys.sbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ys.sbbs.entity.Reply;

@Mapper
public interface ReplyDaoOracle {

	@Select("SELECT r.rid, r.\"comment\", r.regTime, r.isMine, r.\"uid\", r.bid, u.uname "
			+ "	FROM reply r JOIN users u ON r.\"uid\"=u.\"uid\" WHERE bid=#{bid}")
	List<Reply> getReplyList(int bid);
	
	@Insert("INSERT INTO reply VALUES (default, #{comment}, default, #{isMine}, #{uid}, #{bid})")
	void insertReply(Reply r);
	
	@Delete("delete from reply where rid=#{rid}")
	void deleteReply(String rid);
}
