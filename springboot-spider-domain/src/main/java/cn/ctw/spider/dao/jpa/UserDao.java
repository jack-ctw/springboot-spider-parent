package cn.ctw.spider.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.ctw.spider.entity.User;


@Repository
public interface UserDao extends JpaRepository<User, String>{
	/*
	 * 判断用户是否存在
	 */
	List<User> findByUserCode(String userCode);
}
