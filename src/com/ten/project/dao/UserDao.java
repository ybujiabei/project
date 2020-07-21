
package com.ten.project.dao;

import java.util.List;
import java.util.Map;

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
	//

}
