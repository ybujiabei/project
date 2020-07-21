package com.ten.project.bean;

import java.util.Date;

public class Type {

//	  `goodid` int(11) NOT NULL AUTO_INCREMENT,
//	  `color` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
//	  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
//	  `goodtype` int(1) NULL DEFAULT NULL,
//	  `gtime` date NULL DEFAULT NULL,
//	  `gflag` int(1) NULL DEFAULT NULL,

		private Integer goodid;
		private String color;
		private String brand;
		private Integer goodtype;
		private Date gtime;
		private Integer gflag;
		public Integer getGoodid() {
			return goodid;
		}
		public void setGoodid(Integer goodid) {
			this.goodid = goodid;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public Integer getGoodtype() {
			return goodtype;
		}
		public void setGoodtype(Integer goodtype) {
			this.goodtype = goodtype;
		}
		public Date getGtime() {
			return gtime;
		}
		public void setGtime(Date gtime) {
			this.gtime = gtime;
		}
		public Integer getGflag() {
			return gflag;
		}
		public void setGflag(Integer gflag) {
			this.gflag = gflag;
		}
	
}