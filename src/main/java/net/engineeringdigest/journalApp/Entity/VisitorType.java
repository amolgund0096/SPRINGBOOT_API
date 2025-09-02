package net.engineeringdigest.journalApp.Entity;

import javax.persistence.*;

@Entity
@Table(name = "visitor_types")
public class VisitorType {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="type_name")
    private String typeName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
    
}

