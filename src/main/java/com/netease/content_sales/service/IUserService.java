/**
 * @Title: IUserService.java
 * @Package com.netease.content_sales.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午4:16:50
 * @version V1.0
 */
package com.netease.content_sales.service;

import com.netease.content_sales.mate.User;

/**
 * @ClassName: IUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午4:16:50
 */
public interface IUserService {
	public User selectUser(User user);

}
