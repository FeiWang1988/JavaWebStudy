/**   
* @Title: UserDao.java 
* @Package com.netease.content_sales.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author netease hzwangfei2014   
* @date 2016年3月18日 下午3:20:59 
* @version V1.0   
*/
package com.netease.content_sales.dao;

import org.apache.ibatis.annotations.Select;

import com.netease.content_sales.mate.User;

/** 
* @ClassName: UserDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author netease hzwangfei2014 
* @date 2016年3月18日 下午3:20:59 
*  
*/
public interface UserDao {
	@Select(" select * from User where userName = #{userName} and password = #{password} limit 1")
	public User selectUser(User user);

}
