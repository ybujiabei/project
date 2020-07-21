package com.ten.project.bean;
public class User {
//	  `userid` int(11) NOT NULL AUTO_INCREMENT,
//	  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
//	  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
//	  `usertype` int(1) NULL DEFAULT NULL,
//	  `phone` int(64) NULL DEFAULT NULL,
	private Integer userid;
	private String username;
	private String password;
	private Integer usertype;
	private Integer phone;
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the usertype
	 */
	public Integer getUsertype() {
		return usertype;
	}
	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	/**
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
    

	

}
