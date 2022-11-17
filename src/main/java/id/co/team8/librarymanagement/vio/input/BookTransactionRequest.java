package id.co.team8.librarymanagement.vio.input;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import id.co.team8.librarymanagement.constant.JsonKeyConstant;
import lombok.Data;

@Data
public class BookTransactionRequest {

    @JsonProperty(JsonKeyConstant.BOOK_TRANSACTION_ID)
	private Integer bookTransactionId;

    @JsonProperty(JsonKeyConstant.BOOK_ID)
	private Integer bookId;
	
    @JsonProperty(JsonKeyConstant.BOOK_TRANSACTION_TYPE)
    private String bookTransactionType;

	@JsonProperty(JsonKeyConstant.BOOK_BORROWER_NAME)
	private String bookBorrowerName;

    @JsonProperty(JsonKeyConstant.BOOK_BORROWER_PHONE)
    private String bookBorrowerPhone;

    @JsonProperty(JsonKeyConstant.BOOK_BORROW_DATE)
    private Date bookBorrowDate;

    @JsonProperty(JsonKeyConstant.BOOK_RETURN_DATE)
    private Date bookReturnDate;
}
