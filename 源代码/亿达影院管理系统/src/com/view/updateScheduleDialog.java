package com.view;

import com.dao.SqlHelper;
import com.service.MovieModel;
import com.service.ScheduleModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class updateScheduleDialog extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9;
	JPanel jp1,jp2,jp3;
	public updateScheduleDialog(Jihua jihua,String title, boolean modal,ScheduleModel sm,int rowNum)
	{
		jl1=new JLabel("电影名称");
		jl2=new JLabel("放映厅 ");
		jl3=new JLabel("开始时间");
		jl4=new JLabel("结束时间");
		jl5=new JLabel("价格");
		
		try {
			String url;
			String sql = "select MonSchedule_Movie,MonSchedule_Hall,MonSchedule_BeginTime,MonSchedule_EndTime,MonSchedule_Price from Table_MonSchedule where MonSchedule_Movie=?";
			String[] paras= {(String)sm.getValueAt(rowNum, 0)};
			SqlHelper sh = new SqlHelper();
			ResultSet rs = sh.queryExectue(sql, paras);
			rs.next();
			
			jtf1=new JTextField();
			jtf1.setText(rs.getString(1).trim());
			jtf2=new JTextField();
			jtf2.setText(rs.getString(2).trim());
			jtf3=new JTextField();
			jtf3.setText(rs.getDate(3)+"");
			jtf4=new JTextField();
			jtf4.setText(rs.getDate(4)+"");
			jtf5=new JTextField();
			jtf5.setText(rs.getInt(5)+"");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		jb1=new JButton("修改");
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
		
		this.setSize(300,230);
		this.setVisible(true);
	}
	
	public updateScheduleDialog(Zuowei zuowei, String title, boolean modal, ScheduleModel sm, int rowNum) {
		// TODO Auto-generated constructor stub
//		super(owner,title,modal);
		jl1=new JLabel("电影名称");
		jl2=new JLabel("放映厅 ");
		jl3=new JLabel("开始时间");
		jl4=new JLabel("结束时间");
		jl5=new JLabel("价格");
		
		try {
			String url;
			String sql = "select MonSchedule_Movie,MonSchedule_Hall,MonSchedule_BeginTime,MonSchedule_EndTime,MonSchedule_Price from Table_MonSchedule where MonSchedule_Movie=?";
			String[] paras= {(String)sm.getValueAt(rowNum, 0)};
			SqlHelper sh = new SqlHelper();
			ResultSet rs = sh.queryExectue(sql, paras);
			rs.next();
			
			jtf1=new JTextField();
			jtf1.setText(rs.getString(1).trim());
			jtf2=new JTextField();
			jtf2.setText(rs.getString(2).trim());
			jtf3=new JTextField();
			jtf3.setText(rs.getDate(3)+"");
			jtf4=new JTextField();
			jtf4.setText(rs.getDate(4)+"");
			jtf5=new JTextField();
			jtf5.setText(rs.getInt(5)+"");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		jb1=new JButton("修改");
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
		
		this.setSize(300,230);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//回去再想想修改按钮
		}
		if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
}
