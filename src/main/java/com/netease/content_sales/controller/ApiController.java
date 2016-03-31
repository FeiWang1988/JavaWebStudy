/**
 * @Title: ApiController.java
 * @Package com.netease.content_sales.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月30日 下午5:07:09
 * @version V1.0
 */
package com.netease.content_sales.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.netease.content_sales.mate.User;
import com.netease.content_sales.service.IProductService;
import com.netease.content_sales.service.IUserService;
import com.netease.content_sales.utils.ReturnCode;

/**
 * @ClassName: ApiController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author netease hzwangfei2014
 * @date 2016年3月30日 下午5:07:09
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	@Autowired
	private ReturnCode returnCode;
	@Autowired
	private IUserService userService;
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String apiLogin(HttpSession session, String userName, String password, Locale locale, Model model) {
		logger.info("ApiController! The client locale is {}.", locale);
		JSONObject jo = new JSONObject();
		jo.put("result", false);
		if (userName == null || userName.equals("") || password == null || password.equals(""))
		{
			jo = returnCode.getParameterWrong(jo, "用户名或者密码为空");
			return jo.toString();
		}
		System.out.println("search user!");
		User user = new User();
		user.setPassword(password);
		user.setUserName(userName);
		user = userService.selectUser(user);
		if (user == null)
		{
			jo = returnCode.getDBSelectWrong(jo, "未查到匹配账户");
		}
		else
		{
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("type", user.getType());
			jo = returnCode.getOK(jo, "");
			jo.put("result", true);
		}
		System.out.println(jo.toString());
		return jo.toString();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public String deleteProduct(HttpSession session, Number id, Locale locale, Model model) {
		logger.info("deleteProduct! The client locale is {}.", locale);
		JSONObject jo = new JSONObject();
		jo.put("result", false);
		if (id == null)
		{
			jo = returnCode.getParameterWrong(jo, "参数为空");
			return jo.toString();
		}
		Number userId = (Number) session.getAttribute("userId");
		if (userId == null)
		{
			jo = returnCode.getParameterWrong(jo, "未登录");
			return jo.toString();
		}
		try
		{
			if (productService.deleteProduct(id, userId) > 0)
			{
				jo = returnCode.getOK(jo, "删除成功");
				jo.put("result", true);
			}
			else
			{
				jo = returnCode.getOK(jo, "未找到对应商品");
			}
		}
		catch (Exception e)
		{
			jo = returnCode.updateDBWrong(jo, e.toString());
		}
		System.out.println(jo.toString());
		return jo.toString();
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	@ResponseBody
	public String buyProduct(HttpSession session, Number id, Locale locale, Model model) {
		logger.info("deleteProduct! The client locale is {}.", locale);
		JSONObject jo = new JSONObject();
		jo.put("result", false);
		if (id == null)
		{
			jo = returnCode.getParameterWrong(jo, "参数为空");
			return jo.toString();
		}
		Number userId = (Number) session.getAttribute("userId");
		if (userId == null)
		{
			jo = returnCode.getParameterWrong(jo, "未登录");
			return jo.toString();
		}
		try
		{
			if (productService.buy(id, userId) > 0)
			{
				jo = returnCode.getOK(jo, "购买成功");
				jo.put("result", true);
			}else{
				jo = returnCode.getOK(jo, "未找到购买商品");
			}
		}
		catch (Exception e)
		{
			jo = returnCode.insertDBWrong(jo, e.toString());
		}
		System.out.println(jo.toString());
		return jo.toString();
	}
}
