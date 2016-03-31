/**
 * @Title: LoginInfo.java
 * @Package com.netease.content_sales.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午5:47:12
 * @version V1.0
 */
package com.netease.content_sales.utils;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: LoginInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午5:47:12
 */
@Component
public class LoginInfo {
	public JSONObject getLoginUserInfo(HttpSession session) {
		if (session.getAttribute("userName") != null)
		{
			JSONObject jo = new JSONObject();
			jo.put("userName", session.getAttribute("userName"));
			jo.put("type", Integer.valueOf(session.getAttribute("type").toString()));
			return jo;
		}
		else
		{
			return null;
		}
	}

}
