

package com.ten.project.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ten.project.utils.JDBCUtils;
import com.ten.project.bean.Type;

public class TypeDao {
	//jdbctemplate
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

	public Vector findAllType() {
		Vector vlist = new Vector<>();
		List<Type> list = jt.query("select * from ptype", new BeanPropertyRowMapper<Type>(Type.class));
		
		for (Type type : list) {
			Vector v = new Vector();
	        v.add(type.getGoodid());
	        v.add(type.getBrand());
	        v.add(type.getColor());
	        v.add(type.getGoodtype() == 1 ? "�ʼǱ�":"̨ʽ");
	        v.add(type.getGtime());
	        //v.add(type.getGtime().toString().substring(0, 10));
	        v.add(type.getGflag() == 1 ? "�ϼ�":"�¼�");
	        
	        vlist.add(v);
	        
			
		    
            
		}
		return vlist;
	}


	public Boolean addType(Type type) {
		int update = jt.update("INSERT INTO `project`.`ptype`(`color`,`brand`,`goodtype`,`gflag`,`gtime`)VALUES(?,?,?,?,curdate())",
			type.getColor(),type.getBrand(),type.getGoodtype(),type.getGflag());
		return update>0 ? true : false;
	}



	public int delTypeById(int typeid) {
		return jt.update("delete from ptype where goodid = ?",typeid);
	}



	public Type findTypeById(int typeid) {
		return jt.queryForObject("select * from ptype where goodid = ? ", 
		          new BeanPropertyRowMapper<Type>(Type.class),typeid);
	}


//�޸�ִ��
	public int updateType(Type type) {
		int update = jt.update("UPDATE `project`.`ptype` SET `color` = ?, `brand` = ?, `goodtype` = ?, `gflag` = ?  WHERE `goodid` = ?",
				type.getColor(),type.getBrand(),type.getGoodtype(),type.getGflag(),type.getGoodid());
			
	return update;
	}


//��ȡ�������
	public Vector findAllbrand() {
		
		Vector v = new Vector<>();
		List<Type> list = jt.query("select * from ptype where gflag = 1 ", new BeanPropertyRowMapper<Type>(Type.class));
		
		for (Type type : list) {
		
	        v.add(type.getBrand());
	      
	}
    return v;
	}


	public Integer findTypeIdbyGname(String brand) {
		
		return jt.queryForObject("select goodid from ptype where brand = ? ",Integer.class,brand);
		
	}
}
