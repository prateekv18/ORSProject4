package com.rays.ors.bean;
/**
 * Subject JavaBean encapsulates Subject attributes.
 *
 * @author Prateek
*/
public class SubjectBean extends BaseBean {

	/* Name of Subject */
	private String subjectName;
	/* Description of Subject */
	private String description;
	/* Course Id of Subject */
	private long CourseId;
	/* Course name of Subject */
	private String CourseName;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCourseId() {
		return CourseId;
	}

	public void setCourseId(long courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getKey() {
		return id + " ";
	}

	public String getValue() {
		return subjectName;
	}
}
