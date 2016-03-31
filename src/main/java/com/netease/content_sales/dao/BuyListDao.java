/**
 * @Title: BuyListDao.java
 * @Package com.netease.content_sales.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月29日 下午5:29:36
 * @version V1.0
 */
package com.netease.content_sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.content_sales.mate.BuyList;

/**
 * @ClassName: BuyListDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author netease hzwangfei2014
 * @date 2016年3月29日 下午5:29:36
 */
public interface BuyListDao {
	@Results(
	{ @Result(property = "id", column = "id"), @Result(property = "title", column = "title"), @Result(property = "buyPrice", column = "buyPrice"), @Result(property = "buyTime", column = "buyTime") })
	@Select("select id, title, buyPrice, buyTime from BuyList where buyer = #{id}")
	public List<BuyList> getBuyList(@Param("id") Number id);

	@Insert("INSERT INTO BuyList (title, buyPrice, buyer) select title,price as buyPrice, #{buyerId} as buyer from Product where id = #{productId}")
	public Integer buy(@Param("productId") Number productId, @Param("buyerId") Number buyerId);

}
