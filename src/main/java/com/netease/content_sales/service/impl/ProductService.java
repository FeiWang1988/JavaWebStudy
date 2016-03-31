/**
 * @Title: ProductService.java
 * @Package com.netease.content_sales.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月30日 下午1:49:18
 * @version V1.0
 */
package com.netease.content_sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netease.content_sales.dao.BuyListDao;
import com.netease.content_sales.dao.ProductDao;
import com.netease.content_sales.mate.BuyList;
import com.netease.content_sales.mate.Product;
import com.netease.content_sales.service.IProductService;

/**
 * @ClassName: ProductService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author netease hzwangfei2014
 * @date 2016年3月30日 下午1:49:18
 */
@Component
public class ProductService implements IProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BuyListDao buyListDao;

	/*
	 * (非 Javadoc)
	 * <p>Title: getProductList</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @see com.netease.content_sales.service.IProductService#getProductList(java.lang.Number)
	 */
	@Override
	public List<Product> getProductList(Number userId) {
		// TODO Auto-generated method stub
		return productDao.getProductList(userId);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: getProductDetail</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.netease.content_sales.service.IProductService#getProductDetail(java.lang.Number)
	 */
	@Override
	public Product getProductDetail(Number id, Number userId) {
		return productDao.getProductDetail(id, userId);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: updateProduct</p>
	 * <p>Description: </p>
	 * @param product
	 * @return
	 * @see
	 * com.netease.content_sales.service.IProductService#updateProduct(com.netease.content_sales.
	 * mate.Product)
	 */
	@Override
	public Integer updateProduct(Product product) {

		return productDao.updateProduct(product);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: insertProduct</p>
	 * <p>Description: </p>
	 * @param product
	 * @return
	 * @see
	 * com.netease.content_sales.service.IProductService#insertProduct(com.netease.content_sales.
	 * mate.Product)
	 */
	@Override
	public Integer insertProduct(Product product) {

		return productDao.insertProduct(product);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: getBuyList</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.netease.content_sales.service.IProductService#getBuyList(java.lang.Number)
	 */
	@Override
	public List<BuyList> getBuyList(Number id) {
		// TODO Auto-generated method stub
		return buyListDao.getBuyList(id);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: buy</p>
	 * <p>Description: </p>
	 * @param productId
	 * @param buyerId
	 * @return
	 * @see com.netease.content_sales.service.IProductService#buy(java.lang.Number,
	 * java.lang.Number)
	 */
	@Override
	public Integer buy(Number productId, Number buyerId) {
		return buyListDao.buy(productId, buyerId);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: deleteProduct</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.netease.content_sales.service.IProductService#deleteProduct(java.lang.Number)
	 */
	@Override
	public Integer deleteProduct(Number id, Number seller) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id, seller);
	}

}
