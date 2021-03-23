package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.TimeTableBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DatabaseException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.model.TimeTableModel;

//TODO: Auto-generated Javadoc
/**
 * The Class TimeTableModelTest.
 */
public class TimeTableModelTest {

	/** The model. */
	public static TimeTableModel model = new TimeTableModel();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws DatabaseException :the database exception
	 */
	public static void main(String[] args) throws ParseException, DatabaseException {
		testAdd();
		// testDelete();
		// testFindByPK();
		// testFindByEmailId();
		// testSearch();
		// testList();
		// testUpdate();

	}

	/**
	 * Test add.
	 *
	 * @throws ParseException the parse exception
	 * @throws DatabaseException : the database exception
	 */
	public static void testAdd() throws ParseException, DatabaseException {
		try {
			TimeTableBean bean = new TimeTableBean();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			bean.setId(2L);
			bean.setCourseId(4L);
			bean.setCourseName("M.Sc.");
			bean.setSubjectId(3L);
			bean.setSubjectName("Operating System");
			bean.setSemester("2nd");
			bean.setExamDate(sdf.parse("6/12/2020"));
			bean.setExamTime("10:00 AM to 01:00 PM");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			long pk = model.add(bean);

			TimeTableBean addedbean = model.findByPk(pk);
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test find by PK.
	 */
	public static void testFindByPK() {
		try {
			TimeTableBean bean = new TimeTableBean();
			long pk = 11;
			bean = model.findByPk(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getExamTime());
			System.out.println(bean.getSemester());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getExamDate());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test search.
	 */
	public static void testSearch() {

		try {
			TimeTableBean bean = new TimeTableBean();
			List list = new ArrayList();
			bean.setSubjectName("Human Resource Management");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (TimeTableBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getExamTime());
				System.out.println(bean.getSemester());
				System.out.println(bean.getSubjectId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getExamDate());
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
	 * Test list.
	 */
	public static void testList() {

		try {
			TimeTableBean bean = new TimeTableBean();
			List list = new ArrayList();
			list = model.list(1, 12);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (TimeTableBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getExamTime());
				System.out.println(bean.getSemester());
				System.out.println(bean.getSubjectId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getExamDate());
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
	 * Test update.
	 * @throws DatabaseException :the database exception
	 */
	public static void testUpdate() throws DatabaseException {

		try {
			TimeTableBean bean = model.findByPk(2L);
			bean.setSubjectId(3L);
			// bean.setSubjectName("Material Technology");
			model.update(bean);

			TimeTableBean updatedbean = model.findByPk(2L);
			/*
			 * if (!"Material Technology".equals(updatedbean.getSubjectName())) {
			 * System.out.println("Test Update fail"); }else{
			 * System.out.println("Test Update Successfully"); }
			 */
			System.out.println("-------------------------------");
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test delete.
	 */
	public static void testDelete() {

		try {
			TimeTableBean bean = new TimeTableBean();
			long pk = 20L;
			bean.setId(pk);
			model.delete(bean);
			System.out.println("Test Delete successfully");

			TimeTableBean deletedBean = model.findByPk(pk);
			if (deletedBean != null) {

				System.out.println("Test Delete fail");

			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
