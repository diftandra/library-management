package id.co.team8.librarymanagement.enums;

import org.springframework.http.HttpStatus;

public enum ErrorOutput {
    OK("INS000", "Sukses", "Success", HttpStatus.OK),
    BAD_REQUEST("INS001", "Gagal", "Failed", HttpStatus.BAD_REQUEST);

    private String errorCode;
    private String errorMessageIndonesian;
    private String errorMessageEnglish;
    private HttpStatus httpStatus;

    ErrorOutput(String errorCode, String errorMessageIndonesian, String errorMessageEnglish, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessageIndonesian = errorMessageIndonesian;
        this.errorMessageEnglish = errorMessageEnglish;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessageIndonesian() {
        return errorMessageIndonesian;
    }

    public String getErrorMessageEnglish() {
        return errorMessageEnglish;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
