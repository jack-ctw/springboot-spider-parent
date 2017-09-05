package cn.ctw.spider.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.ctw.spider.dao.jpa.UserDao;
import cn.ctw.spider.dao.mapper.UserMapper;
import cn.ctw.spider.entity.User;

@Service
public class SpiderService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Cacheable("testMybatis")
	public String testMybatis(String test) {

		List<User> list = userMapper.queryUserByUserCode("test");
		return list.get(0).getUserCode();
	}
	
	
	public String testJpa() {

		String value = redisTemplate.boundValueOps("testJpa").get();
		if (value != null) {
			redisTemplate.expire("testJpa", 600, TimeUnit.SECONDS);
			System.out.println("从缓存中获取得到");
			return value;
		} else {
			String userCode = userDao.findByUserCode("test").get(0).getUserCode();
			redisTemplate.boundValueOps("testJpa").set("jack");
			redisTemplate.expire("testJpa", 600, TimeUnit.SECONDS);
			System.out.println("添加到缓存");
			return userCode;
		}
	}

}
