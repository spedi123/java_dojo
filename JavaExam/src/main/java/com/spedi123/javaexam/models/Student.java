package com.spedi123.javaexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
	// ========== Primary Key ==========
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ========== Member Variables ==========

	@NotNull
	@Size(min = 2, max = 128, message = "Student name must be at least 2 characters.")
	private String studnetName;
	
	@NotNull
	@Email(message="Please enter a valid email!")
	private String email;
	    
	@NotNull
	@Min(0)
	private int age;


	// ========== Data Creation Tracker ==========

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// ========== Constructors ==========

	public Student() {}
	// =========== Relationships ==========
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "courses_students", 
	        joinColumns = @JoinColumn(name = "student_id"), 
	        inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
	    private List<Course> courses;


	// ========== Data Creation Event ==========

	@PrePersist
	protected void onCreate() {
			this.createdAt = new Date();
			this.updatedAt = new Date();
		}
		
	@PreUpdate
	protected void onUpdate() {
			this.updatedAt = new Date();
	}
	
	
	// ========== Getters and Setters ==========

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudnetName() {
		return studnetName;
	}

	public void setStudnetName(String studnetName) {
		this.studnetName = studnetName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}