package com.unc.student.course.registraion.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Course implements Serializable {

	private static final long serialVersionUID = -3770142805983192214L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", unique = true, nullable = false, length = 20)
	private Long courseId;

	@Column(name = "course_name")
	@NotEmpty(message = "Please provide a courseName")
	private String courseName;

	@Column(name = "course_details")
	private String courseDetails;

	@Column(name = "course_duration")
	private String courseDuration;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = {
			@JoinColumn(name = "course_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "student_id", nullable = false, updatable = false) })
	private Set<Student> students;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseDetails == null) ? 0 : courseDetails.hashCode());
		result = prime * result + ((courseDuration == null) ? 0 : courseDuration.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseDetails == null) {
			if (other.courseDetails != null)
				return false;
		} else if (!courseDetails.equals(other.courseDetails))
			return false;
		if (courseDuration == null) {
			if (other.courseDuration != null)
				return false;
		} else if (!courseDuration.equals(other.courseDuration))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDetails=" + courseDetails
				+ ", courseDuration=" + courseDuration + "]";
	}

}
