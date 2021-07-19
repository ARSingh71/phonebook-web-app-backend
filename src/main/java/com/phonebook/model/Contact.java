package com.phonebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contactDetails")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactId;
	
	@Column(name = "contact_name", nullable=false, length=50)
	private String contactName;
	
	@Column(name = "contact_email", nullable=true, length=50)
	private String contactEmail;
	
	@Column(name = "contact_phone_number", nullable=false)
	private String contactPhoneNumber;
	
	public Contact() {
	
	}

	public Contact(String contactName, String contactEmail, String contactPhoneNumber) {
		super();
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactPhoneNumber = contactPhoneNumber;
	}
	
	public long getContactId() {
		return contactId;
	}
	
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	

	
	
}
