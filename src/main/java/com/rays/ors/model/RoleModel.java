package com.rays.ors.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rays.ors.bean.RoleBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DatabaseException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.util.JDBCDataSrc;

/**
 * JDBC implementation in role model
 * 
 * @author Prateek
 */

public class RoleModel {

	public static Logger log = Logger.getLogger(RoleModel.class);

	/*
	 * Find next primary key of role
	 */
	public Integer nextPk() throws DatabaseException {
		log.debug("Model nextPk started");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSrc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_ROLE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception", e);
			throw new DatabaseException("Exception: Exception in getting pk");
		} finally {
			JDBCDataSrc.closeConnection(conn);
		}
		log.debug("Model nextPk end");
		return pk + 1;
	}

	/*
	 * Add a role
	 */
	public long add(RoleBean bn) throws ApplicationException, DuplicateRecordException {
		Connection con = null;
		int pk = 0;

		RoleBean duplicaRole = findByName(bn.getName());

		if (duplicaRole != null) {
			throw new DuplicateRecordException("Role Exist");
		}
		try {
			con = JDBCDataSrc.getConnection();
			pk = nextPk();
			System.out.println(pk + " in Model JDBC");

			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement("INSERT INTO ST_ROLE VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bn.getName());
			ps.setString(3, bn.getDescription());
			ps.setString(4, bn.getCreatedBy());
			ps.setString(5, bn.getModifiedBy());
			ps.setTimestamp(6, bn.getCreatedDatetime());
			ps.setTimestamp(7, bn.getModifiedDatetime());

			ps.executeUpdate();
			con.commit();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception...", e);

			try {
				con.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception: add rollback exception" + ex.getMessage());
			}
			throw new ApplicationException("Exception: Exception in add role");

		} finally {
			JDBCDataSrc.closeConnection(con);
		}
		return pk;
	}

	/*
	 * Delete Role
	 */

	public void delete(RoleBean bn) throws ApplicationException {
		Connection con = null;
		try {
			con = JDBCDataSrc.getConnection();

			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement("DELETE FROM ST_ROLE WHERE ID=?");
			ps.setLong(1, bn.getId());

			ps.executeUpdate();

			con.commit();
			ps.close();
			System.out.println("Deleted");
		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception: Delete Rollback Exception" + ex.getMessage());
			}

			throw new ApplicationException("Exception: Exceptionn in delete role");
		} finally {
			JDBCDataSrc.closeConnection(con);
		}
	}

	/*
	 * Find user by role
	 */
	public RoleBean findByName(String name) throws ApplicationException {
		log.debug("Model findBy EmailId Started");
		System.out.println("start");
		RoleBean bn = null;
		Connection con = null;
		try {
			con = JDBCDataSrc.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM ST_ROLE WHERE NAME=?");
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bn = new RoleBean();
				bn.setId(rs.getLong(1));
				bn.setName(rs.getString(2));
				bn.setDescription(rs.getString(3));
				bn.setCreatedBy(rs.getString(4));
				bn.setModifiedBy(rs.getString(5));
				bn.setCreatedDatetime(rs.getTimestamp(6));
				bn.setModifiedDatetime(rs.getTimestamp(7));
				System.out.println("success");
			}
			rs.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception:Exception in getting User");
		} finally {
			JDBCDataSrc.closeConnection(con);
		}
		System.out.println("end");
		return bn;

	}

	/*
	 * Find Role by PK
	 */

	public RoleBean findByPk(long pk) throws ApplicationException {
		StringBuffer sb = new StringBuffer("SELECT * FROM ST_ROLE WHERE ID=?");
		RoleBean bn = null;
		Connection con = null;
		try {
			con = JDBCDataSrc.getConnection();
			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bn = new RoleBean();
				bn.setId(rs.getLong(1));
				bn.setName(rs.getString(2));
				bn.setDescription(rs.getString(3));
				bn.setCreatedBy(rs.getString(4));
				bn.setModifiedBy(rs.getString(5));
				bn.setCreatedDatetime(rs.getTimestamp(6));
				bn.setModifiedDatetime(rs.getTimestamp(7));

			}
			rs.close();

		} catch (Exception e) {
			throw new ApplicationException("Exception: Exception of getting user by pk");
		} finally {
			JDBCDataSrc.closeConnection(con);
		}

		return bn;
	}

	/*
	 * Update a Role
	 */

	public void update(RoleBean bn) throws ApplicationException, DuplicateRecordException {
		Connection con = null;

		RoleBean rb = findByName(bn.getName());
		if (rb != null && rb.getId() != bn.getId()) {
			throw new DuplicateRecordException("Role already exist");
		}
		try {
			con = JDBCDataSrc.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ST_ROLE SET NAME=?, DESCRIPTION=?, CREATEDBY=?, MODIFIEDBY=?,CREATEDDATETIME=?, MODIFIEDDATETIME=? WHERE ID=?");

			ps.setString(1, bn.getName());
			ps.setString(2, bn.getDescription());
			ps.setString(3, bn.getCreatedBy());
			ps.setString(4, bn.getModifiedBy());
			ps.setTimestamp(5, bn.getCreatedDatetime());
			ps.setTimestamp(6, bn.getModifiedDatetime());
			ps.setLong(7, bn.getId());

			ps.executeUpdate();
			con.commit();
			ps.close();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception in updating role");
			}
		} finally {
			JDBCDataSrc.closeConnection(con);
		}

	}

	/*
	 * Search a Role
	 */
	public List search(RoleBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	/*
	 * Search Role with pagination
	 */
	public List search(RoleBean bn, int pgNo, int pgSz) throws ApplicationException {
		StringBuffer sb = new StringBuffer("SELECT * FROM ST_ROLE WHERE 1=1");
		if (bn != null) {
			if (bn.getId() > 0) {
				sb.append(" AND ID = " + bn.getId());
			}
			if (bn.getName() != null && bn.getName().length() > 0) {
				sb.append(" AND NAME like'" + bn.getName() + "%'");
			}
			if (bn.getDescription() != null && bn.getDescription().length() > 0) {
				sb.append(" AND DESCRIPTION like '" + bn.getDescription() + "%'");
			}
		}
		// if page size is greater than zero then apply pagination
		if (pgSz > 0) {
			pgNo = (pgNo - 1) * pgSz;
			sb.append(" Limit " + pgNo + "," + pgSz);
			// sb.append("limit"+pgNo+","+pgSz);
		}

		ArrayList al = new ArrayList();
		Connection con = null;

		try {
			con = JDBCDataSrc.getConnection();

			PreparedStatement ps = con.prepareStatement(sb.toString());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bn = new RoleBean();
				bn.setId(rs.getLong(1));
				bn.setName(rs.getString(2));
				bn.setDescription(rs.getString(3));
				bn.setCreatedBy(rs.getString(4));
				bn.setModifiedBy(rs.getString(5));
				bn.setCreatedDatetime(rs.getTimestamp(6));
				bn.setModifiedDatetime(rs.getTimestamp(7));
				al.add(bn);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception: Exception in search role");
		} finally {
			JDBCDataSrc.closeConnection(con);
		}
		return al;
	}

	/*
	 * Get List of Role
	 */
	public List list() throws ApplicationException {
		return list(0, 0);
	}

	/*
	 * Get List of Role with pagination
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
		// log.debug("Model list Started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from ST_ROLE");
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		Connection conn = null;

		try {
			conn = JDBCDataSrc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RoleBean bean = new RoleBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			 log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting list of Role");
		} finally {
			JDBCDataSrc.closeConnection(conn);
		}

		 log.debug("Model list End");
		return list;

	}
}
