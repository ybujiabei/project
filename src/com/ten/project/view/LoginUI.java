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
	//���������õ������
	//��ʼ������
	Font d = new Font("����", Font.BOLD, 42);
	Font f = new Font("����", Font.BOLD, 25);

	JFrame loginui = new JFrame("�û���¼ע��ҳ��");

	JLabel system = new JLabel("�������������ƹ����ϵͳ");
	JLabel usernamela = new JLabel("�û���:");
	JLabel passwordla = new JLabel("����:");
	JLabel usertypela = new JLabel("��ɫ:");
	

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();

	JComboBox<String> usertype = new JComboBox<String>(new String[] { "���","����Ա" });

	JButton login = new JButton("��¼");
	User user = new User();

	private void loginui() {
		loginui.setBounds(1200,120, 650, 500);
		loginui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginui.setVisible(true);
		//���Բ���
		loginui.setLayout(null);
		//ϵͳ����
		system.setBounds(150,80,300,40);
		system.setFont(d);
//�û���
		usernamela.setBounds(120,150,100,30);
		usernamela.setFont(f);
		//����
		passwordla.setBounds(120,210,100,30);
		passwordla.setFont(f);
	//
		usertypela.setBounds(120,270,100,30);
		usertypela.setFont(f);
	//�����
		username.setBounds(250,150,200,30);
		password.setBounds(250,210,200,30);
		usertype.setBounds(250,270,200,30);
		//��ť
		login.setBounds(120,330,330,50);

		loginui.add(login);
		loginui.add(usertype);
		loginui.add(password);
		loginui.add(username);
		loginui.add(usertypela);
		loginui.add(passwordla);
		loginui.add(usernamela);
		loginui.add(system);

		// ����¼�
		usertype.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox j = (JComboBox) e.getSource();
				if (j.getSelectedItem().equals("����Ա")) {
					user.setUsertype(0);
				}else {
					user.setUsertype(1);
				}
			}
		});
		//��¼
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û�����
				String usernameText = username.getText();
				char[] p = password.getPassword();
				String passwordText = new String(p);
				//�ж�
				if (usernameText.trim().equals("")) {
					//��ʾ
//					JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				}
				//���뵽user
				user.setUsername(usernameText);
				user.setPassword(passwordText);
				//�����û���������֤
				UserDao userDao = new UserDao();
				//����
				Boolean u = userDao.checkUser(user);
				//if (!u) {
				if (u) {
					
					JOptionPane.showMessageDialog(null, "�û������������");
					username.setText("");
					password.setText("");
				}else {
					//����ҳ������
					loginui.setVisible(false);
					//������ҳ��
					//new IndexAdmin(usernameText);
					new IndexAdmin("yemei");
					
				}
			}
		});
	}
	

	
	
	
	
	
	//�������
	public static void main(String[] args) {
		LoginUI login = new LoginUI();
		login.loginui();
	}

}



