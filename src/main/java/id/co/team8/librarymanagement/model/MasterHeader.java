package id.co.team8.librarymanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema = "library", name="master_header")
@Data
public class MasterHeader extends Audit {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="master_header_id")
	private Integer masterHeaderId;
	
	@Column(columnDefinition="VARCHAR", length=10)
    private String masterHeaderCode;
    
    @Column(columnDefinition="VARCHAR", length=100)
    private String masterHeaderDesc;
    
    @Column(columnDefinition="BOOLEAN")
    private Boolean isActive;

}
