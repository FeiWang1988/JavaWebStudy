/**   
* @Title: Client.java 
* @Package com.netease.content_sales.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author netease hzwangfei2014   
* @date 2016年3月21日 上午10:00:31 
* @version V1.0   
*/
package com.netease.content_sales.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Client {
	private static Map users = new HashMap();
	
	public static void main(String[] args){
		String userName = "buyer";
		String password = "reyub";
		registerUser(userName,password);
		
		userName = "seller";
		password = "relles";
		registerUser(userName,password);
		
		String loginUserId = "buyer";
		String pwd = "reyub";
		try {
			if(loginValid(loginUserId,pwd)){
				System.out.println("欢迎登陆！！！");
			}else{
				System.out.println("口令错误，请重新输入！！！");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * 注册用户
	 * 
	 * @param userName
	 * @param password
	 */
	public static void registerUser(String userName,String password){
		String encryptedPwd = null;
		try {
			encryptedPwd = MD5Util.getEncryptedPwd(password);
			
			System.out.println(encryptedPwd);
			users.put(userName, encryptedPwd);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 验证登陆
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static boolean loginValid(String userName,String password) 
				throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String pwdInDb = (String)users.get(userName);
		if(null!=pwdInDb){ // 该用户存在
				return MD5Util.validPassword(password, pwdInDb);
		}else{
			System.out.println("不存在该用户！！！");
			return false;
		}
	}
}