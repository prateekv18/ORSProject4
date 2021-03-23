package com.rays.ors.testModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.ors.bean.UserBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.exception.RecordNotFoundException;
import com.rays.ors.model.UserModel;

// TODO: Auto-generated Javadoc
/**
 * User Model Test classes.
 *
 * @author SunilOS
 * @version 1.0 Copyright (c) SunilOS
 */
public class UserModelTest {

	/** Model object to test. */

	public static UserModel model = new UserModel();

	/**
	 * Main method to call test methods.
	 *
	 * @param args the arguments
	 * @throws ApplicationException     the application exception
	 * @throws DuplicateRecordException the duplicate record exception
	 * @throws ParseException           the parse exception
	 * @throws RecordNotFoundException  the record not found exception
	 */
	public static void main(String[] args)
			throws ApplicationException, DuplicateRecordException, ParseException, RecordNotFoundException {
		// testAdd();
		testUpdate();
		// testFindByPK();
		// testFindByLogin();
		// testSearch();
		// testGetRoles();
		// testlist();
//		testauthenticate();
		// testregisterUser(); //mail
		//testchangePassword();// mail
		// testforgetPassword(); // mail
		// testresetPassword(); mail

	}

	/**
	 * Test add.
	 *
	 * @throws ParseException           the parse exception
	 * @throws DuplicateRecordException the duplicate record exception
	 * @throws RecordNotFoundException  the record not found exception
	 */
	public static void testAdd() throws ParseException, DuplicateRecordException, RecordNotFoundException {

		try {
			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyyy");

			// bean.setId(5234L);
			bean.setFirstName("Radhe");
			bean.setLastName("laal");
			bean.setLogin("Radhe@gmail.com");
			bean.setPassword("Radhe@12");
			bean.setDob(sdf.parse("31-12-1980"));
			bean.setRoleId(3);
			bean.setUnSuccessfulLogin(2);
			bean.setGender("male");
			bean.setMobileNo("9988775533");
			bean.setLastLogin(new Timestamp(new Date().getTime()));
			bean.setLock("Yes");
			bean.setConfirmPassword("Radhe@12");
			long pk = model.add(bean);
			UserBean addedbean = model.findByPK(pk);
			System.out.println("Test add succesfuly");
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test update.
	 *
	 * @throws RecordNotFoundException the record not found exception
	 */
	public static void testUpdate() throws RecordNotFoundException {

		try {
			UserBean bean = model.findByPK(1L);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			// bean.setFirstName("Keshav");
			// bean.setLastName("verma");
			// bean.setLogin("shrma@gmail.com");
			// bean.setPassword("vemaji@123");
			bean.setMobileNo("9876544455");
			// bean.setConfirmPassword("vemaji@123");

			model.update(bean);

			UserBean updatedbean = model.findByPK(1L);
			if (!"Keshav@gmail.com".equals(updatedbean.getLogin())) {
				System.out.println("Test Update fail");
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
			UserBean bean = new UserBean();
			long pk = 1;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test find by login.
	 */
	public static void testFindByLogin() {
		try {
			UserBean bean = new UserBean();
			bean = model.findByLogin("sourabhgg@gmail.com");
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test search.
	 */
	public static void testSearch() {

		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			bean.setLogin("abhithakur.at777@gmail.com");
			list = model.search(bean);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfulLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test get roles.
	 *
	 * @throws ApplicationException the application exception
	 */
	public static void testGetRoles() throws ApplicationException {

		UserBean bean = new UserBean();
		List list = new ArrayList();
		bean.setRoleId(3);
		list = model.getRoles(bean);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		}
	}

	/**
	 * Testlist.
	 *
	 * @throws ApplicationException the application exception
	 */
	public static void testlist() throws ApplicationException {
		UserBean bean = new UserBean();
		List list = new ArrayList();
		list = model.list(0, 0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		}
	}

	/**
	 * Test Authenticate.
	 *
	 * @throws ApplicationException the application exception
	 */
	public static void testauthenticate() throws ApplicationException {
		UserBean bean = new UserBean();
		bean.setLogin("k@gmail.com");
		bean.setPassword("12345");
		bean = model.authenticate(bean.getLogin(), bean.getPassword());
		if (bean != null) {
			System.out.println("Successful login");
		} else {
			System.out.println("login id is wrong ");
		}

	}

	public static void testforgetPassword() {
		try {
			boolean b = model.forgetPassword("prateekkumarverma97@gmail.com");

			System.out.println("Suucess : Test Forget Password Success");

		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests change-password
	 *
	 * @throws ParseException :	
	 * 							
	 */
	public static void testchangePassword() throws ParseException {

		try {
			UserBean bean = model.findByLogin("prateekkumarverma97@gmail.com");
			String oldPassword = bean.getPassword();
			bean.setId(12L);
			bean.setPassword("prtk@1234");
			bean.setConfirmPassword("prtk@1234");
			String newPassword = bean.getPassword();
			try {
				model.changePassword(12L, oldPassword, newPassword);
				System.out.println("password has been change successfully");
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

}
