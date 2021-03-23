package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.CollegeBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.model.CollegeModel;

public class CollegeModelTest {
	public static CollegeModel cm = new CollegeModel();

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		 //testAdd();
		// testDelete();
		// testUpdate();
		// testFindByName();
		// testFindByPk();
		testSearch();
		//testList();
	}

	/**
	 * Test Add a College
	 */
	public static void testAdd() throws ApplicationException, DuplicateRecordException {
		CollegeBean cb = null;
		try {
			cb = new CollegeBean();

			// cb.setId(2L);
			cb.setName("IIT");
			cb.setAddress("Mumbai");
			cb.setState("MH");
			cb.setCity("Mumbai");
			cb.setPhoneNo("2355768");
			cb.setCreatedBy("ss");
			cb.setModifiedBy("dd");
			cb.setCreatedDatetime(new Timestamp(new Date().getTime()));
			cb.setModifiedDatetime(new Timestamp(new Date().getTime()));

			long pk = cm.add(cb);

			System.out.println("Data added");

			CollegeBean bn = cm.findByPK(pk);
			if (bn == null) {
				System.out.println("test add fail");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test delete of a College
	 */
	public static void testDelete() throws ApplicationException, DuplicateRecordException {

		CollegeBean cb = null;
		long pk = 0;
		try {
			cb = new CollegeBean();

			pk = 2L;
			cb.setId(pk);

			cm.delete(cb);
			System.out.println("Test delete successful");

			CollegeBean deletedBean = cm.findByPK(pk);
			if (deletedBean == null) {
				System.out.println("Test delete fail");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test update of a College
	 */
	public static void testUpdate() throws ApplicationException, DuplicateRecordException {
		CollegeBean cb = null;
		long pk = 0;
		try {
			cb = new CollegeBean();

			cb.setName("IIT");
			cb.setAddress("Chennai");
			cb.setState("TN");
			cb.setCity("Chennai");
			cb.setPhoneNo("1145745");
			cb.setCreatedBy("Iyer");
			cb.setModifiedBy("Radha");
			cb.setCreatedDatetime(new Timestamp(new Date().getTime()));
			cb.setModifiedDatetime(new Timestamp(new Date().getTime()));
			cb.setId(4L);
			cm.update(cb);

			CollegeBean updateBean = cm.findByPK(4L);
			if ("IIT".equals(updateBean.getName())) {
				System.out.println("Duplicate entry");
			} else {
				System.out.println("Data Updated");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException d) {
			d.printStackTrace();
		}
	}

	/**
	 * Test find a College by name
	 */
	public static void testFindByName() {
		try {
			CollegeBean cb = cm.findByName("IIT");
			if (cb == null) {
				System.out.println("Test find by name fail");
			}
			System.out.println(
					"ID\tNAME\tADDRESS\tCITY\tSTATE\tPHONE_NO\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");

			System.out.print(cb.getId() + "\t");
			System.out.print(cb.getName() + "\t");
			System.out.print(cb.getAddress() + "\t");
			System.out.print(cb.getCity() + "\t");
			System.out.print(cb.getState() + "\t");
			System.out.print(cb.getPhoneNo() + "\t\t");
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
	 */
	public static void testFindByPk() {
		try {
			CollegeBean cb = new CollegeBean();
			long pk = 1L;

			cb = cm.findByPK(pk);
			if (cb == null) {
				System.out.println("Test find by pk failed");
			}
			System.out.println(
					"ID\tNAME\tADDRESS\tCITY\tSTATE\tPHONE_NO\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");

			System.out.print(cb.getId() + "\t");
			System.out.print(cb.getName() + "\t");
			System.out.print(cb.getAddress() + "\t");
			System.out.print(cb.getCity() + "\t");
			System.out.print(cb.getState() + "\t");
			System.out.print(cb.getPhoneNo() + "\t\t");
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
	 */

	public static void testSearch() {
		try {
			CollegeBean cb = new CollegeBean();
			List list = new ArrayList();
			cb.setName("GSITS");
			list = cm.search(cb, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			System.out.println(
					"ID\tNAME\tADDRESS\tCITY\tSTATE\tPHONE_NO\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");
			Iterator it = list.iterator();
			while (it.hasNext()) {
				cb = (CollegeBean) it.next();
				System.out.print(cb.getId() + "\t");
				System.out.print(cb.getName() + "\t");
				System.out.print(cb.getAddress() + "\t");
				System.out.print(cb.getCity() + "\t");
				System.out.print(cb.getState() + "\t");
				System.out.print(cb.getPhoneNo() + "\t\t");
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
	 */
	public static void testList() {

		try {
			CollegeBean cb = new CollegeBean();
			List list = new ArrayList();
			list = cm.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			System.out.println(
					"ID\tNAME\tADDRESS\tCITY\tSTATE\tPHONE_NO\tCREATED_BY\tMODIFIED_BY\tCREATED_DATE_TIME\tMODIFIED_DATE_TIME");
			Iterator it = list.iterator();
			while (it.hasNext()) {
				cb = (CollegeBean) it.next();
				System.out.print(cb.getId() + "\t");
				System.out.print(cb.getName() + "\t");
				System.out.print(cb.getAddress() + "\t");
				System.out.print(cb.getCity() + "\t");
				System.out.print(cb.getState() + "\t");
				System.out.print(cb.getPhoneNo() + "\t\t");
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
