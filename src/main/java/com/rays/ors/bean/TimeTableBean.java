package com.rays.ors.bean;

import java.util.Date;

/**
 * TimeTable JavaBean encapsulates TimeTable attributes.
 * 
 * @author Prateek
 *
 */
public class TimeTableBean extends BaseBean {

	/* Course Id of Timetable */
	private long courseId;
	/* Course name of Timetable */
	private String courseName;
	/* Subject Id of Timetable */
	private long subjectId;
	/* Subject name of Timetable */
	private String subjectName;
	/* Semester- wise of Timetable */
	private String semester;
	/* Date of exam of Timetable */
	private Date examDate;
	/* Time of exam of Timetable */
	private String examTime;
	/* Description of Timetable */
	private String description;

	/*
	 * Getter-Setter of Timetable
	 */

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

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKey() {
		return id + " ";
	}

	public String getValue() {
		return subjectName;
	}

}
