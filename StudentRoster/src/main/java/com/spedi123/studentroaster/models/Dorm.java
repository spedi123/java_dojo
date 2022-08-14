package com.spedi123.studentroaster.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dorms")
public class Dorm {
	
	// ========== Primary Key ==========
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ========== Member Variables ==========

	@NotNull
	@Size(min = 2, max = 128, message = "Dorm name must be at least 2 characters.")
	private String name;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// ========== Constructors ==========
	
	public Dorm() {}
	
	public Dorm(String name) {
		this.name = name;
	}

	// =========== Relationships ==========

	@OneToMany(mappedBy="dorm", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> students;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
