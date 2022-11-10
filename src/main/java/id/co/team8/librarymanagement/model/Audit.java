package id.co.team8.librarymanagement.model;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import id.co.team8.librarymanagement.constant.JsonKeyConstant;

public class Audit {
    @JsonProperty(JsonKeyConstant.CREATED_BY)
	@Column(columnDefinition="VARCHAR", nullable=true, length=10)
	@CreatedBy
	private String createdBy;
	
	@JsonProperty(JsonKeyConstant.CREATED_DATE)
	@Column(columnDefinition="TIMESTAMPTZ")
	@CreatedDate
	private LocalDateTime createdDate;
	
	@JsonProperty(JsonKeyConstant.UPDATED_BY)
	@Column(columnDefinition="VARCHAR", nullable=true, length=10)
	@LastModifiedBy
	private String updatedBy;
	
	@JsonProperty(JsonKeyConstant.UPDATED_DATE)
	@Column(columnDefinition="TIMESTAMPTZ")
	@LastModifiedDate
	private LocalDateTime updatedDate;
}
