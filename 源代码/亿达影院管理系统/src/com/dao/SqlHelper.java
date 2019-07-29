/**
 * 对数据库操作
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {

	// 定义数据库需要东西
	static PreparedStatement ps = null;
	static Connection ct = null;
	static ResultSet rs = null;

	public SqlHelper() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 得到连接
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=亿达影院", "test",
					"a314159265357");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 把增删改合在一起
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

	// 查询数据库的操作
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
			// 关闭资源
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
