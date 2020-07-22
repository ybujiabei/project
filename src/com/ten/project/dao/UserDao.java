
package com.ten.project.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ten.project.bean.User;
import com.ten.project.utils.JDBCUtils;

public class UserDao {
      //jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
	
	public Boolean checkUser(User user) {

	try {
	      User u = jt.queryForObject(
	    		    "select * from user where username = ? and password = ? ",
					new BeanPropertyRowMapper<>(User.class),
					user.getUsername(),user.getPassword());
	} catch (Exception e) {
		return false;
	}
		
	
		return true;
	}
	//ÃÌº””√ªß
	public int saveUser(User user) {
		return jt.update("INSERT INTO `project`.`user`( `username`, `password`, `usertype`, `phone`) VALUES (?, ?, ?, ?)",
				user.getUsername(),user.getPassword(),user.getUsertype(),user.getPhone());
		 
	}

}
