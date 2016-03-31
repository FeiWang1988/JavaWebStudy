package com.netease.content_sales.utils;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class ReturnCode {
	private static String CODE = "code";
	private static String MESSAGE = "message";
	private static int OK = 200;
	// 20* 参数错误
	private static int PARAMETER_WRONG = 201;
	// 21* 数据库访问错
	private static int DB_UPDATE_WRONG = 210;
	private static int DB_INSERT_WRONG = 211;
	private static int DB_SELECT_WRONG = 212;
	private static int DB_DELETE_WRONG = 213;
	// 23* IO异常错误
	private static int IO_EXCEPTION = 230;
	// 25* 权限访问错误
	private static int NO_AUTHORITY = 250;

	/**
	 * 返回 获取参数失败编码
	 */
	public JSONObject getParameterWrong(JSONObject jb, String msg) {

		jb.put(CODE, PARAMETER_WRONG);
		jb.put(MESSAGE, msg);
		return jb;

	}

	/**
	 * IO异常
	 */
	public JSONObject ioException(JSONObject jb, String msg) {

		jb.put(CODE, IO_EXCEPTION);
		jb.put(MESSAGE, msg);
		return jb;
	}

	/**
	 * 无用户权�?
	 */
	public JSONObject noAuthory(JSONObject jb, String msg) {

		jb.put(CODE, NO_AUTHORITY);
		jb.put(MESSAGE, msg);
		return jb;
	}

	/**
	 * 删除数据失败
	 */
	public JSONObject deleteDBWrong(JSONObject jb, String msg) {

		jb.put(CODE, DB_DELETE_WRONG);
		jb.put(MESSAGE, msg);
		return jb;
	}

	/**
	 * 新增数据失败
	 */
	public JSONObject insertDBWrong(JSONObject jb, String msg) {

		jb.put(CODE, DB_INSERT_WRONG);
		jb.put(MESSAGE, msg);
		return jb;
	}

	/**
	 * 更新数据库失�?
	 */
	public JSONObject updateDBWrong(JSONObject jb, String msg) {

		jb.put(CODE, DB_UPDATE_WRONG);
		jb.put(MESSAGE, msg);
		return jb;
	}

	/**
	 * 查询数据库数据失败编�?
	 */
	public JSONObject getDBSelectWrong(JSONObject jb, String msg) {

		jb.put(CODE, DB_SELECT_WRONG);
		jb.put(MESSAGE, msg);
		return jb;
	}

	/**
	 * 成功的编�?
	 */
	public JSONObject getOK(JSONObject jb, String msg) {

		jb.put(CODE, OK);
		jb.put(MESSAGE, msg);
		return jb;
	}
}
