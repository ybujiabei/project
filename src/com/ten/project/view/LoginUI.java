package com.ten.project.view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ten.project.bean.User;
import com.ten.project.dao.UserDao;

public class LoginUI {
	//类中声明用到的组件
	//初始化字体
	Font d = new Font("黑体", Font.BOLD, 42);
	Font f = new Font("黑体", Font.BOLD, 25);

	JFrame loginui = new JFrame("用户登录注册页面");

	JLabel system = new JLabel("电脑网络销售推广管理系统");
	JLabel usernamela = new JLabel("用户名:");
	JLabel passwordla = new JLabel("密码:");
	JLabel usertypela = new JLabel("角色:");
	

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();

	JComboBox<String> usertype = new JComboBox<String>(new String[] { "买家","管理员" });

	JButton login = new JButton("登录");
	User user = new User();

	private void loginui() {
		loginui.setBounds(1200,120, 650, 500);
		loginui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginui.setVisible(true);
		//绝对布局
		loginui.setLayout(null);
		//系统名称
		system.setBounds(150,80,300,40);
		system.setFont(d);
//用户名
		usernamela.setBounds(120,150,100,30);
		usernamela.setFont(f);
		//密码
		passwordla.setBounds(120,210,100,30);
		passwordla.setFont(f);
	//
		usertypela.setBounds(120,270,100,30);
		usertypela.setFont(f);
	//输入框
		username.setBounds(250,150,200,30);
		password.setBounds(250,210,200,30);
		usertype.setBounds(250,270,200,30);
		//按钮
		login.setBounds(120,330,330,50);

		loginui.add(login);
		loginui.add(usertype);
		loginui.add(password);
		loginui.add(username);
		loginui.add(usertypela);
		loginui.add(passwordla);
		loginui.add(usernamela);
		loginui.add(system);

		// 添加事件
		usertype.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox j = (JComboBox) e.getSource();
				if (j.getSelectedItem().equals("管理员")) {
					user.setUsertype(0);
				}else {
					user.setUsertype(1);
				}
			}
		});
		//登录
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取用户密码
				String usernameText = username.getText();
				char[] p = password.getPassword();
				String passwordText = new String(p);
				//判断
				if (usernameText.trim().equals("")) {
					//提示
//					JOptionPane.showMessageDialog(null, "用户名不能为空");
				}
				//存入到user
				user.setUsername(usernameText);
				user.setPassword(passwordText);
				//根据用户名密码验证
				UserDao userDao = new UserDao();
				//检验
				Boolean u = userDao.checkUser(user);
				//if (!u) {
				if (u) {
					
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
					username.setText("");
					password.setText("");
				}else {
					//设置页面隐藏
					loginui.setVisible(false);
					//构建新页面
					//new IndexAdmin(usernameText);
					new IndexAdmin("yemei");
					
				}
			}
		});
	}
	

	
	
	
	
	
	//程序入口
	public static void main(String[] args) {
		LoginUI login = new LoginUI();
		login.loginui();
	}

}



