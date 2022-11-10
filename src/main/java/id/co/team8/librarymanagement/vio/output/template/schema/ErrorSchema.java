package id.co.team8.librarymanagement.vio.output.template.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import id.co.team8.librarymanagement.constant.JsonKeyConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorSchema {
    @JsonProperty(JsonKeyConstant.ERROR_CODE)
    private String errorCode = "";
    @JsonProperty(JsonKeyConstant.ERROR_MESSAGE)
    private ErrorMessage errorMessage = null;
}
