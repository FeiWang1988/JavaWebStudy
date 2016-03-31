/**
 * @Title: IProductService.java
 * @Package com.netease.content_sales.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月30日 下午1:45:42
 * @version V1.0
 */
package com.netease.content_sales.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.netease.content_sales.mate.BuyList;
import com.netease.content_sales.mate.Product;

/**
 * @ClassName: IProductService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author netease hzwangfei2014
 * @date 2016年3月30日 下午1:45:42
 */
public interface IProductService {
	public List<Product> getProductList(Number userId);

	public Product getProductDetail(Number id, Number userId);

	public Integer updateProduct(Product product);

	public Integer insertProduct(Product product);

	public Integer deleteProduct(Number id, Number seller);

	public List<BuyList> getBuyList(Number id);

	public Integer buy(Number productId, Number buyerId);
}
