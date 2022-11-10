package id.co.team8.librarymanagement.vio.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import id.co.team8.librarymanagement.constant.JsonKeyConstant;
import lombok.Data;

@Data
public class BookCategoryRequest {

    @JsonProperty(JsonKeyConstant.BOOK_CATEGORY_ID)
    private Integer bookCategoryId;
    
    @JsonProperty(JsonKeyConstant.BOOK_CATEGORY_NAME)
	private String bookCategoryName;
	
	@JsonProperty(JsonKeyConstant.IS_AVAILABLE)
	private Boolean isAvailable;

}
