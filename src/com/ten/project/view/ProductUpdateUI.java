
package com.ten.project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ten.project.bean.Product;
import com.ten.project.dao.ProductDao;
import com.ten.project.dao.TypeDao;

public class ProductUpdateUI extends IndexAdmin {
	//��Ʒ��Ϣ
	Product p;
	public ProductUpdateUI(String username, int pid) {
		super(username);
		init();
		//����id��ѯ��Ʒ��Ϣ
		ProductDao productdao = new ProductDao();
		p = productdao.findProductById(pid);
		
	}

	//��ʼ������
	Font d = new Font("����", Font.BOLD, 16);
	
	//��ʼ������
	JLabel productnamela = new JLabel("����");
	JLabel productpricela = new JLabel("�۸�");
	JLabel productnumla = new JLabel("����");
	JLabel productdescla = new JLabel("���");
	//JLabel producttypela = new JLabel("����");
	JLabel producbrandla = new JLabel("Ʒ��");
	
	JTextField productname = new JTextField();
	JTextField productprice = new JTextField();
	JTextField productnum = new JTextField();
	JTextField productdesc = new JTextField();
	

	//��ȡ����
	TypeDao typeDao = new TypeDao();
    Vector brands = typeDao.findAllbrand();
	JComboBox<String> producttype = new JComboBox<>(brands);
    
//��ť��
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton saveUpdateButton = new JButton("����");


	private void init() {
		//��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();


		//�û���
		productnamela.setBounds(120,150,100,30);
		productnamela.setFont(f);
	//
		productpricela.setBounds(120,210,100,30);
		productpricela.setFont(f);
		//
		productnumla.setBounds(120,270,390,30);
		productnumla.setFont(f);
		//
		productdescla.setBounds(120,330,100,30);
		productdescla.setFont(f);
		//

		//
		producbrandla.setBounds(120,500,100,30);
		producbrandla.setFont(f);
		//�����
		productname.setBounds(250,150,200,30);
		productname.setText(p.getGoodname());
		
		productprice.setBounds(250,210,200,30);
		productprice.setText(p.getPrice().toString());
		
		productnum.setBounds(250,270,200,30);
		productnum.setText(p.getNumber().toString());

		productdesc.setBounds(250,330,200,30);
		productdesc.setText(p.getGooddesc());



			//��ť
		saveUpdateButton.setBounds(120,550,330,50);
		//���û���
		//����
		int brandindex = 0;
		for (int i = 0; i < brands.size(); i++) {
			String n = (String) brands.get(i);
			if (n.equals(p.getBrand())) {
			    brandindex = i ;
		}


//��������
			producttype.setSelectedIndex(brandindex);


		productdesc.setBounds(250,330,100,80);
		producttype.setBounds(200,500, 100, 30);
		
		
		index.add(productnamela);
		index.add(productpricela);
		index.add(productnumla);
		index.add(productdescla);

		index.add(producbrandla);

		
		index.add(productname);
		index.add(productprice);
		index.add(productnum);
		index.add(productdesc);
		index.add(producttype);
//



		index.add(saveUpdateButton);
		
     producttype.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox j = (JComboBox) e.getSource();
				String n = (String) j.getSelectedItem();
				String brand = n == null ||n.equals("") ? brands.get(0).toString() : n;
				//����brand��ȡid
				TypeDao typyDao = new TypeDao();
				Integer goodid = typyDao.findTypeIdbyGname(brand);
			//����
				p.setGoodid(goodid);
			}
		});
		
		
         saveUpdateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productnameText = productname.getText();
				String productpriceText = productprice.getText();
				String productdescText = productdesc.getText();
				String productnumText = productnum.getText();
				//��װtype��������
				p.setGoodname(productnameText);
				p.setGooddesc(productdescText);
				p.setPrice(Double.parseDouble(productpriceText));
			    p.setNumber(Integer.parseInt(productnumText));
			

//�޸�

				ProductDao productDao = new ProductDao();
				int i = productDao.updateProduct(p);
				
				if ( i == 1) {
					//ҳ��ת��
					index.setVisible(false);
					System.out.println("��Ʒ���");
					//������ҳ��
					//new IndexAdmin(usernameText);
					new ProductSeletUI("yemei");
				}

				
				
				
		}
		});

				
	}
	}
}