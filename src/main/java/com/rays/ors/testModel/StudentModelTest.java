package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.StudentBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DatabaseException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.model.StudentModel;

public class StudentModelTest {

	/**
	 * Model object to test
	 */

	public static StudentModel model = new StudentModel();

	/**
	 * Main method to call test methods.
	 *
	 * @param args
	 * @throws DatabaseException :the database exception
	 */
	public static void main(String[] args) throws ParseException, DatabaseException {
		// testAdd();
		// testDelete();
		// testUpdate();
		// testFindByPK();
		//testFindByEmailId();
		// testSearch();
		 testList();

	}

	/**
	 * Tests add a Student
	 *
	 * @throws ParseException
	 */
	public static void testAdd() throws ParseException {

		try {
			StudentBean bean = new StudentBean();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			bean.setId(1L);
			bean.setCollegeId(1L);
			bean.setCollegeName("IET");
			bean.setFirstName("Kamal");
			bean.setLastName("Mehra");
			bean.setDob(sdf.parse("12/03/1997"));
			bean.setMobileNo("7878787887");
			bean.setEmail("kamal.mehra12@gmail.com");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			// long pk =
			model.add(bean);
			// StudentBean addedbean = model.findByPK(pk);
			// if (addedbean == null) {
			// System.out.println("Test add fail");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a Student
	 * @throws DatabaseException :the database exception
	 */
	public static void testDelete() throws DatabaseException {

		try {
			StudentBean bean = new StudentBean();
			long pk = 2L;
			bean.setId(pk);
			model.delete(bean);
			System.out.println("Deleted successfully");
			// StudentBean deletedbean = model.findByPK(pk);
			// if (deletedbean != null) {
			// System.out.println("Test Delete fail");
			// }
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests update a Student
	 * 
	 * @throws ParseException
	 */
	public static void testUpdate() throws ParseException {
		StudentBean bean = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// StudentBean bean = model.findByPK(3L);
			bean = new StudentBean();
			bean.setFirstName("ankit");
			bean.setLastName("sharma");
			bean.setDob(sdf.parse("05/06/1980"));
			bean.setMobileNo("5435454353");
			bean.setEmail("sharma.ankit@gmail.com");
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			bean.setId(1L);
			model.update(bean);

			// StudentBean updatedbean = model.findByPK(3L);
			// if (!"rr".equals(updatedbean.getFirstName())) {
			// System.out.println("Test Update fail");
			// }
		} catch (/* Application */Exception e) {
			e.printStackTrace();
		} /*
			 * catch (DuplicateRecordException e) { e.printStackTrace(); }
			 */
	}

	/**
	 * Tests find a Student by PK.
	 */
	public static void testFindByPK() {
		try {
			StudentBean bean = new StudentBean();
			long pk = 1L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		} catch (/* Application */Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a Student by Emailid.
	 * @throws DatabaseException : the database exception
	 */
	public static void testFindByEmailId() throws DatabaseException {
        try {
            StudentBean bean = new StudentBean();
            bean = model.findByEmailId("sharma.ankit@gmail.com");
            if (bean != null) {
                System.out.println("Test Find By EmailId fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLastName());
            System.out.println(bean.getDob());
            System.out.println(bean.getMobileNo());
            System.out.println(bean.getEmail());
            System.out.println(bean.getCollegeId());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }


	/**
	 * Tests get Search
	 * @throws DatabaseException : the database exception
	 */
	public static void testSearch() throws DatabaseException {

		try {
			StudentBean bean = new StudentBean();
			List list = new ArrayList();
			bean.setFirstName("ankit");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (StudentBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getDob());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getEmail());
				System.out.println(bean.getCollegeId());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests get List.
	 * @throws DatabaseException : the database exception
	 */
	public static void testList() throws DatabaseException {

		try {
			StudentBean bean = new StudentBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (StudentBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getDob());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getEmail());
				System.out.println(bean.getCollegeId());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
