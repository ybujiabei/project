package com.ten.project.view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ten.project.bean.User;
import com.ten.project.dao.UserDao;

public class RegisterUI {
	

	public RegisterUI() {
		super();
		registerui();
	}
	//类中声明用到的组件
	//初始化字体
	Font d = new Font("黑体", Font.BOLD, 27);
	Font f = new Font("黑体", Font.BOLD, 18);

	JFrame registerui = new JFrame("用户注册页面");

	JLabel system = new JLabel("电脑网络销售推广管理系统");
	JLabel usernamela = new JLabel("用户名:");
	JLabel passwordla = new JLabel("密码:");
	JLabel usertypela = new JLabel("角色:");
	JLabel phonela = new JLabel("电话:");
	

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JTextField phone = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("买家");// 单选框
    JRadioButton radioButton2 = new JRadioButton("管理员");
	//JComboBox<String> usertype = new JComboBox<String>(new String[] { "买家","管理员" });
//按钮组
    ButtonGroup btButtonGroup;
	JButton register = new JButton("注册");
	User user = new User();
//绘制注册页面
	private void registerui() {
		registerui.setBounds(1200,300,800,700);
		registerui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerui.setVisible(true);
		//绝对布局
		registerui.setLayout(null);
		//系统名称
		system.setBounds(150,80,400,40);
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
		//
		phonela.setBounds(120,330,100,30);
		phonela.setFont(f);
	//输入框
		username.setBounds(250,150,200,30);
		password.setBounds(250,210,200,30);
		//usertype.setBounds(250,270,200,30);
		phone.setBounds(250,330,200,30);
		//type
		radioButton1.setBounds(250,270,80,30);
		radioButton2.setBounds(350,270,80,30);
		//按钮
		register.setBounds(120,400,330,50);

		registerui.add(register);
		registerui.add(radioButton1);
		registerui.add(radioButton2);
		registerui.add(password);
		registerui.add(username);
		registerui.add(usertypela);
		registerui.add(passwordla);
		registerui.add(usernamela);
		registerui.add(system);
		registerui.add(phone);
		registerui.add(phonela);
		//角色类型
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		radioButton1.setSelected(true);

		// 添加事件
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//获取用户密码
				String usernameText = username.getText();
				String phoneText = phone.getText();
				char[] p = password.getPassword();
				String passwordText = new String(p);
				
				if (radioButton1.isSelected()) {
					user.setUsertype(0);
				}
				if (radioButton2.isSelected()) {
				     user.setUsertype(1);
				}
				
				//判断
				if (usernameText.trim().equals("")) {
					//提示
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				}
				//存入到user
				user.setUsername(usernameText);
				user.setPassword(passwordText);
				user.setPhone(Integer.parseInt(phoneText));
				
				UserDao userDao = new UserDao();
				
				int i = userDao.saveUser(user);
				if( i==1 ) {
					JOptionPane.showConfirmDialog(null, "注册成功，请登录！");
					register.setVisible(false);
					System.out.println("");
					new LoginUI();

				}
					
				}
			
		});
	}
	

	
	
	
	


}



