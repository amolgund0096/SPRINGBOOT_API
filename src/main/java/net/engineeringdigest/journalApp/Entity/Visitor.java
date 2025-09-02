package net.engineeringdigest.journalApp.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitors")
public class Visitor {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String visitorNo, visitorName, mobileNo, contactPerson;
    private LocalTime entryTime, exitTime;
    private String address, email, purpose, relation, photoPath;
    private int visitorTypeId, visitorCnt;
    private LocalDate visitDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVisitorNo() {
		return visitorNo;
	}
	public void setVisitorNo(String visitorNo) {
		this.visitorNo = visitorNo;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public LocalTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}
	public LocalTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalTime exitTime) {
		this.exitTime = exitTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public int getVisitorTypeId() {
		return visitorTypeId;
	}
	public void setVisitorTypeId(int visitorTypeId) {
		this.visitorTypeId = visitorTypeId;
	}
	public int getVisitorCnt() {
		return visitorCnt;
	}
	public void setVisitorCnt(int visitorCnt) {
		this.visitorCnt = visitorCnt;
	}
	public LocalDate getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
    
}

