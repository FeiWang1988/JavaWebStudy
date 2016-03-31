/**
 * @Title: LoginFilter.java
 * @Package com.netease.content_sales.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午3:18:44
 * @version V1.0
 */
package com.netease.content_sales.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: LoginFilter
 * @Description: TODO(过滤)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午3:18:44
 */
public class LoginFilter implements Filter {

	/*
	 * (非 Javadoc)
	 * <p>Title: destroy</p>
	 * <p>Description: </p>
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (非 Javadoc)
	 * <p>Title: doFilter</p>
	 * <p>Description: </p>
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String url = httpRequest.getRequestURI();
		if (url.indexOf("login") > -1 || url.indexOf("resources") > -1 || url.indexOf("api") > -1)
		{
			chain.doFilter(httpRequest, httpResponse);
		}
		if (session.getAttribute("userName") != null)
		{
			JSONObject jo = new JSONObject();
			jo.put("userName", session.getAttribute("userName"));
			jo.put("type", Integer.valueOf(session.getAttribute("type").toString()));
			chain.doFilter(httpRequest, httpResponse);
		}
		else
		{
			httpResponse.sendRedirect("login");
		}

	}

	/*
	 * (非 Javadoc)
	 * <p>Title: init</p>
	 * <p>Description: </p>
	 * @param arg0
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
