package com.BikkadIT.PhoneBookApplication.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	private int contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "ACTIVE_SW")
	private Character activeSwitch;
	@CreationTimestamp
	private LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Column(name="UPDATED_DATE",insertable = false)
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Character getActiveSwitch() {
		return activeSwitch;
	}
	public void setActiveSwitch(Character activeSwitch) {
		this.activeSwitch = activeSwitch;
	}
	public Contact(int contactId, String contactName, String contactNumber, String contactEmail,
			Character activeSwitch) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.contactEmail = contactEmail;
		this.activeSwitch = activeSwitch;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber=" + contactNumber
				+ ", contactEmail=" + contactEmail + ", activeSwitch=" + activeSwitch + "]";
	}
	
	
}

