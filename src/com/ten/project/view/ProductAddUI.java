package com.ten.project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ten.project.bean.Product;
import com.ten.project.dao.ProductDao;
import com.ten.project.dao.TypeDao;

public class ProductAddUI extends IndexAdmin {


	public ProductAddUI(String username) {
		super(username);
		init();
	}
	//��ʼ������
	Font d = new Font("����", Font.BOLD, 16);
	Product product = new Product();
	//��ʼ������
	JLabel productpidla = new JLabel("����id");
	JLabel productnamela = new JLabel("����");
	JLabel productpricela = new JLabel("�۸�");
	JLabel productnumla = new JLabel("����");
	JLabel productdescla = new JLabel("���");
	JLabel producttypela = new JLabel("����");
	JLabel producbrandla = new JLabel("Ʒ��");
	
	JTextField productname = new JTextField();
	JTextField productprice = new JTextField();
	JTextField productnum = new JTextField();
	JTextField productdesc = new JTextField();
	JTextField productpid = new JTextField();
	
	JRadioButton radioButton1 = new JRadioButton("̨ʽ");// ��ѡ��
    JRadioButton radioButton2 = new JRadioButton("�ʼǱ�");
	//��ȡ����
	TypeDao typeDao = new TypeDao();
    Vector brands = typeDao.findAllbrand();
	JComboBox<String> producttype = new JComboBox<>(brands);
    
//��ť��
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton addTypeButton = new JButton("����");


	private void init() {
		//��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);

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
		producttypela.setBounds(120,450,100,30);
		producttypela.setFont(f);
		//
		producbrandla.setBounds(120,500,100,30);
		producbrandla.setFont(f);
		//
		productpidla.setBounds(120,530,100,30);
		productpid.setFont(f);
		//�����
		productname.setBounds(250,150,200,30);
		productprice.setBounds(250,210,200,30);
		productnum.setBounds(250,270,200,30);
		productdesc.setBounds(250,330,200,30);
		radioButton1.setBounds(250,450,80,30);
		radioButton2.setBounds(350,450,80,30);
		productpid.setBounds(250,520,200,30);

			//��ť
		addTypeButton.setBounds(120,550,330,50);
		//����Ĭ��
		radioButton1.setSelected(true);


		productdesc.setBounds(250,330,100,80);
		producttype.setBounds(200,500, 100, 30);
		
		
		index.add(productnamela);
		index.add(productpricela);
		index.add(productnumla);
		index.add(productdescla);
		index.add(producttypela);
		index.add(producbrandla);
		index.add(productpidla);
		index.add(productpid);
		index.add(productname);
		index.add(productprice);
		index.add(productdesc);
		index.add(producttype);
		index.add(productnum);
		index.add(radioButton1);
		index.add(radioButton2);

		index.add(addTypeButton);
		
		//����¼�
		
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
				product.setGoodid(goodid);
			}
		});
		
		
		addTypeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productnameText = productname.getText();
				String productpriceText = productprice.getText();
				String productdescText = productdesc.getText();
				String productnumText = productnum.getText();
				String productidText = productpid.getText();
				//��װtype��������
				product.setGoodname(productnameText);
				product.setGooddesc(productdescText);
				product.setPrice(Double.parseDouble(productpriceText));
			    product.setNumber(Integer.parseInt(productnumText));
			    product.setGoodid(Integer.parseInt(productidText));
			
				if (radioButton1.isSelected()) {
					product.setGoodtype(0);
				}
				if (radioButton2.isSelected()) {
					product.setGoodtype(1);
				}

//���

				ProductDao productDao = new ProductDao();
				int p = productDao.savaProduct(product);
				
				if ( p == 1) {
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
