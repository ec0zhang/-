package com.view;

import com.dao.SqlHelper;
import com.service.MovieModel;
import com.service.SeatModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class updateSeatDialog extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9;
	JPanel jp1,jp2,jp3;
	public updateSeatDialog(Zuowei zuowei,String title, boolean modal,SeatModel sm,int rowNum)
	{
		jl1=new JLabel("座位ID");
		jl2=new JLabel("地点");
		jl3=new JLabel("放映厅");
		jl4=new JLabel("行");
		jl5=new JLabel("列");
		jl6=new JLabel("是否可用");
		
		try {
			String url;
			String sql = "select Seat_ID,Seat_Location,Seat_Hall,Seat_Row,Seat_Column,Seat_Useable from Table_Seat where Seat_ID=?";
			String[] paras= {sm.getValueAt(rowNum, 0).toString()};
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
			jtf4.setText(rs.getInt(4)+"");
			jtf5=new JTextField();
			jtf5.setText(rs.getInt(5)+"");
			jtf6=new JTextField();
			jtf6.setText(rs.getInt(6)+"");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		jb1=new JButton("修改");
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
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
	
	public updateSeatDialog(Zuowei zuowei, String title, boolean modal, MovieModel mm, int rowNum) {
		// TODO Auto-generated constructor stub
//		super(owner,title,modal);
		jl1=new JLabel("座位ID");
		jl2=new JLabel("地点");
		jl3=new JLabel("放映厅");
		jl4=new JLabel("行");
		jl5=new JLabel("列");
		jl6=new JLabel("是否可用");
		
		try {
			String url;
			String sql = "select Seat_ID,Seat_Location,Seat_Hall,Seat_Row,Seat_Column,Seat_Useable from Table_Seat where Seat_ID=?";
			String[] paras= {mm.getValueAt(rowNum, 0).toString()};
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
			jtf4.setText(rs.getInt(4)+"");
			jtf5=new JTextField();
			jtf5.setText(rs.getInt(5)+"");
			jtf6=new JTextField();
			jtf6.setText(rs.getInt(6)+"");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		jb1=new JButton("修改");
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
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
			String sql = "UPDATE Table_Seat SET Seat_Location=?,Seat_Hall=?,Seat_Row=?,Seat_Column=?,Seat_Useable=? " + 
					"WHERE Seat_ID=?";
			String[] paras= {jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
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