package id.co.team8.librarymanagement.constant;

public @interface JsonKeyConstant {

    /* Book */
    String BOOK_ID = "book_id";
    String BOOK_NAME = "book_name";
    String BOOK_AUTHOR = "book_author";
    String BOOK_IMAGE = "book_image";
    String BOOK_NUMBER = "book_number";
    String BOOK_DESCRIPTION = "book_description";
    String PUBLISHER = "publisher";

    /* Book Category */
    String BOOK_CATEGORY_ID = "book_category_id";
    String BOOK_CATEGORY_NAME = "book_category_name";

    /* Book Transaction */
    String BOOK_TRANSACTION_ID = "book_transaction_id";
    String BOOK_TRANSACTION_TYPE = "book_transaction_type";
    String BOOK_BORROWER_NAME = "book_borrower_name";
    String BOOK_BORROWER_PHONE = "book_borrower_phone";
    String BOOK_BORROW_DATE = "book_borrow_date";
    String BOOK_RETURN_DATE = "book_return_date";

    /* Audit */
    String CREATED_BY = "created_by";
	String CREATED_DATE = "created_date";
	String UPDATED_BY = "updated_by";
	String UPDATED_DATE = "updated_date";

    /*General */
    String IS_AVAILABLE = "is_available";

    String ERROR_SCHEMA = "error_schema";
    String OUTPUT_SCHEMA = "output_schema";
    String ERROR_CODE = "error_code";
    String ERROR_MESSAGE = "error_message";
    String HTTP_CODE = "http_code";
    String HTTP_STATUS = "http_status";
    String MESSAGE_CODE = "message_code";
    String MESSAGE = "message";
    String DATA = "data";
    
}
