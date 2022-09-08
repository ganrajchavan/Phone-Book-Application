package com.GaneshIT.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="CONTACT_DTLS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="ACTIVESWITCH")
	private Character activeSwitch;
	
	@Column(name="CREATEDDATE",updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATEDATE",insertable = false)
	@UpdateTimestamp
	private LocalDate  updateDate;
}
