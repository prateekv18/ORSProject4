package com.rays.ors.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User JavaBean encapsulates User attributes
 *
 * @author Prateek
 *
 */

public class UserBean extends BaseBean {

	/**
	 * Lock Active constant for User
	 */
	public static final String ACTIVE = "Active";
	/**
	 * Lock Inactive constant for User
	 */
	public static final String INACTIVE = "Inactive";
	/**
	 * First Name of User
	 */
	private String firstName;
	/**
	 * Last Name of User
	 */
	private String lastName;
	/**
	 * Login of User
	 */
	private String login;
	/**
	 * Password of User
	 */
	private String password;
	/**
	 * Confirm Password of User
	 */
	private String confirmPassword;
	/**
	 * Date of Birth of User
	 */
	private Date dob;
	/**
	 * MobielNo of User
	 */
	private String mobileNo;
	/**
	 * Role of User
	 */
	private long roleId;
	/**
	 * Number of unsuccessful login attempt
	 */
	private int unSuccessfulLogin;
	/**
	 * Gender of User
	 */
	private String gender;
	/**
	 * Last login timestamp
	 */
	private Timestamp lastLogin;
	/**
	 * User Lock
	 */
	private String lock = INACTIVE;
	/**
	 * IP Address of User from where User was registred.
	 */
	private String registeredIP;
	/**
	 * IP Address of User of his last login
	 */
	private String lastLoginIP;

	/**
     * accessor.
     *
     * @return the mobile no
     */

    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the mobile no.
     *
     * @param mobileNo the new mobile no
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Gets the confirm password.
     *
     * @return the confirm password
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Sets the confirm password.
     *
     * @param confirmPassword the new confirm password
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Gets the lock.
     *
     * @return the lock
     */
    public String getLock() {
        return lock;
    }

    /**
     * Sets the lock.
     *
     * @param lock the new lock
     */
    public void setLock(String lock) {
        this.lock = lock;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login.
     *
     * @param login the new login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the dob.
     *
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the dob.
     *
     * @param dob the new dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the un successful login.
     *
     * @return the un successful login
     */
    public int getUnSuccessfulLogin() {
        return unSuccessfulLogin;
    }

    /**
     * Sets the un successful login.
     *
     * @param unSuccessfulLogin the new un successful login
     */
    public void setUnSuccessfulLogin(int unSuccessfulLogin) {
        this.unSuccessfulLogin = unSuccessfulLogin;
    }

    /**
     * Gets the registered IP.
     *
     * @return the registered IP
     */
    public String getRegisteredIP() {
        return registeredIP;
    }

    /**
     * Sets the registered IP.
     *
     * @param registeredIP the new registered IP
     */
    public void setRegisteredIP(String registeredIP) {
        this.registeredIP = registeredIP;
    }

    /**
     * Gets the last login IP.
     *
     * @return the last login IP
     */
    public String getLastLoginIP() {
        return lastLoginIP;
    }

    /**
     * Sets the last login IP.
     *
     * @param lastLoginIP the new last login IP
     */
    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the last login.
     *
     * @return the last login
     */
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    /**
     * Sets the last login.
     *
     * @param lastLogin the new last login
     */
    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

   
    /* (non-Javadoc)
     * @see in.co.rays.ors.bean.DropdownListBean#getKey()
     */
    public String getKey() {
        return login;
    }

   
    /* (non-Javadoc)
     * @see in.co.rays.ors.bean.DropdownListBean#getValue()
     */
    public String getValue() {
        return login;
    }

}
