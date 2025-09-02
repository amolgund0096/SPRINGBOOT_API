package net.engineeringdigest.journalApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "standard_master")
public class Standard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String standard_desc;
	private String status;
	private Integer standard_order;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStandard_desc() {
		return standard_desc;
	}
	public void setStandard_desc(String standard_desc) {
		this.standard_desc = standard_desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getStandard_order() {
		return standard_order;
	}
	public void setStandard_order(Integer standard_order) {
		this.standard_order = standard_order;
	}
	
	
}
