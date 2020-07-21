
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
	//��ʼ������
	Font d = new Font("����", Font.BOLD, 16);
	Type type = new Type();
	JLabel typecolorla = new JLabel("��ɫ");
	JLabel typebrandla = new JLabel("Ʒ��");
	JLabel typela = new JLabel("���ͣ�0̨ʽ��1�ʼǱ���");
	JLabel typegflagla = new JLabel("�Ƿ��ϼ�");
	//JLabel typeidla = new JLabel("id");
	
	
	JTextField typecolor = new JTextField();
	JTextField typebrand = new JTextField();
	JTextField type1 = new JTextField();
	//JTextField typeid = new JTextField();
//    JRadioButton radioButton3 = new JRadioButton("̨ʽ");// ��ѡ��
//    JRadioButton radioButton4 = new JRadioButton("�ʼǱ�");
	JRadioButton radioButton1 = new JRadioButton("�ϼ�");// ��ѡ��
    JRadioButton radioButton2 = new JRadioButton("�¼�");
//��ť��
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton addTypeButton = new JButton("����");

	public TypeAddUI(String username) {
		super(username);
	    init();
	}

	private void init() {
		//��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
//		btButtonGroup.add(radioButton3);
//		btButtonGroup.add(radioButton4);
		//�û���
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
		//�����
		typecolor.setBounds(250,150,200,30);
		typebrand.setBounds(250,210,200,30);
		type1.setBounds(250,270,200,30);
		radioButton1.setBounds(250,330,80,30);
		radioButton2.setBounds(350,330,80,30);
		//typeid.setBounds(250,360,200,30);
//		radioButton3.setBounds(250,330,80,30);
//		radioButton4.setBounds(350,330,80,30);
			//��ť
		addTypeButton.setBounds(120,390,330,50);
		//����Ĭ��
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
		
		//�����¼�
		addTypeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String typecolorText = typecolor.getText();
				String typebrandText = typebrand.getText();	
				Integer type1Text = type1.getCaretPosition();
				//Integer typeidText = typeid.getCaretPosition();
				//��װtype��������
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
//����
				TypeDao typeDao = new TypeDao();
				Boolean b = typeDao.addType(type);
				
				if (b) {
					//ҳ��ת��
					index.setVisible(false);
					System.out.println("��Ʒ���");
					//������ҳ��
					//new IndexAdmin(usernameText);
					new TypeSeletUI("yemei");
				}

				
				
				
			}
		});

		
	}

}