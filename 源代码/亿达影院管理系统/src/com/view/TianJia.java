package com.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TianJia extends JDialog implements ActionListener {

	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JPanel jp1,jp2,jp3;
	
	//owner它的父窗口
	//title名字
	//modal模式窗口或者非模式窗口（窗口弹出是否可以点击它处）
	public TianJia(Frame owner,String title,boolean modal)
	{
		super(owner,title,modal);
		jl1 = new JLabel("编号");
		jl1 = new JLabel("名字");
		jl1 = new JLabel("电话");
		jl1 = new JLabel("岗位");
		jl1 = new JLabel("等级");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		
		jb1 = new JButton("添加");
		jb1 = new JButton("取消");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		jp2.add(jl1);
		jp2.add(jl2);
		jp2.add(jl3);
		jp2.add(jl4);
		jp2.add(jl5);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		
		this.setSize(300,200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
