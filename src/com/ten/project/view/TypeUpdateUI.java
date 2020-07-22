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
		//Ϊtype��ֵ
		TypeDao typedao = new TypeDao();
		//����id��ѯtype��Ϣ
		type = typedao.findTypeById(typeid);
		//����init������ʼ��
		init();
	}

	//��ʼ������
	Font d = new Font("����", Font.BOLD, 16);
	
	//��ʼ������
	JLabel typecolorla = new JLabel("��ɫ");
	JLabel typebrandla = new JLabel("Ʒ��");
	JLabel typegflagla = new JLabel("0�ϼ�/1�¼�");
	JLabel typela = new JLabel("����");
	
	
	JTextField typecolor = new JTextField();
	JTextField typebrand = new JTextField();
	JTextField typegflag = new JTextField();

	JRadioButton radioButton1 = new JRadioButton("̨ʽ");// ��ѡ��
    JRadioButton radioButton2 = new JRadioButton("�ʼǱ�");
//��ť��
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton addTypeButton = new JButton("����");

	private void init() {
		//��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);

		//�û���
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
		//�����  //���û���
		typecolor.setBounds(250,150,200,30);
		typecolor.setText(type.getColor());
		
		typebrand.setBounds(250,210,200,30);
		typebrand.setText(type.getBrand());
		
		typegflag.setBounds(250,270,200,30);
		typegflag.setText(type.getGflag().toString());

		radioButton1.setBounds(250,330,80,30);
		radioButton2.setBounds(350,330,80,30);

			//��ť
		addTypeButton.setBounds(120,390,330,50);
		//����Ĭ��
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
		
		//����¼�
		addTypeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				String typecolorText = typecolor.getText();
				String typebrandText = typebrand.getText();	
				String typegflagText = typegflag.getText();	
				//��װtype��������
				type.setGflag(Integer.getInteger(typegflagText));
				type.setColor(typecolorText);
				type.setBrand(typebrandText);
				if (radioButton1.isSelected()) {
					type.setGoodtype(0);
				}
				if (radioButton2.isSelected()) {
					type.setGoodtype(1);
				}

//�޸�
				TypeDao typeDao = new TypeDao();
				int i = typeDao.updateType(type);
				
				if (i == 1) {
					//ҳ��ת��
					index.setVisible(false);
			
					//������ҳ��
				
				new TypeSeletUI("��");
				}
				
				
			}
		});

		
	}

}
