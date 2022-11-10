package id.co.team8.librarymanagement.vio.output.template;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import id.co.team8.librarymanagement.constant.JsonKeyConstant;
import id.co.team8.librarymanagement.vio.output.template.schema.ErrorMessage;
import id.co.team8.librarymanagement.vio.output.template.schema.ErrorSchema;

@Data
@AllArgsConstructor
public class ValueOutput {
    
    @JsonProperty(JsonKeyConstant.ERROR_SCHEMA)
    private ErrorSchema errorSchema = null;
    @JsonProperty(JsonKeyConstant.OUTPUT_SCHEMA)
    private Object outputSchema = null;


}
