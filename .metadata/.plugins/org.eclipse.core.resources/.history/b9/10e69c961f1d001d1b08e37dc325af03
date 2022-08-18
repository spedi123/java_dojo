package com.spedi123.bookclub.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

	public Book() {}
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@NotEmpty(message="Title must not be blank")
		@Size(min=1, max=255, message="Please enter a title for the book")
		private String title;
		
		@NotEmpty(message="author must not be blank")
		@Size(min=1, max=255, message="Please enter an author for the book")
		private String author;
		
		@NotEmpty(message="thoughts must not be blank")
		@Size(min=1, max=255, message="Thoughts must be between 1-255 characters")
		private String thought;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;

		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		public String getThought() {
			return thought;
		}

		public void setThought(String thought) {
			this.thought = thought;
		}
		
	
	
}