package com.spedi123.springmodels.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="toys")
public class Toy {

	
	//===== Primary Key =====

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
 // ========== Member Variables ==============
    
    @NotNull
    @Size(min = 2, max = 128)
    private String name;
    
    @NotNull
    @Size(min = 2, max = 128)
    private String color;
    
    @NotNull
    private boolean isSqueaky;
    
    // ===== Relationships =====
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dog_id")
    private Dog dog;
    
    // ===== Constructor =====
    
    public Toy(){};
    
    // ===== Getters and Setters =====

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean getIsSqueaky() {
		return isSqueaky;
	}

	public void setIsSqueaky(boolean isSqueaky) {
		this.isSqueaky = isSqueaky;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
    
}















