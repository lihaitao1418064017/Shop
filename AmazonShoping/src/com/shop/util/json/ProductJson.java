package com.shop.util.json;

public class ProductJson {
	private int id;//商品编号
	private String price;//价格
	private String name;//名称
	private String photo;//商品图片
	private String descriptive;//商品描述
	private String isHot;//是否热卖
	private String shopTime;//商品时间
	private String status;//商品状态
	private String type;//商品类型
	private String monthSum;//月销量
	private String totalSum;//累计销量
	private String  taste;//口味或颜色款式
	private String pack;//包装
	
	private int sum;//产品库存
	private int evaluate;//累计评价
	private int oldPrice;//原价
	private String preferential;//优惠价
	private String eatWay;//使用方法
	
	
	
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}
	public int getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
	}
	public String getPreferential() {
		return preferential;
	}
	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}
	public String getEatWay() {
		return eatWay;
	}
	public void setEatWay(String eatWay) {
		this.eatWay = eatWay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescriptive() {
		return descriptive;
	}
	public void setDescriptive(String descriptive) {
		this.descriptive = descriptive;
	}
	public String getIsHot() {
		return isHot;
	}
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	public String getShopTime() {
		return shopTime;
	}
	public void setShopTime(String shopTime) {
		this.shopTime = shopTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMonthSum() {
		return monthSum;
	}
	public void setMonthSum(String monthSum) {
		this.monthSum = monthSum;
	}
	public String getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
}
