package com.abhi.spring.hibernate.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity 
@Table(name="Company")
@Access(value=AccessType.FIELD)
public class Company implements Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Long id;
	@Column(nullable=false)
	private String companyId;
	@OneToOne(cascade=CascadeType.ALL)
	private Address primaryAddress;
	@Column(name="company_name")
	private String companyName;
/*	@ManyToMany 	
    @JoinTable(name = "Company_Address", 
    joinColumns = { @JoinColumn(name = "company_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "address_id")})*/
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="company_id")
	private List<Address> contacts;
	@Column
    private String qualifier;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Address getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(Address primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(String company_id) {
		this.companyId = company_id;
	}
	public Address getAddress() {
		return primaryAddress;
	}
	public void setAddress(Address address) {
		this.primaryAddress = address;
	}
	public List<Address> getContacts() {
		return contacts;
	}
	public void setContacts(List<Address> contacts) {
		this.contacts = contacts;
	}
	public String getQualifier() {
		return qualifier;
	}
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
	
	
	
}
