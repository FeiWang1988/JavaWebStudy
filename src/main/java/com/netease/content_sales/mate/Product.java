/**   
* @Title: Product.java 
* @Package com.netease.content_sales.mate 
* @Description: TODO(用一句话描述该文件做什么) 
* @author netease hzwangfei2014   
* @date 2016年3月18日 下午4:40:55 
* @version V1.0   
*/
package com.netease.content_sales.mate;

/** 
* @ClassName: Product 
* @Description: TODO(产品实例) 
* @author netease hzwangfei2014 
* @date 2016年3月18日 下午4:40:55 
*  
*/
public class Product {
	private Number id;
	private String title;
	private String image;
	private Number price;
	private String summary;
	private String detail;
	private Boolean isBuy;
	private Boolean isSell;
	private Number seller;
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
	* @return title 
	*/
	public String getTitle() {
		return title;
	}
	/** 
	* @param title 要设置的 title 
	*/
	public void setTitle(String title) {
		this.title = title;
	}
	/** 
	* @return image 
	*/
	public String getImage() {
		return image;
	}
	/** 
	* @param image 要设置的 image 
	*/
	public void setImage(String image) {
		this.image = image;
	}
	/** 
	* @return price 
	*/
	public Double getPrice() {
		return (Double) price;
	}
	/** 
	* @param price 要设置的 price 
	*/
	public void setPrice(Double price) {
		this.price = price;
	}
	/** 
	* @return isBuy 
	*/
	public Boolean getIsBuy() {
		return isBuy;
	}
	/** 
	* @param isBuy 要设置的 isBuy 
	*/
	public void setIsBuy(Boolean isBuy) {
		this.isBuy = isBuy;
	}
	/** 
	* @return isSell 
	*/
	public Boolean getIsSell() {
		return isSell;
	}
	/** 
	* @param isSell 要设置的 isSell 
	*/
	public void setIsSell(Boolean isSell) {
		this.isSell = isSell;
	}
	/** 
	* @return summary 
	*/
	public String getSummary() {
		return summary;
	}
	/** 
	* @param summary 要设置的 summary 
	*/
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/** 
	* @return detail 
	*/
	public String getDetail() {
		return detail;
	}
	/** 
	* @param detail 要设置的 detail 
	*/
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/** 
	* @return seller 
	*/
	public Long getSeller() {
		return (Long) seller;
	}
	/** 
	* @param seller 要设置的 seller 
	*/
	public void setSeller(Long seller) {
		this.seller = seller;
	}

}
