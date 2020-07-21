
package com.ten.project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.ten.project.dao.TypeDao;

public class TypeSeletUI extends IndexAdmin {
	//��������
	private JTable typeTable;
	Font d = new Font("����", Font.BOLD, 20);
	Font f = new Font("����", Font.BOLD, 16);
	JButton addButton;
	JButton delButton;
	JScrollPane jp = null;
	JButton updateButton;
	//��ȡid
	int typeid;
	public TypeSeletUI(String username) {
		super(username);
		init();
		typeaction(username);
		
	}

	private void typeaction(String username) {
		//���
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//������ҳ��
				new TypeAddUI(username);
				
			}
		});
		//�������¼�
		typeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        //Ϊid��ֵ
				typeid = (int) typeTable.getValueAt(typeTable.getSelectedRow(), 0);
				System.out.println(typeid);
			}
		});
		//ɾ����ť����¼�
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
     //        System.out.println(typeid);
				if (typeid == 0) {
					JOptionPane.showConfirmDialog(null, "��ѡ��Ҫɾ���ļ�¼��");
				}else {
					//��ʾ
					int mess = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����","��ʾ��Ϣ",JOptionPane.YES_NO_CANCEL_OPTION);
//0 yes 1 no
					if (mess == 0) {
						TypeDao typeDao = new TypeDao();
						int del = typeDao.delTypeById(typeid);
						if (del == 1) {
							JOptionPane.showConfirmDialog(null, "ɾ���ɹ���");
							//���»���ҳ�������
							Vector tt = new Vector<>();
							tt.add("id");
							tt.add("Ʒ��");
							tt.add("��ɫ");
							tt.add("����");
							tt.add("�ϼ�ʱ��");	
							tt.add("״̬");
						
							//����
					
							Vector list = typeDao.findAllType();
		       
							JTable table = new JTable(list,tt);
							table.setFont(d);
							JScrollPane jptable = new JScrollPane(table);
							jptable.setBounds(50, 80, 550, 300);
							//�Ƴ��ɵ����
							index.remove(jp);
							//������齨
							index.add(jptable);
							//���»���
							index.repaint();
						}
					}
			        
					

				}
				
			}
		});
		//�޸�
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (typeid == 0) {
					JOptionPane.showConfirmDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
				}else {
					index.setVisible(false);
					new TypeUpdateUI(username,typeid);
				}
			}
		});
	}
	private void init() {
		
		//���˵��
		JLabel title = new JLabel("��Ʒ�����Ϣ");
		title.setFont(f);
		title.setBounds(200,30,200,50);
		//��Ӱ�ť
		addButton = new JButton("���");
		addButton.setFont(f);
		addButton.setBounds(300,30,100,30);
		//ɾ����ť
		delButton = new JButton("ɾ��");
		delButton.setFont(f);
		delButton.setBounds(500,30,100,30);
		//�޸İ�ť
		updateButton = new JButton("�޸�");
		updateButton.setFont(f);
		updateButton.setBounds(400,30,100,30);
		//������
		Vector tt = new Vector<>();
		tt.add("id");
		tt.add("Ʒ��");
		tt.add("��ɫ");
		tt.add("����");
		tt.add("�ϼ�ʱ��");	
		tt.add("״̬");
	
		//����
		TypeDao typeDao = new TypeDao();
		Vector list = typeDao.findAllType();
		
		//System.out.println(list);
		
		typeTable = new JTable(list,tt);
		typeTable.setFont(d);
		jp = new JScrollPane(typeTable);
		jp.setBounds(50, 80, 550, 300);
		
		index.add(title);
		index.add(jp);
		index.add(addButton);
		index.add(delButton);
		index.add(updateButton);
	}
	
}
