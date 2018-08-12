package com.abhi.spring.hibernate.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private String company_id;
	@OneToOne(cascade=CascadeType.ALL)
	private Address primaryAddress;
    @ManyToMany 	
    @JoinTable(name = "Company_Address", 
    joinColumns = { @JoinColumn(name = "company_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "address_id")})
	private List<Address> contacts;
	@Column
    private String qualifier;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompany_id() {
		return company_id;
	}
	
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
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
