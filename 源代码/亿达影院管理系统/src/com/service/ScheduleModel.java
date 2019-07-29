package com.service;

import java.util.Vector;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ScheduleModel extends AbstractTableModel {

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
			sql="select MonSchedule_Movie,MonSchedule_Hall,MonSchedule_BeginTime,MonSchedule_EndTime,MonSchedule_Price from Table_MonSchedule";
		}
		
		columnNames = new Vector();
		//设置列名字
		columnNames.add("电影");
		columnNames.add("影厅");
		columnNames.add("开始时间");
		columnNames.add("结束时间");
		columnNames.add("价格");
		
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
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getTimestamp(3));
				hang.add(rs.getTimestamp(4));
				hang.add(rs.getInt(5));
				
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
	
	//做一个构造函数,用于初始化数据模型
	public ScheduleModel()
	{
		this.init("");
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