package com.view;

import com.dao.SqlHelper;
import com.service.MovieModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class updateMovieDialog extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9;
	JPanel jp1,jp2,jp3;
	public updateMovieDialog(Frame owner,String title, boolean modal,MovieModel mm,int rowNum)
	{
		super(owner,title,modal);
		jl1=new JLabel("电影ID");
		jl2=new JLabel("中文名");
		jl3=new JLabel("外文名");
		jl4=new JLabel("电影类型");
		jl5=new JLabel("电影时长");
		jl6=new JLabel("国家");
		jl7=new JLabel("上映时间");
		jl8=new JLabel("电影简介");
		jl9=new JLabel("海报地址");
		
		try {
			String url;
			String sql = "select Movie_ID,Movie_ChineseName,Movie_EnglishName,Movie_Type,Movie_Duration,Movie_Country,Movie_BeginDate,Movie_Info,Movie_Poster from Table_Movie where Movie_ChineseName=?";
			String[] paras= {(String)mm.getValueAt(rowNum, 0)};
			SqlHelper sh = new SqlHelper();
			ResultSet rs = sh.queryExectue(sql, paras);
			rs.next();
			
			jtf1=new JTextField();
			jtf1.setText(rs.getInt(1)+"");
			jtf1.setEditable(false);
			jtf2=new JTextField();
			jtf2.setText(rs.getString(2).trim());
			jtf3=new JTextField();
			jtf3.setText(rs.getString(3).trim());
			jtf4=new JTextField();
			jtf4.setText(rs.getString(4).trim());
			jtf5=new JTextField();
			jtf5.setText(rs.getInt(5)+"");
			jtf6=new JTextField();
			jtf6.setText(rs.getString(6).trim());
			jtf7=new JTextField();
			jtf7.setText(rs.getDate(7)+"");
			jtf8=new JTextField();
			jtf8.setText(rs.getString(8).trim());
			jtf9=new JTextField();
			jtf9.setText(rs.getString(9).trim());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		jb1=new JButton("修改");
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(9,1));
		jp2.setLayout(new GridLayout(9,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		jp1.add(jl9);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		jp2.add(jtf9);
		
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		this.setSize(300,280);
		this.setVisible(true);
	}
	
	public updateMovieDialog(Yingpian yingpian, String title, boolean modal, MovieModel mm, int rowNum) {
		// TODO Auto-generated constructor stub
//		super(owner,title,modal);
		jl1=new JLabel("电影ID");
		jl2=new JLabel("中文名");
		jl3=new JLabel("外文名");
		jl4=new JLabel("电影类型");
		jl5=new JLabel("电影时长");
		jl6=new JLabel("国家");
		jl7=new JLabel("上映时间");
		jl8=new JLabel("电影简介");
		jl9=new JLabel("海报地址");
		
		try {
			String url;
			String sql = "select Movie_ID,Movie_ChineseName,Movie_EnglishName,Movie_Type,Movie_Duration,Movie_Country,Movie_BeginDate,Movie_Info,Movie_Poster from Table_Movie where Movie_ChineseName=?";
			String[] paras= {(String)mm.getValueAt(rowNum, 0)};
			SqlHelper sh = new SqlHelper();
			ResultSet rs = sh.queryExectue(sql, paras);
			rs.next();
			
			jtf1=new JTextField();
			jtf1.setText(rs.getInt(1)+"");
			jtf1.setEditable(false);
			jtf2=new JTextField();
			jtf2.setText(rs.getString(2).trim());
			jtf3=new JTextField();
			jtf3.setText(rs.getString(3).trim());
			jtf4=new JTextField();
			jtf4.setText(rs.getString(4).trim());
			jtf5=new JTextField();
			jtf5.setText(rs.getInt(5)+"");
			jtf6=new JTextField();
			jtf6.setText(rs.getString(6).trim());
			jtf7=new JTextField();
			jtf7.setText(rs.getDate(7)+"");
			jtf8=new JTextField();
			jtf8.setText(rs.getString(8).trim());
			jtf9=new JTextField();
			jtf9.setText(rs.getString(9).trim());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		jb1=new JButton("修改");
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(9,1));
		jp2.setLayout(new GridLayout(9,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		jp1.add(jl9);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		jp2.add(jtf9);
		
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		this.setSize(300,280);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			String sql = "UPDATE Table_Movie SET Movie_ChineseName=?,Movie_EnglishName=?,Movie_Type=?,Movie_Duration=?,Movie_Country=?,Movie_BeginDate=?,Movie_Info=?,Movie_Poster=? " + 
					"WHERE Movie_ID=?";
			String[] paras= {jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf8.getText(),jtf9.getText(),jtf1.getText()};
			SqlHelper sh = new SqlHelper();
			boolean i=sh.update(sql, paras);
			this.dispose();
		}
		if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
}
