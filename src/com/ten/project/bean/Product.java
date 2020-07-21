package com.ten.project.bean;

import java.util.Date;

public class Product {
//
//
//	  `goodid` int(11) NOT NULL AUTO_INCREMENT,
//	  `goodname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
//	  `price` double(8, 2) NOT NULL,
//	  `number` int(4) NULL DEFAULT NULL,
//	  `gooddesc` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
	private Integer goodid;
	private String goodname;
	private Double price;
	private Integer number;
	private String gooddesc;
	private Integer gflag;
	private String brand;
	private Integer goodtype;
	public Integer getGoodtype() {
		return goodtype;
	}
	public void setGoodtype(Integer goodtype) {
		this.goodtype = goodtype;
	}
	public Integer getGoodid() {
		return goodid;
	}
	public void setGoodid(Integer goodid) {
		this.goodid = goodid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getGooddesc() {
		return gooddesc;
	}
	public void setGooddesc(String gooddesc) {
		this.gooddesc = gooddesc;
	}
	public Integer getGflag() {
		return gflag;
	}
	public void setGflag(Integer gflag) {
		this.gflag = gflag;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Product [goodid=" + goodid + ", goodname=" + goodname + ", price=" + price + ", number=" + number
				+ ", gooddesc=" + gooddesc + ", gflag=" + gflag + ", brand=" + brand + ", goodtype=" + goodtype + "]";
	}

}