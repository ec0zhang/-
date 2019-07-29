package com.service;
//
//import java.util.Vector;
//import java.sql.*;
//
//import javax.swing.*;
//import javax.swing.table.AbstractTableModel;
//
//import com.dao.SqlHelper;
//
//public class EmployeeModel extends AbstractTableModel {
//
//	// rowData用来存放行数据
//	// columnNames存放列名
//	Vector rowData;
//	Vector columnNames;
//
//	SqlHelper sh=null;
//	public boolean updateEmployee(String sql, String[] paras) {
//		sh = new SqlHelper();
//		return sh.update(sql, paras);
//	}
//
//	public String checkEmp(String uid, String p) {
//		/**
//		 * 
//		 */
//		String zhiwei = "";
//		try {
//			String sql = "select Employee_Job from Table_Employee where Employee_Name=? and Employee_Password=?";
//			String paras[] = { uid, p };
//			sh = new SqlHelper();
//			ResultSet rs = sh.queryExectue(sql, paras);
//			if (rs.next()) {
//				// 取出职位
//				zhiwei = rs.getString(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sh.close();
//		}
//
//		return zhiwei;
//	}
//
//	public void query(String sql, String paras[]) {
//		// 初始化列
//		this.columnNames = new Vector();
//		this.columnNames.add("姓名");
//		this.columnNames.add("岗位");
//		this.columnNames.add("电话");
//		
//		try {
//			sh = new SqlHelper();
//			ResultSet rs = sh.queryExectue(sql, paras);
//			while (rs.next()) {
//				Vector hang = new Vector();
//				hang.add(rs.getString(1).trim());
//				hang.add(rs.getString(2).trim());
//				hang.add(rs.getString(3).trim());
//
//				rowData.add(hang);
//			}
//			// 把rs的结果
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			sh.close();
//		}
//	}
//
//	public EmployeeModel() {
//		// TODO Auto-generated constructor stub
//	}
//
//	// 得到共有多少行
//	@Override
//	public int getRowCount() {
//		// TODO Auto-generated method stub
//		return this.rowData.size();
//	}
//
//	// 得到共有多少列
//	@Override
//	public int getColumnCount() {
//		// TODO Auto-generated method stub
//		return this.columnNames.size();
//	}
//
//	@Override
//	public String getColumnName(int column) {
//		// TODO Auto-generated method stub
//		return (String) this.columnNames.get(column);
//	}
//
//	// 得到某行某列的数据
//	@Override
//	public Object getValueAt(int rowIndex, int columnIndex) {
//		// TODO Auto-generated method stub
//		return ((Vector) this.rowData.get(rowIndex)).get(columnIndex);
//	}
//
//}

import java.util.Vector;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class EmployeeModel extends AbstractTableModel {

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
			sql="select Employee_Name,Employee_Job,Employee_Phone from Table_Employee";
		}
		
		columnNames = new Vector();
		//设置列名字
		this.columnNames.add("姓名");
		this.columnNames.add("岗位");
		this.columnNames.add("电话");
		
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
				hang.add(rs.getString(3));
				
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
	public EmployeeModel(String sql)
	{
		this.init(sql);
	}
	//做一个构造函数,用于初始化数据模型
	public EmployeeModel()
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

