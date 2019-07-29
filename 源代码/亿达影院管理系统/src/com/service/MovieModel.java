package com.service;

import java.util.Vector;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import com.dao.SqlHelper;

public class MovieModel extends AbstractTableModel {

	// rowData�������������
	// columnNames�������
	Vector rowData, columnNames;

	// �������ݿ���Ҫ����
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;

	public void init(String sql)
	{
		if(sql.equals(""))
		{
			sql="select Movie_ChineseName,Movie_Type,Movie_Duration,Movie_BeginDate from Table_Movie";
		}
		
		columnNames = new Vector();
		//����������
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("ʱ��");
		columnNames.add("��ӳʱ��");
		
		rowData = new Vector();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//�õ�����
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=�ڴ�ӰԺ","test","a314159265357");
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Vector hang = new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getInt(3));
				hang.add(rs.getDate(4));
				
				rowData.add(hang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				//�ر���Դ
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
	public MovieModel(String sql)
	{
		this.init(sql);
	}
	//��һ�����캯��,���ڳ�ʼ������ģ��
	public MovieModel()
	{
		this.init("");
	}
	
	public void addMovie(String sql,String[] paras)
	{
		//�����û������sql���������
		SqlHelper sh =new SqlHelper();
		sh.update(sql, paras);
	}
	
	public void deleteMovie(String sql,String[] paras)
	{
		//�����û������sql���������
		SqlHelper sh =new SqlHelper();
		sh.update(sql, paras);
	}
	
	// �õ����ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	// �õ����ж�����
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

	// �õ�ĳ��ĳ�е�����
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

}
