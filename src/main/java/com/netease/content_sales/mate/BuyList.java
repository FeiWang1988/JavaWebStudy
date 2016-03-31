/**
 * @Title: BuyList.java
 * @Package com.netease.content_sales.mate
 * @Description: TODO(用一句话描述该文件做什么)
 * @author netease hzwangfei2014
 * @date 2016年3月29日 下午5:27:25
 * @version V1.0
 */
package com.netease.content_sales.mate;

import java.sql.Timestamp;

/**
 * @ClassName: BuyList
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author netease hzwangfei2014
 * @date 2016年3月29日 下午5:27:25
 */
public class BuyList {
	private Number id;
	private String title;
	private Number buyPrice;
	private Timestamp buyTime;
	private Number buyer;

	/**
	 * @return id
	 */
	public Long getId() {
		return (Long) id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            要设置的 title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return buyPrice
	 */
	public Double getBuyPrice() {
		return (Double) buyPrice;
	}

	/**
	 * @param buyPrice
	 *            要设置的 buyPrice
	 */
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return buyTime
	 */
	public Timestamp getBuyTime() {
		return buyTime;
	}

	/**
	 * @param buyTime
	 *            要设置的 buyTime
	 */
	public void setBuyTime(Timestamp buyTime) {
		this.buyTime = buyTime;
	}

	/**
	 * @return buyer
	 */
	public Long getBuyer() {
		return (Long) buyer;
	}

	/**
	 * @param buyer
	 *            要设置的 buyer
	 */
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

}
