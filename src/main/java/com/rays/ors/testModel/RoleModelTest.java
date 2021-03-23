package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.RoleBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.model.RoleModel;

public class RoleModelTest {
	// Model object to test
	public static RoleModel model = new RoleModel();

	// Main method to carry all tests
	public static void main(String[] args) throws ParseException {
		// testAdd();
		// testDelete();
		// testUpdate();
		// testFindByPK();
		// testFindByName();
		//testSearch();
		 testList();
	}

	// Test add a role
	public static void testAdd() throws ParseException {

		try {
			RoleBean bn = new RoleBean();
			bn.setId(2L);
			bn.setName("Faculty");
			bn.setDescription("Staff");
			bn.setCreatedBy("Admin");
			bn.setModifiedBy("Admin");
			bn.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bn.setModifiedDatetime(new Timestamp(new Date().getTime()));

			 long pk =  model.add(bn);
			/*
			 * RoleBean addBn = model.findByPk(pk); if (addBn == null) {
			 * System.out.println("Test add fail"); }
			 */
		} catch (ApplicationException e) {
			System.out.println("Application Exception in testAdd method");
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			System.out.println("Duplicate record error in testAdd method");
			e.printStackTrace();
		}

	}

	/*
	 * Tests delete a Role
	 */
	public static void testDelete() {

		try {
			RoleBean bean = new RoleBean();
			long pk = 1L;
			bean.setId(pk);
			model.delete(bean);

			RoleBean deletedbean = model.findByPk(pk);
			if (deletedbean != null) {
				System.out.println("Test Delete fail");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests update a Role
	 */
	public static void testUpdate() {

		try {
			RoleBean bn = model.findByPk(1L);
			if (bn == null) {
				System.out.println("id not found");
			} else {

				bn.setName("Student");
				bn.setDescription("aaaa");
				bn.setCreatedBy("k");
				bn.setModifiedBy("r");
				bn.setCreatedDatetime(new Timestamp(new Date().getTime()));
				bn.setModifiedDatetime(new Timestamp(new Date().getTime()));
				bn.setId(2L);

				model.update(bn);
				System.out.println("update success");
				RoleBean updatedbean = model.findByPk(1L);
				if ("e".equals(updatedbean.getName())) {
					System.out.println("Test Update fail");
				}
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests find a User by PK.
	 */
	public static void testFindByPK() {
		try {
			RoleBean bean = new RoleBean();
			long pk = 1L;
			bean = model.findByPk(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a User by Name.
	 */
	public static void testFindByName() {
		try {
			String nme = "gh";
			System.out.println("fff");
			RoleBean bean = model.findByName(nme);
			System.out.println("after find by pk");
			if (bean != null) {
				System.out.println("Id: " + bean.getId());
				System.out.println("Name: " + bean.getName());
				System.out.println("Description: " + bean.getDescription());
				System.out.println("Created By: " + bean.getCreatedBy());
				System.out.println("Modified By: " + bean.getModifiedBy());
				System.out.println("Created Date Time: " + bean.getCreatedDatetime());
				System.out.println("Modified Date Time: " + bean.getModifiedDatetime());

			}
			System.out.println("Test Find By PK fail");

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get Search
	 */
	public static void testSearch() {

		try {
			RoleBean bean = new RoleBean();
			List list = new ArrayList();
			bean.setName("Admin");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			Iterator it = list.iterator();
			//System.out.println("ID\tNAME\tDESCRIPTION\tCREATED BY\tMODIFIED BY\tCREATED DATE TIME\tMODIFIED DATE TIME");
			while (it.hasNext()) {
				bean = (RoleBean) it.next();
				System.out.print(bean.getId() + "\t");
				System.out.print(bean.getName() + "\t");
				System.out.print(bean.getDescription() + "\t\t");
				System.out.print(bean.getCreatedBy() + "\t\t");
				System.out.print(bean.getModifiedBy() + "\t\t");
				System.out.print(bean.getCreatedDatetime() + "\t");
				System.out.print(bean.getModifiedDatetime());

			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests get List.
	 */
	public static void testList() {

		try {
			RoleBean bean = new RoleBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			//System.out.println("ID\tNAME\tDESCRIPTION\tCREATED BY\tMODIFIED BY\tCREATED DATE TIME\tMODIFIED DATE TIME");

			while (it.hasNext()) {
				bean = (RoleBean) it.next();
				System.out.print(bean.getId() + "\t");
				System.out.print(bean.getName() + "\t");
				System.out.print(bean.getDescription() + "\t\t");
				System.out.print(bean.getCreatedBy() + "\t\t");
				System.out.print(bean.getModifiedBy() + "\t\t");
				System.out.print(bean.getCreatedDatetime() + "\t");
				System.out.print(bean.getModifiedDatetime()+"\n");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

}
