/**   
* @Title: UserService.java 
* @Package com.netease.content_sales.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author netease hzwangfei2014   
* @date 2016年3月18日 下午4:17:21 
* @version V1.0   
*/
package com.netease.content_sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netease.content_sales.dao.UserDao;
import com.netease.content_sales.mate.User;
import com.netease.content_sales.service.IUserService;

/** 
* @ClassName: UserService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author netease hzwangfei2014 
* @date 2016年3月18日 下午4:17:21 
*  
*/
@Component
public class UserService implements IUserService {
	@Autowired
	private UserDao userDao;

	/* (非 Javadoc) 
	* <p>Title: selectUser</p> 
	* <p>Description: 查询用户 ，成功返回 用户</p> 
	* @param user
	* @return 
	* @see com.netease.content_sales.service.IUserService#selectUser(com.netease.content_sales.mate.User) 
	*/
	@Override
	public User selectUser(User user) {
		return userDao.selectUser(user);
	}

}
