
package com.ten.project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class IndexAdmin {
	Font d = new Font("黑体", Font.BOLD, 20);
	Font f = new Font("黑体", Font.BOLD, 16);
     //声明对象
	public JFrame index;
	private JMenuBar managerMenu;
	//一级
	private JMenu productMenu;
	//二级
	private JMenuItem productltem;
	private JMenuItem typeltem;

	public IndexAdmin(String username) {
		//初始化
		Indexadmin();
		//框架初始化
		init(username);
		//设置点击回调
		action(username);
	}


	private void action(String username) {
		typeltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				System.out.println("商品类别");
				//构建新页面
				new TypeSeletUI(username);
				
				
			}
		});
		productltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				System.out.println("商品管理");
				//构建新页面
				new ProductSeletUI(username);
				
				
			}
		});
	}

	private void init(String username) {
		//index
		index = new JFrame("欢迎："+username+"使用系统");
		index.setBounds(1200,120, 650, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		index.setVisible(true);
		//添加菜单
		index.setJMenuBar(managerMenu);
		index.setLayout(null);
		
		
	}
//设置对象字符串 字体
	private void Indexadmin() {
		managerMenu = new JMenuBar();
		//菜单
		productMenu = new JMenu("商品模块");
		productMenu.setFont(f);
		//子菜单
		productltem = new JMenuItem("商品管理");
		productltem.setFont(d);
		typeltem = new JMenuItem("类别管理");
		typeltem.setFont(d);
		//添加菜单
		managerMenu.add(productMenu);
		productMenu.add(productltem);
		productMenu.add(typeltem);
		
		
	}
	
	
	

}
