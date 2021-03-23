package com.rays.ors.bean;

import java.util.Date;

/**
 * Faculty JavaBean encapsulates Faculty attributes.
 *
 * @author Prateek
 *
 */
public class FacultyBean extends BaseBean {
	/* First name of faculty */
	private String fname;
	/* Last name of faculty */
	private String lname;
	/* Gender of faculty */
	private String gender;
	/* Login Id of faculty */
	private String emailId;
	/* Mobile no of Faculty */
	private String mobileNo;
	/* College Id of faculty */
	private long collegeId;
	/* College Name of faculty */
	private String collegeName;
	/* Course Id of faculty */
	private long courseId;
	/* Course name of faculty */
	private String courseName;
	/* DOB of faculty */
	private Date dob;
	/* Subject Id of faculty */
	private long subjectId;
	/* Subject name of faculty */
	private String subjectName;

	/*
	 * Getter-Setter of Faculty
	 */

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return fname + " " + lname;
	}

}
