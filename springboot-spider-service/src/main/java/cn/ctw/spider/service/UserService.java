package cn.ctw.spider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ctw.spider.dao.jpa.UserDao;
import cn.ctw.spider.dao.mapper.UserMapper;
import cn.ctw.spider.entity.User;
import cn.ctw.spider.info.UserException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 用户注册
	 * @param user
	 * @return String
	 * @throws UserException 
	 */
	@Transactional
	public void registered(User user) throws UserException{
		
		String message ="";
		 List<User> userList = userDao.findByUserCode(user.getUserCode());
		if (userList == null || userList.size() == 0) {
			userDao.save(user);
		} else {
			message="注册失败";
			throw new UserException(message);
		}
	}

	
	/**
	 * 用户登录             
	 * @param user
	 * @return
	 * @throws UserException 
	 */
	@Cacheable("login")
	public User login(User user) throws UserException{
		
		/*List<User> userList = userMapper.queryUserByUserCode(user.getUserCode());*/
		// 学习spring chache  测试使用
		List<User> userList = testCache(user);
		System.out.println("查询后放入缓存");
		
		if (userList == null || userList.size() ==0) {
			throw new UserException("登陆失败1");
		}else{
			User exitUser = userList.get(0);
			if(user.getPassWord().equals(exitUser.getPassWord())){
				return exitUser;
			}else {
				throw new UserException("登陆失败2");
			}
		}
	}
	
	public List<User> testCache(User user){
		System.out.println("查询了数据库");
		return 	 userMapper.queryUserByUserCode(user.getUserCode());
	}
	
}
