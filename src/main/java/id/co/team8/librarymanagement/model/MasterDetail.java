package id.co.team8.librarymanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(schema = "library", name="master_detail")
@Data
public class MasterDetail {
    
    @Id
    @Column(columnDefinition = "UUID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("master_detail_id")
    private Integer masterDetailId;
	
    @JsonProperty("master_header_code")
	@Column(columnDefinition="VARCHAR", length=10)
    private String masterHeaderCode;

    @JsonProperty("master_detail_code")
    @Column(columnDefinition="VARCHAR", length=10)
    private String masterDetailCode;
    
    @JsonProperty("master_detail_desc")
    @Column(columnDefinition="VARCHAR", length=100)
    private String masterDetailDesc;
    
    @JsonProperty("is_active")
    @Column(columnDefinition="BOOLEAN")
    private Boolean isActive;

}
