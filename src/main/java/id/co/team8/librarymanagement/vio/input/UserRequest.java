package id.co.team8.librarymanagement.vio.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import id.co.team8.librarymanagement.constant.JsonKeyConstant;
import id.co.team8.librarymanagement.model.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
public class UserRequest extends Audit {

	@JsonProperty(JsonKeyConstant.USER_USER_ID)
	private Integer userId;

	@JsonProperty(JsonKeyConstant.USER_USERNAME)
	private String username;

	@JsonProperty(JsonKeyConstant.USER_PASSWORD)
	private String password;

	@JsonProperty(JsonKeyConstant.USER_ROLE)
	private String role;

	@JsonProperty(JsonKeyConstant.USER_ENABLED)
	private Boolean enabled;
}
