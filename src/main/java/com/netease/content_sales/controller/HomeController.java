package com.netease.content_sales.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netease.content_sales.mate.BuyList;
import com.netease.content_sales.mate.Product;
import com.netease.content_sales.service.IProductService;
import com.netease.content_sales.utils.LoginInfo;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private LoginInfo loginInfo;
	@Autowired
	private IProductService productService;

	/**
	 * @Title: index
	 * @Description: TODO(3展示页)
	 * @param session
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpSession session, Locale locale, Model model) {
		logger.info("login! The client locale is {}.", locale);
		Number userId = (Number) session.getAttribute("userId");
		List<Product> productList = productService.getProductList(userId);
		String productArray = JSON.toJSONString(productList);
		model.addAttribute("productList", productArray);
		System.out.println(productArray);
		JSONObject jo = loginInfo.getLoginUserInfo(session);
		if (jo != null)
		{
			model.addAttribute("user", jo.toString());
			System.out.println(jo.toString());
		}
		return "index.ftl";
	}

	/**
	 * @Title: show
	 * @Description: TODO(4查看页)
	 * @param session
	 * @param id
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(HttpSession session, Number id, Locale locale, Model model) {
		logger.info("login! The client locale is {}.", locale);
		Number userId = (Number) session.getAttribute("userId");
		Product product = productService.getProductDetail(id, userId);
		model.addAttribute("product", product);
		JSONObject jo = loginInfo.getLoginUserInfo(session);
		if (jo != null)
			model.addAttribute("user", jo.toString());
		return "show.ftl";
	}
	/**
	 * 
	* @Title: account 
	* @Description: TODO(5账务页) 
	* @param session
	* @param locale
	* @param model
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(HttpSession session, Locale locale, Model model) {
		logger.info("login! The client locale is {}.", locale);
		JSONObject jo = loginInfo.getLoginUserInfo(session);
		if (jo != null)
			model.addAttribute("user", jo.toString());
		else
			return "";
		Number userId = (Number) session.getAttribute("userId");
		List<BuyList> buyList= productService.getBuyList(userId);
		model.addAttribute("buyList", JSON.toJSON(buyList));
		return "account.ftl";
	}
	/**
	 * @Title: publicPage
	 * @Description: TODO(6发布页)
	 * @param session
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public String publicPage(HttpSession session, Locale locale, Model model) {
		logger.info("publicPage! The client locale is {}.", locale);
		JSONObject jo = loginInfo.getLoginUserInfo(session);
		if (jo != null)
			model.addAttribute("user", jo.toString());
		return "public.ftl";
	}

	/**
	 * @Title: publicPage
	 * @Description: TODO(7发布提交)
	 * @param session
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/publicSubmit", method = RequestMethod.GET)
	public String publicSubmit(HttpSession session, Locale locale, Model model) {
		logger.info("publicPage! The client locale is {}.", locale);
		JSONObject jo = loginInfo.getLoginUserInfo(session);
		if (jo != null)
			model.addAttribute("user", jo.toString());
		return "publicSubmit.ftl";
	}

	/**
	 * @Title: edit
	 * @Description: TODO(8编辑页)
	 * @param session
	 * @param id
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpSession session, Number id, Locale locale, Model model) {
		logger.info("publicPage! The client locale is {}.", locale);
		Number userId = (Number) session.getAttribute("userId");
		Product product = productService.getProductDetail(id, userId);
		model.addAttribute("product", product);
		JSONObject jo = loginInfo.getLoginUserInfo(session);
		if (jo != null)
			model.addAttribute("user", jo.toString());
		return "edit.ftl";
	}

	/**
	 * @Title: editSubmit
	 * @Description: TODO(9编辑提交)
	 * @param session
	 * @param id
	 * @param locale
	 * @param model
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editSubmit", method = RequestMethod.GET)
	public String editSubmit(HttpSession session, Number id, Locale locale, Model model) {
		logger.info("publicPage! The client locale is {}.", locale);
		Number userId = (Number) session.getAttribute("userId");
		Product product = productService.getProductDetail(id, userId);
		model.addAttribute("product", product);
		JSONObject jo = loginInfo.getLoginUserInfo(session);
		if (jo != null)
			model.addAttribute("user", jo.toString());
		return "editSubmit.ftl";
	}
}
