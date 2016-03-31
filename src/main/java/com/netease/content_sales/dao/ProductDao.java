/**
 * @Title: ProsuctDao.java
 * @Package com.netease.content_sales.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月29日 下午4:53:08
 * @version V1.0
 */
package com.netease.content_sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.netease.content_sales.mate.Product;

/**
 * @ClassName: ProsuctDao
 * @Description: TODO(产品查询)
 * @author netease hzwangfei2014
 * @date 2016年3月29日 下午4:53:08
 */
public interface ProductDao {
	@Select("SELECT Product.id AS id, Product.title AS title, image, price, IF (buyer = #{userId}, TRUE, FALSE) AS isBuy,IF (buyer <> '', TRUE, FALSE) AS isSell FROM Product LEFT JOIN BuyList ON BuyList.id = Product.id where Product.ifSell = 0")
	public List<Product> getProductList(Number userId);

	@Select("SELECT Product.id AS id, Product.title AS title, image, price, summary, detail, IF (buyer = #{userId}, TRUE, FALSE) AS isBuy,IF (buyer <> '', TRUE, FALSE) AS isSell FROM Product LEFT JOIN BuyList ON BuyList.id = Product.id where BuyList.id = #{id} and Product.ifSell = 0")
	public Product getProductDetail(@Param("id") Number id, @Param("userId") Number userId);

	@Update("update Product set title=#{title},image=#{image},price=#{price},detail=#{detail},summary=#{summary} where id= #{id}")
	public Integer updateProduct(Product product);

	@Insert("insert into Product(title, image, price, detail, summary, seller) values(#{title},#{image},#{price},#{detail},#{summary},#{seller})")
	public Integer insertProduct(Product product);
	
	@Update("update Product set ifSell = 1 where id = #{id} and seller = #{seller}")
	public Integer deleteProduct(@Param("id") Number id, @Param("seller") Number seller);
}
