
package com.ten.project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ten.project.bean.Type;
import com.ten.project.dao.TypeDao;

public class TypeAddUI extends IndexAdmin {
	//初始化字体
	Font d = new Font("黑体", Font.BOLD, 16);
	Type type = new Type();
	JLabel typecolorla = new JLabel("颜色");
	JLabel typebrandla = new JLabel("品牌");
	JLabel typela = new JLabel("类型（0台式，1笔记本）");
	JLabel typegflagla = new JLabel("是否上架");
	//JLabel typeidla = new JLabel("id");
	
	
	JTextField typecolor = new JTextField();
	JTextField typebrand = new JTextField();
	JTextField type1 = new JTextField();
	//JTextField typeid = new JTextField();
//    JRadioButton radioButton3 = new JRadioButton("台式");// 单选框
//    JRadioButton radioButton4 = new JRadioButton("笔记本");
	JRadioButton radioButton1 = new JRadioButton("上架");// 单选框
    JRadioButton radioButton2 = new JRadioButton("下架");
//按钮组
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton addTypeButton = new JButton("保存");

	public TypeAddUI(String username) {
		super(username);
	    init();
	}

	private void init() {
		//按钮组
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
//		btButtonGroup.add(radioButton3);
//		btButtonGroup.add(radioButton4);
		//用户名
		typecolorla.setBounds(120,150,100,30);
		typecolorla.setFont(f);
	//
		typebrandla.setBounds(120,210,100,30);
		typebrandla.setFont(f);
		//
		typela.setBounds(120,270,390,30);
		typela.setFont(f);
		//
		typegflagla.setBounds(120,330,100,30);
		typegflagla.setFont(f);
		//
		//typeidla.setBounds(120,360,100,30);
		//typeid.setFont(f);
		//输入框
		typecolor.setBounds(250,150,200,30);
		typebrand.setBounds(250,210,200,30);
		type1.setBounds(250,270,200,30);
		radioButton1.setBounds(250,330,80,30);
		radioButton2.setBounds(350,330,80,30);
		//typeid.setBounds(250,360,200,30);
//		radioButton3.setBounds(250,330,80,30);
//		radioButton4.setBounds(350,330,80,30);
			//按钮
		addTypeButton.setBounds(120,390,330,50);
		//设置默认
		radioButton1.setSelected(true);
		//radioButton3.setSelected(true);
		

		index.add(typecolorla);
		index.add(typebrandla);
		index.add(typela);
		index.add(typegflagla);
		
		index.add(typecolor);
		index.add(typebrand);
		index.add(type1);
		//index.add(typeid);
		//index.add(typeidla);
		index.add(radioButton1);
		index.add(radioButton2);
//		index.add(radioButton3);
//		index.add(radioButton4);
		index.add(addTypeButton);
		
		//添加事件
		addTypeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String typecolorText = typecolor.getText();
				String typebrandText = typebrand.getText();	
				Integer type1Text = type1.getCaretPosition();
				//Integer typeidText = typeid.getCaretPosition();
				//封装type类型数据
				type.setGoodtype(type1Text);
				type.setColor(typecolorText);
				type.setBrand(typebrandText);
				//type.setGoodid(typeidText);
				if (radioButton1.isSelected()) {
					type.setGflag(0);
				}
				if (radioButton2.isSelected()) {
					type.setGflag(1);
				}
//				if (radioButton3.isSelected()) {
//					type.setGoodtype(3);
//				}
//				if (radioButton4.isSelected()) {
//					type.setGoodtype(4);
//				}
//添加
				TypeDao typeDao = new TypeDao();
				Boolean b = typeDao.addType(type);
				
				if (b) {
					//页面转换
					index.setVisible(false);
					System.out.println("商品类别");
					//构建新页面
					//new IndexAdmin(usernameText);
					new TypeSeletUI("yemei");
				}

				
				
				
			}
		});

		
	}

}
