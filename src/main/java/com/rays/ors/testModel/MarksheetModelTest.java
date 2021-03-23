package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.MarksheetBean;
import com.rays.ors.bean.StudentBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DatabaseException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.model.MarksheetModel;

/**
 * Marksheet Model Test classes
 */
public class MarksheetModelTest {

	/**
	 * Model object to test
	 */

	public static MarksheetModel model = new MarksheetModel();

	/**
	 * Main method to call test methods.
	 */
	public static void main(String[] args) {
		//testAdd();
		// testDelete();
		// testUpdate();
		// testFindByRollNo();
		// testFindByPK();
		// testSearch();
		// testMeritList();
		// testList();

	}

	/**
	 * Tests add a Marksheet
	 * @throws DatabaseException : the database exception
	 */
	public static void testAdd() throws DatabaseException {

		try {
			MarksheetBean bean = new MarksheetBean();
			bean.setId(3L);
			bean.setRollNo("3A");
			bean.setPhysics(48);
			bean.setChemistry(37);
			bean.setMaths(39);
			bean.setStudentId(1L);
			bean.setName("Karan" + " " + "G");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			long pk = model.add(bean);
			System.out.println("Added successfully");
			/*
			 * MarksheetBean addedbean = model.findByPK(pk); if (addedbean == null) {
			 * System.out.println("Test add fail"); }
			 */
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a Marksheet
	 */
	public static void testDelete() {

		try {
			MarksheetBean bean = new MarksheetBean();
			long pk = 3L;
			bean.setId(pk);
			model.delete(bean);
			System.out.println("Entry deleted");
			/*
			 * MarksheetBean deletedbean = model.findByPK(pk); if (deletedbean != null) {
			 * System.out.println("Test Delete fail"); }
			 */
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests update a Marksheet
	 * @throws DatabaseException : the database exception
	 */
	public static void testUpdate() throws DatabaseException {
		MarksheetBean bean = null;
		try {
			bean = new MarksheetBean();
			// MarksheetBean bean = model.findByPK(3);
			bean.setId(2L);
			bean.setStudentId(2L);
			bean.setRollNo("2");
			bean.setName("Amar" + " " + "Bhora");
			bean.setPhysics(35);
			bean.setChemistry(45);
			bean.setMaths(46);
			bean.setCreatedBy("Naman");
			bean.setModifiedBy("Sanjay");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			model.update(bean);
			System.out.println("Updated successfully");
			/*
			 * MarksheetBean updatedbean = model.findByPK(3L);
			 * System.out.println("Test Update succ"); if
			 * (!"IIM".equals(updatedbean.getName())) {
			 * System.out.println("Test Update fail"); }
			 */
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a marksheet by Roll No.
	 */

	public static void testFindByRollNo() {
		try {
			MarksheetBean bean = model.findByRollNo("1");
			if (bean == null) {
				System.out.println("Test Find By RollNo fail");
			}
			System.out.print(bean.getId() + "\t");
			System.out.print(bean.getRollNo() + "\t");
			System.out.print(bean.getStudentId() + "\t");
			System.out.print(bean.getName() + "\t");
			System.out.print(bean.getPhysics() + "\t");
			System.out.print(bean.getChemistry() + "\t");
			System.out.print(bean.getMaths() + "\t");
			System.out.print(bean.getCreatedBy() + "\t");
			System.out.print(bean.getModifiedBy() + "\t");
			System.out.print(bean.getCreatedDatetime() + "\t");
			System.out.print(bean.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a marksheet by PK.
	 */
	public static void testFindByPK() {
		try {
			MarksheetBean bean = new MarksheetBean();
			long pk = 1L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getStudentId());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests search a Marksheets
	 */

	public static void testSearch() {
		try {
			MarksheetBean bean = new MarksheetBean();
			List list = new ArrayList();
			bean.setName("Jay" + " " + "Singh");
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (MarksheetBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getRollNo());
				System.out.println(bean.getStudentId());
				System.out.println(bean.getName());
				System.out.println(bean.getPhysics());
				System.out.println(bean.getChemistry());
				System.out.println(bean.getMaths());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get the meritlist of Marksheets
	 */
	public static void testMeritList() {
		try {
			MarksheetBean bean = new MarksheetBean();
			List list = new ArrayList();
			list = model.getMeritList(1, 5);
			if (list.size() < 0) {
				System.out.println("Test List fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (MarksheetBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getRollNo());
				System.out.println(bean.getName());
				System.out.println(bean.getPhysics());
				System.out.println(bean.getChemistry());
				System.out.println(bean.getMaths());
//				System.out.println(bean.getCreatedBy());
//				System.out.println(bean.getModifiedBy());
//				System.out.println(bean.getCreatedDatetime());
//				System.out.println(bean.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests list of Marksheets
	 * @throws DatabaseException the database exception 
	 */
	public static void testList() throws DatabaseException  {
		try {
			MarksheetBean bean = new MarksheetBean();
			List list = new ArrayList();
			list = model.list(1, 6);
			if (list.size() < 0) {
				System.out.println("Test List fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (MarksheetBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getRollNo());
				System.out.println(bean.getName());
				System.out.println(bean.getPhysics());
				System.out.println(bean.getChemistry());
				System.out.println(bean.getMaths());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}
}
