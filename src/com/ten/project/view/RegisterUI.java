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
	//���������õ������
	//��ʼ������
	Font d = new Font("����", Font.BOLD, 27);
	Font f = new Font("����", Font.BOLD, 18);

	JFrame registerui = new JFrame("�û�ע��ҳ��");

	JLabel system = new JLabel("�������������ƹ����ϵͳ");
	JLabel usernamela = new JLabel("�û���:");
	JLabel passwordla = new JLabel("����:");
	JLabel usertypela = new JLabel("��ɫ:");
	JLabel phonela = new JLabel("�绰:");
	

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JTextField phone = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("���");// ��ѡ��
    JRadioButton radioButton2 = new JRadioButton("����Ա");
	//JComboBox<String> usertype = new JComboBox<String>(new String[] { "���","����Ա" });
//��ť��
    ButtonGroup btButtonGroup;
	JButton register = new JButton("ע��");
	User user = new User();
//����ע��ҳ��
	private void registerui() {
		registerui.setBounds(1200,300,800,700);
		registerui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerui.setVisible(true);
		//���Բ���
		registerui.setLayout(null);
		//ϵͳ����
		system.setBounds(150,80,400,40);
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
		//
		phonela.setBounds(120,330,100,30);
		phonela.setFont(f);
	//�����
		username.setBounds(250,150,200,30);
		password.setBounds(250,210,200,30);
		//usertype.setBounds(250,270,200,30);
		phone.setBounds(250,330,200,30);
		//type
		radioButton1.setBounds(250,270,80,30);
		radioButton2.setBounds(350,270,80,30);
		//��ť
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
		//��ɫ����
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		radioButton1.setSelected(true);

		// ����¼�
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û�����
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
				
				//�ж�
				if (usernameText.trim().equals("")) {
					//��ʾ
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				}
				//���뵽user
				user.setUsername(usernameText);
				user.setPassword(passwordText);
				user.setPhone(Integer.parseInt(phoneText));
				
				UserDao userDao = new UserDao();
				
				int i = userDao.saveUser(user);
				if( i==1 ) {
					JOptionPane.showConfirmDialog(null, "ע��ɹ������¼��");
					register.setVisible(false);
					System.out.println("");
					new LoginUI();

				}
					
				}
			
		});
	}
	

	
	
	
	


}



