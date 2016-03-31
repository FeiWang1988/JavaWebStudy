package com.netease.content_sales.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * @Title: login
	 * @Description: TODO(1登录页)
	 * @param session
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Locale locale, Model model) {
		logger.info("login! The client locale is {}.", locale);
		return "login";
	}

	/**
	 * @Title: loginout
	 * @Description: TODO(2退出)
	 * @param session
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
	public String loginout(HttpSession session, Locale locale, Model model) {
		logger.info("loginout! The client locale is {}.", locale);
		session.invalidate();// 清空
		return "login";
	}

}
