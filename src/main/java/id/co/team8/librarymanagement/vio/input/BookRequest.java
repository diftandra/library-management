package id.co.team8.librarymanagement.vio.input;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonProperty;

import id.co.team8.librarymanagement.constant.JsonKeyConstant;
import lombok.Data;

@Data
public class BookRequest {
    
    @JsonProperty(JsonKeyConstant.BOOK_ID)
	private Integer bookId;
	
	@JsonProperty(JsonKeyConstant.BOOK_NAME)
	private String bookName;
	
	@JsonProperty(JsonKeyConstant.BOOK_AUTHOR)
	private String bookAuthor;
	
	@JsonProperty(JsonKeyConstant.BOOK_IMAGE)
	private Blob bookImage;

	@JsonProperty(JsonKeyConstant.BOOK_NUMBER)
	private String bookNumber;

	@JsonProperty(JsonKeyConstant.BOOK_DESCRIPTION)
	private String bookDescription;

	@JsonProperty(JsonKeyConstant.PUBLISHER)
	private String publisher;
	
	@JsonProperty(JsonKeyConstant.IS_AVAILABLE)
	private Boolean isAvailable;

}
