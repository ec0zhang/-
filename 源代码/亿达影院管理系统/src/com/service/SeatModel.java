package com.service;


import java.util.Vector;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import com.dao.SqlHelper;

public class SeatModel extends AbstractTableModel {

	// rowData用来存放行数据
	// columnNames存放列名
	Vector rowData, columnNames;

	// 定义数据库需要东西
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;

	public void init(String sql)
	{
		if(sql.equals(""))
		{
			sql="select Seat_ID,Seat_Location,Seat_Hall,Seat_Row,Seat_Column,Seat_Useable from Table_Seat";
		}
		
		columnNames = new Vector();
		//设置列名字
		this.columnNames.add("座位编号");
		this.columnNames.add("地点");
		this.columnNames.add("影厅");
		this.columnNames.add("行");
		this.columnNames.add("列");
		this.columnNames.add("是否可用");
		
		rowData = new Vector();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//得到连接
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=亿达影院","test","a314159265357");
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Vector hang = new Vector();
				hang.add(rs.getInt(1));
				hang.add(rs.getString(2).trim());
				hang.add(rs.getString(3).trim());
				hang.add(rs.getInt(4));
				hang.add(rs.getInt(5));
				hang.add(rs.getInt(6));
				
				rowData.add(hang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				//关闭资源
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (ct != null)
					ct.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	//
	public SeatModel(String sql)
	{
		this.init(sql);
	}
	//做一个构造函数,用于初始化数据模型
	public SeatModel()
	{
		this.init("");
	}
	

	public void updateSeat(String sql,String []paras)
	{
		SqlHelper sh=new SqlHelper();
		sh.update(sql, paras);
	}

	
	// 得到共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	// 得到共有多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

	// 得到某行某列的数据
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

}
