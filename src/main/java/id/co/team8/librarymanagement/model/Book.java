package id.co.team8.librarymanagement.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema = "library", name="book")
@Data
public class Book extends Audit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private Integer bookId;
	
	@Column(name="book_name")
	private String bookName;

	@Column(name="book_category_code")
	private String bookCategoryCode;
	
	@Column(name="book_author")
	private String bookAuthor;
	
	@Column(name="book_image")
	private Blob bookImage;

	@Column(name="book_number")
	private String bookNumber;

	@Column(name="book_description")
	private String bookDescription;

	@Column(name="publisher")
	private String publisher;
	
	@Column(name="is_available")
	private Boolean isAvailable;

}
