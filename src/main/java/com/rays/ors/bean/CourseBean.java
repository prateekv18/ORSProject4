package com.rays.ors.bean;

/**
 *Course JavaBean encapsulates Course attributes.
 *
 * @author Prateek
 *
 */
public class CourseBean extends BaseBean {
	/* Name of course */
	private String name;

	/* Description of course */
	private String description;

	/* Duration of course */
	private String duration;

	/*
	 * Getters-Setters of Course
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return name;
	}
}
