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
	JLabel typela = new JLabel("类型（0台式，1笔记本）");
	JLabel typegflagla = new JLabel("是否上架");
	
	
	JTextField typecolor = new JTextField();
	JTextField typebrand = new JTextField();
	JTextField type1 = new JTextField();

//    JRadioButton radioButton3 = new JRadioButton("台式");// 单选框
//    JRadioButton radioButton4 = new JRadioButton("笔记本");
	JRadioButton radioButton1 = new JRadioButton("上架");// 单选框
    JRadioButton radioButton2 = new JRadioButton("下架");
//按钮组
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton addTypeButton = new JButton("保存");

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
	//
		typebrandla.setBounds(120,210,100,30);
		typebrandla.setFont(f);
		//
		typela.setBounds(120,270,390,30);
		typela.setFont(f);
		//
		typegflagla.setBounds(120,330,100,30);
		typegflagla.setFont(f);
		//输入框  //设置回显
		typecolor.setBounds(250,150,200,30);
		typecolor.setText(type.getColor());
		
		typebrand.setBounds(250,210,200,30);
		typebrand.setText(type.getBrand());
		
		type1.setBounds(250,270,200,30);
		type1.setText(type.getGoodtype().toString());

		radioButton1.setBounds(250,330,80,30);
		radioButton2.setBounds(350,330,80,30);

			//按钮
		addTypeButton.setBounds(120,390,330,50);
		//设置默认
		radioButton1.setSelected(type.getGflag()==1 ? true : false);
		radioButton2.setSelected(type.getGflag()==0 ? true : false);

		

		index.add(typecolorla);
		index.add(typebrandla);
		index.add(typela);
		index.add(typegflagla);
		
		index.add(typecolor);
		index.add(typebrand);
		index.add(type1);

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
				//封装type类型数据
				type.setGoodtype(type1Text);
				type.setColor(typecolorText);
				type.setBrand(typebrandText);
				if (radioButton1.isSelected()) {
					type.setGflag(0);
				}
				if (radioButton2.isSelected()) {
					type.setGflag(1);
				}

//修改
				TypeDao typeDao = new TypeDao();
				int i = typeDao.updateType(type);
				
				if (i == 1) {
					//页面转换
					index.setVisible(false);
			
					//构建新页面
				
					new TypeSeletUI("yemei");
				}
				
				
			}
		});

		
	}

}
