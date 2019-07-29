package com.view;


import javax.swing.JDialog;

import com.dao.SqlHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EmployeeDialog extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JPanel jp1,jp2,jp3;
	public EmployeeDialog(Frame owner,String title, boolean modal)
	{
		super(owner,title,modal);
		jl1=new JLabel("员工工号");
		jl2=new JLabel("员工姓名");
		jl3=new JLabel("电话");
		jl4=new JLabel("职位");
		jl5=new JLabel("密码");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		
		jb1=new JButton("添加");
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	public EmployeeDialog(Yuangong yuangong, String title, boolean modal) {
		// TODO Auto-generated constructor stub
		jl1=new JLabel("员工工号");
		jl2=new JLabel("员工姓名");
		jl3=new JLabel("电话");
		jl4=new JLabel("职位");
		jl5=new JLabel("密码");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		
		jb1=new JButton("添加");
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		this.setSize(300,200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			String sql = "insert into Table_Employee values (?,?,?,?,?,?)";
			String[] paras= {jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),"",jtf5.getText()};
			SqlHelper sh = new SqlHelper();
			sh.update(sql, paras);
			this.dispose();
		}
		if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
}