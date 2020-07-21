
package com.ten.project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class IndexAdmin {
	Font d = new Font("����", Font.BOLD, 20);
	Font f = new Font("����", Font.BOLD, 16);
     //��������
	public JFrame index;
	private JMenuBar managerMenu;
	//һ��
	private JMenu productMenu;
	//����
	private JMenuItem productltem;
	private JMenuItem typeltem;

	public IndexAdmin(String username) {
		//��ʼ��
		Indexadmin();
		//��ܳ�ʼ��
		init(username);
		//���õ���ص�
		action(username);
	}


	private void action(String username) {
		typeltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				System.out.println("��Ʒ���");
				//������ҳ��
				new TypeSeletUI(username);
				
				
			}
		});
		productltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				System.out.println("��Ʒ����");
				//������ҳ��
				new ProductSeletUI(username);
				
				
			}
		});
	}

	private void init(String username) {
		//index
		index = new JFrame("��ӭ��"+username+"ʹ��ϵͳ");
		index.setBounds(1200,120, 650, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		index.setVisible(true);
		//��Ӳ˵�
		index.setJMenuBar(managerMenu);
		index.setLayout(null);
		
		
	}
//���ö����ַ��� ����
	private void Indexadmin() {
		managerMenu = new JMenuBar();
		//�˵�
		productMenu = new JMenu("��Ʒģ��");
		productMenu.setFont(f);
		//�Ӳ˵�
		productltem = new JMenuItem("��Ʒ����");
		productltem.setFont(d);
		typeltem = new JMenuItem("������");
		typeltem.setFont(d);
		//��Ӳ˵�
		managerMenu.add(productMenu);
		productMenu.add(productltem);
		productMenu.add(typeltem);
		
		
	}
	
	
	

}
