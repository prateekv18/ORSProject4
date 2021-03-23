package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.CourseBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DatabaseException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.model.CourseModel;

public class CourseModelTest {

	public static CourseModel cm = new CourseModel();

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, DatabaseException {
		// testAdd();
		// testDelete();
		// testUpdate();
		// testFindByName();
		testFindByPk();
		// testSearch();
		// testList();
	}

	public static void testAdd() throws ApplicationException, DuplicateRecordException, DatabaseException {
		CourseBean cb = null;

		try {

			cb = new CourseBean();
			cb.setId(3L);
			cb.setName("Science");
			cb.setDuration("2 hour");
			cb.setDescription("Physics and Chemistry");
			cb.setCreatedBy("Arun");
			cb.setModifiedBy("Jayesh");
			cb.setCreatedDatetime(new Timestamp(new Date().getTime()));
			cb.setModifiedDatetime(new Timestamp(new Date().getTime()));

			long pk = cm.add(cb);

			System.out.println("Data Inserted");

			/*
			 * CourseBean bn = cm.findByPK(pk); if (bn == null) {
			 * System.out.println("test add fail"); }
			 */

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testDelete() throws ApplicationException, DuplicateRecordException {
		CourseBean cb = null;
		long pk = 0;
		try {
			cb = new CourseBean();

			pk = 4L;
			cb.setId(pk);

			cm.delete(cb);
			System.out.println("Test delete successful");

			/*
			 * CourseBean deletedBean = cm.findByPK(pk); if (deletedBean == null) {
			 * System.out.println("Test delete fail"); }
			 */

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testUpdate() throws ApplicationException, DuplicateRecordException, DatabaseException {
		CourseBean cb = null;
		long pk = 0;
		try {
			cb = new CourseBean();

			cb.setName("Physics");
			cb.setDuration("1 hour");
			cb.setDescription("Force and gravity");
			cb.setCreatedBy("Iyer");
			cb.setModifiedBy("Radha");
			cb.setModifiedDatetime(new Timestamp(new Date().getTime()));
			cb.setId(3L);

			cm.update(cb);
			System.out.println("Table updated successfully");

			// CourseBean updateBean = cm.findByPK(4L);
			// if ("IIT".equals(updateBean.getName())) {
			// System.out.println("Duplicate entry");
			// } else {
			// System.out.println("Data Updated");
			// }

		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException d) {
			d.printStackTrace();
		}
	}

	/**
	 * Test find a College by name
	 * @throws DatabaseException : the database exception
	 */
	public static void testFindByName() throws DatabaseException {
		try {
			CourseBean cb = cm.findByName("Maths");
			if (cb == null) {
				System.out.println("Test find by name fail");
			}
			System.out.println(
					"ID\tNAME\tDURATION\tDESCRIPTION\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");

			System.out.print(cb.getId() + "\t");
			System.out.print(cb.getName() + "\t");
			System.out.print(cb.getDuration() + "\t");
			System.out.print(cb.getDescription() + "\t");
			System.out.print(cb.getCreatedBy() + "\t\t");
			System.out.print(cb.getModifiedBy() + "\t\t");
			System.out.print(cb.getCreatedDatetime() + "\t");
			System.out.print(cb.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test find a College by pk
	 * @throws DatabaseException : the database exception
	 */
	public static void testFindByPk() throws DatabaseException {
		try {
			CourseBean cb = new CourseBean();
			long pk = 1L;

			cb = cm.findByPK(pk);
			
			if (cb == null) {
				System.out.println("Test find by pk failed");
			}
		//	System.out.println(	"ID\tNAME\tADDRESS\tDURATION\tDESCRIPTION\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");

			System.out.print(cb.getId() + "\t");
			System.out.print(cb.getName() + "\t");
			System.out.print(cb.getDuration() + "\t");
			System.out.print(cb.getDescription() + "\t");
			System.out.print(cb.getCreatedBy() + "\t\t");
			System.out.print(cb.getModifiedBy() + "\t\t");
			System.out.print(cb.getCreatedDatetime() + "\t");
			System.out.print(cb.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests search a College by Name
	 * @throws DatabaseException :the database exception
	 */

	public static void testSearch() throws DatabaseException {
		try {
			CourseBean cb = new CourseBean();
			List list = new ArrayList();
			cb.setName("Physics");
			list = cm.search(cb, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			System.out.println(
					"ID\tNAME\tADDRESS\tDURATION\tDESCRIPTION\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");
			Iterator it = list.iterator();
			while (it.hasNext()) {
				cb = (CourseBean) it.next();
				System.out.print(cb.getId() + "\t");
				System.out.print(cb.getName() + "\t");
				System.out.print(cb.getDuration() + "\t");
				System.out.print(cb.getDescription() + "\t");
				System.out.print(cb.getCreatedBy() + "\t\t");
				System.out.print(cb.getModifiedBy() + "\t\t");
				System.out.print(cb.getCreatedDatetime() + "\t");
				System.out.print(cb.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get List a College.
	 * @throws DatabaseException : the database exception
	 */
	public static void testList() throws DatabaseException {

		try {
			CourseBean cb = new CourseBean();
			List list = new ArrayList();
			list = cm.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			System.out.println(
					"ID\tNAME\tDURATION\tDESCRIPTION\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");
			Iterator it = list.iterator();
			while (it.hasNext()) {
				cb = (CourseBean) it.next();
				System.out.print(cb.getId() + "\t");
				System.out.print(cb.getName() + "\t");
				System.out.print(cb.getDuration() + "\t");
				System.out.print(cb.getDescription() + "\t");
				System.out.print(cb.getCreatedBy() + "\t\t");
				System.out.print(cb.getModifiedBy() + "\t\t");
				System.out.print(cb.getCreatedDatetime() + "\t");
				System.out.print(cb.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}