package id.co.team8.librarymanagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="book_transaction")
@Data
public class BookTransaction {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_transacton_id")
	private Integer bookTransactionId;

    @Column(name="book_id")
    private Integer bookId;
	
    @Column(name="book_transaction_type")
    private String bookTransactionType;

	@Column(name="book_borrower_name")
	private String bookBorrowerName;

    @Column(name="book_borrower_phone")
    private String bookBorrowerPhone;

    @Column(name="book_borrow_date")
    private Date bookBorrowDate;

    @Column(name="book_return_date")
    private Date bookReturnDate;
	
}
