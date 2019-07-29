/**
 * �����ݿ����
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {

	// �������ݿ���Ҫ����
	static PreparedStatement ps = null;
	static Connection ct = null;
	static ResultSet rs = null;

	public SqlHelper() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// �õ�����
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=�ڴ�ӰԺ", "test",
					"a314159265357");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// ����ɾ�ĺ���һ��
	public boolean update(String sql, String[] paras) {
		boolean b = true;
		try {
			ps = ct.prepareStatement(sql);
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}

			if (ps.executeUpdate() != 1) {
				b = false;
			}

		} catch (Exception e) {
			b = false;
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}

		return b;
	}

	// ��ѯ���ݿ�Ĳ���
	public ResultSet queryExectue(String sql, String[] paras) {
		try {
			ps = ct.prepareStatement(sql);
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rs;
	}

	public static void close() {
		try {
			// �ر���Դ
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
