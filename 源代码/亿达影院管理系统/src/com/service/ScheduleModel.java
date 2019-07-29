package com.service;

import java.util.Vector;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ScheduleModel extends AbstractTableModel {

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
			sql="select MonSchedule_Movie,MonSchedule_Hall,MonSchedule_BeginTime,MonSchedule_EndTime,MonSchedule_Price from Table_MonSchedule";
		}
		
		columnNames = new Vector();
		//����������
		columnNames.add("��Ӱ");
		columnNames.add("Ӱ��");
		columnNames.add("��ʼʱ��");
		columnNames.add("����ʱ��");
		columnNames.add("�۸�");
		
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
	
	//��һ�����캯��,���ڳ�ʼ������ģ��
	public ScheduleModel()
	{
		this.init("");
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