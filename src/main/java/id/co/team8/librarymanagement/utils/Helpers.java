package id.co.team8.librarymanagement.utils;

import org.springframework.http.ResponseEntity;

import id.co.team8.librarymanagement.enums.ErrorOutput;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;
import id.co.team8.librarymanagement.vio.output.template.schema.ErrorMessage;
import id.co.team8.librarymanagement.vio.output.template.schema.ErrorSchema;
import lombok.Data;

@Data
public class Helpers {
    
    public static ResponseEntity<ValueOutput> createResponse(ErrorOutput errorOutput, Object outputSchema){
        ErrorMessage errorMessage = new ErrorMessage(errorOutput.getErrorMessageEnglish(),errorOutput.getErrorMessageIndonesian());
        ErrorSchema errorSchema = new ErrorSchema(errorOutput.getErrorCode(),errorMessage);
        return new ResponseEntity<>(new ValueOutput(errorSchema, outputSchema), errorOutput.getHttpStatus());
    }

    public static ValueOutput createValueOutput(ErrorOutput errorOutput,Object outputSchema){
        ErrorMessage errorMessage = new ErrorMessage(errorOutput.getErrorMessageEnglish(),errorOutput.getErrorMessageIndonesian());
        ErrorSchema errorSchema = new ErrorSchema(errorOutput.getErrorCode(),errorMessage);
        return new ValueOutput(errorSchema,outputSchema);
    }

}
