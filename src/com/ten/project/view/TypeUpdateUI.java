package com.ten.project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ten.project.bean.Type;
import com.ten.project.dao.TypeDao;

public class TypeUpdateUI extends IndexAdmin{
//type
	Type type;
	
	public TypeUpdateUI(String username, int typeid) {
		super(username);
		//为type赋值
		TypeDao typedao = new TypeDao();
		//根据id查询type信息
		type = typedao.findTypeById(typeid);
		//调用init方法初始化
		init();
	}

	//初始化字体
	Font d = new Font("黑体", Font.BOLD, 16);
	
	//初始化对象
	JLabel typecolorla = new JLabel("颜色");
	JLabel typebrandla = new JLabel("品牌");
	JLabel typegflagla = new JLabel("0上架/1下架");
	JLabel typela = new JLabel("类型");
	
	
	JTextField typecolor = new JTextField();
	JTextField typebrand = new JTextField();
	JTextField typegflag = new JTextField();

	JRadioButton radioButton1 = new JRadioButton("台式");// 单选框
    JRadioButton radioButton2 = new JRadioButton("笔记本");
//按钮组
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton addTypeButton = new JButton("保存");

	private void init() {
		//按钮组
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);

		//用户名
		typecolorla.setBounds(120,150,100,30);
		typecolorla.setFont(f);
		//
	//
		typebrandla.setBounds(120,210,100,30);
		typebrandla.setFont(f);
		//
		typegflagla.setBounds(120,270,100,30);
		typegflagla.setFont(f);
		//
		typela.setBounds(120,330,100,30);
		typela.setFont(f);
		//输入框  //设置回显
		typecolor.setBounds(250,150,200,30);
		typecolor.setText(type.getColor());
		
		typebrand.setBounds(250,210,200,30);
		typebrand.setText(type.getBrand());
		
		typegflag.setBounds(250,270,200,30);
		typegflag.setText(type.getGflag().toString());

		radioButton1.setBounds(250,330,80,30);
		radioButton2.setBounds(350,330,80,30);

			//按钮
		addTypeButton.setBounds(120,390,330,50);
		//设置默认
		radioButton1.setSelected(type.getGoodtype() ==0 ? true : false);
		radioButton2.setSelected(type.getGoodtype() ==1 ? true : false);

		

		index.add(typecolorla);
		index.add(typebrandla);
		index.add(typela);
		index.add(typegflagla);
		
		index.add(typecolor);
		index.add(typebrand);
		index.add(typegflag);

		index.add(radioButton1);
		index.add(radioButton2);
		index.add(addTypeButton);
		
		//添加事件
		addTypeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				String typecolorText = typecolor.getText();
				String typebrandText = typebrand.getText();	
				String typegflagText = typegflag.getText();	
				//封装type类型数据
				type.setGflag(Integer.getInteger(typegflagText));
				type.setColor(typecolorText);
				type.setBrand(typebrandText);
				if (radioButton1.isSelected()) {
					type.setGoodtype(0);
				}
				if (radioButton2.isSelected()) {
					type.setGoodtype(1);
				}

//修改
				TypeDao typeDao = new TypeDao();
				int i = typeDao.updateType(type);
				
				if (i == 1) {
					//页面转换
					index.setVisible(false);
			
					//构建新页面
				
				new TypeSeletUI("你");
				}
				
				
			}
		});

		
	}

}
