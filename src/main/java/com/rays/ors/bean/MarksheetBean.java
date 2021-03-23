package com.rays.ors.bean;

/**
 * Marksheet JavaBean encapsulates Marksheet attributes.
 *
 * @author Prateek
 */
public class MarksheetBean extends BaseBean {
	/**
	 * Roll-No of Student
	 */
	private String rollNo;
	/**
	 * ID of Student
	 */
	private long studentId;
	/**
	 * Name of Student
	 */
	private String name;
	/**
	 * Physics marks of Student
	 */
	private Integer physics;
	/**
	 * Chemistry marks of Student
	 */
	private Integer chemistry;
	/**
	 * Mathematics marks of Student
	 */
	private Integer maths;

	/**
	 * accessor.
	 *
	 * @return the roll no
	 */

	public String getRollNo() {
		return rollNo;
	}

	/**
	 * Sets the roll no.
	 *
	 * @param rollNo the new roll no
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the physics.
	 *
	 * @return the physics
	 */
	public Integer getPhysics() {
		return physics;
	}

	/**
	 * Sets the physics.
	 *
	 * @param physics the new physics
	 */
	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	/**
	 * Gets the chemistry.
	 *
	 * @return the chemistry
	 */
	public Integer getChemistry() {
		return chemistry;
	}

	/**
	 * Sets the chemistry.
	 *
	 * @param chemistry the new chemistry
	 */
	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * Gets the maths.
	 *
	 * @return the maths
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * Sets the maths.
	 *
	 * @param maths the new maths
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/**
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.bean.DropdownListBean#getKey()
	 */
	public String getKey() {
		return id + "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.bean.DropdownListBean#getValue()
	 */
	public String getValue() {
		return rollNo;
	}

}