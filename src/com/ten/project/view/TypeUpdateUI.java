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
	JLabel typela = new JLabel("���ͣ�0̨ʽ��1�ʼǱ���");
	JLabel typegflagla = new JLabel("�Ƿ��ϼ�");
	
	
	JTextField typecolor = new JTextField();
	JTextField typebrand = new JTextField();
	JTextField type1 = new JTextField();

//    JRadioButton radioButton3 = new JRadioButton("̨ʽ");// ��ѡ��
//    JRadioButton radioButton4 = new JRadioButton("�ʼǱ�");
	JRadioButton radioButton1 = new JRadioButton("�ϼ�");// ��ѡ��
    JRadioButton radioButton2 = new JRadioButton("�¼�");
//��ť��
    ButtonGroup btButtonGroup = new ButtonGroup();
    JButton addTypeButton = new JButton("����");

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
	//
		typebrandla.setBounds(120,210,100,30);
		typebrandla.setFont(f);
		//
		typela.setBounds(120,270,390,30);
		typela.setFont(f);
		//
		typegflagla.setBounds(120,330,100,30);
		typegflagla.setFont(f);
		//�����  //���û���
		typecolor.setBounds(250,150,200,30);
		typecolor.setText(type.getColor());
		
		typebrand.setBounds(250,210,200,30);
		typebrand.setText(type.getBrand());
		
		type1.setBounds(250,270,200,30);
		type1.setText(type.getGoodtype().toString());

		radioButton1.setBounds(250,330,80,30);
		radioButton2.setBounds(350,330,80,30);

			//��ť
		addTypeButton.setBounds(120,390,330,50);
		//����Ĭ��
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
		
		//����¼�
		addTypeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				String typecolorText = typecolor.getText();
				String typebrandText = typebrand.getText();	
				Integer type1Text = type1.getCaretPosition();
				//��װtype��������
				type.setGoodtype(type1Text);
				type.setColor(typecolorText);
				type.setBrand(typebrandText);
				if (radioButton1.isSelected()) {
					type.setGflag(0);
				}
				if (radioButton2.isSelected()) {
					type.setGflag(1);
				}

//�޸�
				TypeDao typeDao = new TypeDao();
				int i = typeDao.updateType(type);
				
				if (i == 1) {
					//ҳ��ת��
					index.setVisible(false);
			
					//������ҳ��
				
					new TypeSeletUI("yemei");
				}
				
				
			}
		});

		
	}

}
