package com.spedi123.languages.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "languages")
public class Language {
	// ========== Primary Key ==========
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

	// ========== Member Variables ==========

	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	
	@NotNull
    @Size(min = 2, max = 20)
    private String creator;
	
	@NotNull
    private String currentVersion;
	
	// ========== Constructors ==========
	
	public Language () {}

	public Language(String name, String creator, String currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}

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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	};
	
}
