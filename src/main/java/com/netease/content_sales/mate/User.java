/**
 * @Title: User.java
 * @Package com.netease.content_sales.mate
 * @Description: TODO(用户实例)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午3:21:24
 * @version V1.0
 */
package com.netease.content_sales.mate;

/**
 * @ClassName: User
 * @Description: TODO(用户实例)
 * @author netease hzwangfei2014
 * @date 2016年3月18日 下午3:21:24
 */
public class User {
	private Number id;
	private String userName;
	private String password;
	private int type;
	/** 
	* @return id 
	*/
	public Long getId() {
		return (Long) id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Long id) {
		this.id = id;
	}
	/** 
	* @return userName 
	*/
	public String getUserName() {
		return userName;
	}
	/** 
	* @param userName 要设置的 userName 
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** 
	* @return password 
	*/
	public String getPassword() {
		return password;
	}
	/** 
	* @param password 要设置的 password 
	*/
	public void setPassword(String password) {
		this.password = password;
	}
	/** 
	* @return type 
	*/
	public int getType() {
		return type;
	}
	/** 
	* @param type 要设置的 type 
	*/
	public void setType(int type) {
		this.type = type;
	}

	

}
