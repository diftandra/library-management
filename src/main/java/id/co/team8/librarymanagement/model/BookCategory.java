package id.co.team8.librarymanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema = "library", name="book_category")
@Data
public class BookCategory extends Audit{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_category_id")
	private Integer bookCategoryId;

	@Column(name="book_category_code")
	private String bookCategoryCode;
	
	@Column(name="book_category_name")
	private String bookCategoryName;
	
	@Column(name="is_available")
	private Boolean isAvailable;

}
