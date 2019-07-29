package com.view;

import com.dao.SqlHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Zuowei_Xiangxixinxi extends JDialog implements ActionListener {

	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1;
	JPanel jp1, jp2, jp3;

	public Zuowei_Xiangxixinxi(Frame owner, String title, boolean modal, String MovieName) {
		super(owner, title, modal);
		// 查询

		try {
			String url;
			String sql = "select Seat_ID,Seat_Location,Seat_Hall,Seat_Row,Seat_Column,Seat_Useable from Table_Seat where Seat_ID=?";
			String[] paras = { MovieName };
			SqlHelper sh = new SqlHelper();
			ResultSet rs = sh.queryExectue(sql, paras);
			rs.next();
			jl1 = new JLabel(rs.getInt(1) + "");
			jl2 = new JLabel(rs.getString(2).trim());
			jl3 = new JLabel(rs.getString(3).trim());
			jl4 = new JLabel(rs.getInt(4) + "");
			jl5 = new JLabel(rs.getInt(5) + "");
			jl6 = new JLabel(rs.getDate(6) + "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		jb1 = new JButton("确定");

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp2.setLayout(new GridLayout(6, 1));

		jp2.add(jl1);
		jp2.add(jl2);
		jp2.add(jl3);
		jp2.add(jl4);
		jp2.add(jl5);
		jp2.add(jl6);
		jp1.setLayout(new GridLayout(1, 2));

		jp1.add(jp2);

		jp3.setLayout(new BorderLayout());
		jp3.add(jp1, BorderLayout.NORTH);

		this.add(jp3);

//		jb1.addActionListener(this);

		this.setSize(300, 300);
		this.setVisible(true);
	}

	public Zuowei_Xiangxixinxi(Zuowei zuowei, String title, boolean modal, String movieName) {
		// TODO Auto-generated constructor stub
		// 查询

		try {
			String url;
			String sql = "select Seat_ID,Seat_Location,Seat_Hall,Seat_Row,Seat_Column,Seat_Useable from Table_Seat where Seat_ID=?";
			String[] paras = { movieName };
			SqlHelper sh = new SqlHelper();
			ResultSet rs = sh.queryExectue(sql, paras);
			rs.next();
			jl1 = new JLabel(rs.getInt(1) + "");
			jl2 = new JLabel(rs.getString(2).trim());
			jl3 = new JLabel(rs.getString(3).trim());
			jl4 = new JLabel(rs.getInt(4) + "");
			jl5 = new JLabel(rs.getInt(5) + "");
			jl6 = new JLabel(rs.getInt(6) + "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		jb1 = new JButton("确定");

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp2.setLayout(new GridLayout(6, 1));

		jp2.add(jl1);
		jp2.add(jl2);
		jp2.add(jl3);
		jp2.add(jl4);
		jp2.add(jl5);
		jp2.add(jl6);
		jp1.setLayout(new GridLayout(1, 2));

		jp1.add(jp2);

		jp3.setLayout(new BorderLayout());
		jp3.add(jp1, BorderLayout.NORTH);

		this.add(jp3);

//				jb1.addActionListener(this);

		this.setSize(300, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {

			this.dispose();
		}
	}
}
