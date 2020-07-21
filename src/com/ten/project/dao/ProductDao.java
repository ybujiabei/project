
package com.ten.project.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ten.project.bean.Product;
import com.ten.project.bean.Type;
import com.ten.project.utils.JDBCUtils;

public class ProductDao {
	//jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
//��ȡ��Ʒȫ��
    public Vector findAllType() {
	Vector vlist = new Vector<>();
	List<Product> list = jt.query("select * from ptype t join product p on t.goodid = p.goodid", new BeanPropertyRowMapper<Product>(Product.class));
	
	for (Product p : list) {
		Vector v = new Vector();
//		tt.add("id");
//		tt.add("Ʒ��");
//		tt.add("����");
//		tt.add("�۸�");
//		tt.add("����");
//		tt.add("״̬");
        v.add(p.getGoodid());
        v.add(p.getBrand());
        v.add(p.getGoodname());
        v.add(p.getPrice());
        v.add(p.getNumber());
        v.add(p.getGflag() == 1 ? "�¼�":"�ϼ�");
        v.add(p.getGoodtype() == 1 ? "̨ʽ":"�ʼǱ�");
        vlist.add(v);
        
		
	    
        
	}
	return vlist;
}

	public int savaProduct(Product product) {
		int i = jt.update(
				"INSERT INTO `project`.`product`( `goodname`, `price`, `number`, `gooddesc`,`goodid`) VALUES ( ?,?,?,?,?)",
				product.getGoodname(),product.getPrice(),product.getNumber(),product.getGooddesc(),product.getGoodid());
		return i;
	}

	
	public Product findProductById(int gid) {
		return jt.queryForObject("select * from product where goodid = ? ", 
		          new BeanPropertyRowMapper<Product>(Product.class),gid);
	}


}
