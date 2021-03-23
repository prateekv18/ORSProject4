package com.rays.ors.bean;

/**
 * Student JavaBean encapsulates Student attributes.
 *
 * @author Prateek
*/
import java.util.Date;

/**
 * @author Prateek
 *
 */
public class StudentBean extends BaseBean {

	/**
	 * First Name of Student
	 */
	private String firstName;
	/**
	 * Last Name of Student
	 */
	private String lastName;
	/**
	 * Date of Birth of Student
	 */
	private Date dob;
	/**
	 * Mobileno of Student
	 */
	private String mobileNo;
	/**
	 * Email of Student
	 */
	private String email;
	/**
	 * CollegeId of Student
	 */
	private long collegeId;
	/**
	 * College name of Student
	 */
	private String collegeName;

	/**
     * accessor.
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
     * Gets the mobile no.
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
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the college id.
     *
     * @return the college id
     */
    public Long getCollegeId() {
        return collegeId;
    }

    /**
     * Sets the college id.
     *
     * @param collegeId the new college id
     */
    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * Gets the college name.
     *
     * @return the college name
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets the college name.
     *
     * @param collegeName the new college name
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    
    /* (non-Javadoc)
     * @see in.co.rays.ors.bean.DropdownListBean#getKey()
     */
    public String getKey() {
        return id + "";
    }

    
    /* (non-Javadoc)
     * @see in.co.rays.ors.bean.DropdownListBean#getValue()
     */
    public String getValue() {
        return firstName + " " + lastName;
    }

}