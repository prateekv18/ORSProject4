package com.rays.ors.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.rays.ors.exception.ApplicationException;

/**
 * @author Prateek
 *
 */
public final class JDBCDataSrc { // Make class final

	private static JDBCDataSrc ds; // Self type static variable

	private JDBCDataSrc() {
	} // private constructor

	private ComboPooledDataSource cpds = null;

	/* Create instance of connection pool */
	public static JDBCDataSrc getInstance() {
		if (ds == null) {
			ResourceBundle rb = ResourceBundle.getBundle("com.rays.ors.bundle.system");
			ds = new JDBCDataSrc();
			ds.cpds=new ComboPooledDataSource();
			try {
				ds.cpds.setDriverClass(rb.getString("driver"));
			} catch (Exception e) {
				System.out.println("Error in jdbcDatasrc instance method");
				e.printStackTrace();
			}
			ds.cpds.setJdbcUrl(rb.getString("url"));
			ds.cpds.setUser(rb.getString("username"));
			ds.cpds.setPassword(rb.getString("password"));
			ds.cpds.setInitialPoolSize(new Integer((String) rb.getString("initialPoolSize")));
			ds.cpds.setAcquireIncrement(new Integer((String) rb.getString("acquireIncrement")));
			ds.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxPoolSize")));
			ds.cpds.setMaxIdleTime(DataUtility.getInt(rb.getString("timeout")));
			ds.cpds.setMinPoolSize(new Integer((String) rb.getString("minPoolSize")));

		}
		return ds;
	}

	/* Get Connection from cpds */
	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	/* Close Connection */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}

	public static void trnRollback(Connection cn) throws ApplicationException {
		if (cn != null) {
			try {
				cn.rollback();
			} catch (SQLException ex) {
				throw new ApplicationException(ex.toString());
			}
		}
	}

}