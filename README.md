# JavaWebStudy

## 几点疑问
1. D2.5中的设计内容是指商品总数吗？
2. 服务获取图片时的接口中，图片字段是什么类型数据格式，是数据流的形式还是其它？
3. user信息返回需要在各个接口处都返回代码，有没有更好的办法？
4. 大作业的页面应该是老师给出的吧，能否现在就给？
5. 单件商品是可以被多个人重复购买的吗？类似于课程？如果是那么怎么判断isSell（因为没有记录商品总数）同一件商品同一个人能否重复购买
6. mybatis不识别Number类型，而内容中标的都是Number （get，set 函数与 mysql 的字段对应即可，其他仍然可以用Number）
7. 卖家查看购买情况的接口没有

## 数据库查询语句

#### 获取产品列表

	SELECT
	    Product.*,
	IF (buyer = 1, TRUE, FALSE) AS isBuy,
	IF (buyer <> '', TRUE, FALSE) AS isSell
	FROM
	    Product
	LEFT JOIN BuyList ON BuyList.id = Product.id
	WHERE
	    Product.ifSell = 0

###插入购买记录
	INSERT INTO BuyList (title, buyPrice, buyer) SELECT
	    title,
	    price AS buyPrice,
	    1 AS buyer
	FROM
	    Product
	WHERE
	    id = 3

## 测试链接
1
 http://localhost:8080/content_sales/api/login?userName=test1&password=test1
6 
http://localhost:8080/content_sales/account

http://localhost:8080/content_sales/

先用get 最后用检查接口类型

## 数据库部分字段说明：  
> 1、删除采用虚拟删除的方式，防止误操作或者购买产品无法查找的情况，字段ifSell 默认 0 可销售 1 已下架

> 2、buyTime 已日志记录数据库的时间为准，该字段采用自动获取时间的方式 CURRENT_TIMESTAMP