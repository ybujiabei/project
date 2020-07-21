
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
	//声明对象
	private JTable typeTable;
	Font d = new Font("黑体", Font.BOLD, 20);
	Font f = new Font("黑体", Font.BOLD, 16);
	JButton addButton;
	JButton delButton;
	JScrollPane jp = null;
	JButton updateButton;
	//获取id
	int typeid;
	public TypeSeletUI(String username) {
		super(username);
		init();
		typeaction(username);
		
	}

	private void typeaction(String username) {
		//添加
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新页面
				new TypeAddUI(username);
				
			}
		});
		//表格添加事件
		typeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        //为id赋值
				typeid = (int) typeTable.getValueAt(typeTable.getSelectedRow(), 0);
				System.out.println(typeid);
			}
		});
		//删除按钮添加事件
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
     //        System.out.println(typeid);
				if (typeid == 0) {
					JOptionPane.showConfirmDialog(null, "请选择要删除的记录！");
				}else {
					//提示
					int mess = JOptionPane.showConfirmDialog(null, "确认要删除吗？","提示信息",JOptionPane.YES_NO_CANCEL_OPTION);
//0 yes 1 no
					if (mess == 0) {
						TypeDao typeDao = new TypeDao();
						int del = typeDao.delTypeById(typeid);
						if (del == 1) {
							JOptionPane.showConfirmDialog(null, "删除成功！");
							//重新绘制页面表格标题
							Vector tt = new Vector<>();
							tt.add("id");
							tt.add("品牌");
							tt.add("颜色");
							tt.add("类型");
							tt.add("上架时间");	
							tt.add("状态");
						
							//数据
					
							Vector list = typeDao.findAllType();
		       
							JTable table = new JTable(list,tt);
							table.setFont(d);
							JScrollPane jptable = new JScrollPane(table);
							jptable.setBounds(50, 80, 550, 300);
							//移除旧的组件
							index.remove(jp);
							//添加新组建
							index.add(jptable);
							//重新绘制
							index.repaint();
						}
					}
			        
					

				}
				
			}
		});
		//修改
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (typeid == 0) {
					JOptionPane.showConfirmDialog(null, "请选择要修改的记录！");
				}else {
					index.setVisible(false);
					new TypeUpdateUI(username,typeid);
				}
			}
		});
	}
	private void init() {
		
		//表格说明
		JLabel title = new JLabel("商品类别信息");
		title.setFont(f);
		title.setBounds(200,30,200,50);
		//添加按钮
		addButton = new JButton("添加");
		addButton.setFont(f);
		addButton.setBounds(300,30,100,30);
		//删除按钮
		delButton = new JButton("删除");
		delButton.setFont(f);
		delButton.setBounds(500,30,100,30);
		//修改按钮
		updateButton = new JButton("修改");
		updateButton.setFont(f);
		updateButton.setBounds(400,30,100,30);
		//表格标题
		Vector tt = new Vector<>();
		tt.add("id");
		tt.add("品牌");
		tt.add("颜色");
		tt.add("类型");
		tt.add("上架时间");	
		tt.add("状态");
	
		//数据
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
