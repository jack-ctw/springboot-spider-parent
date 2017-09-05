package cn.ctw.spider.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ctw.spider.entity.User;

@Mapper
public interface UserMapper {
	
	List<User> queryUserByUserCode(String userCode);
}
