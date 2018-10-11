package com.abhi.spring.hibernate.bean;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Address")
@Access(value=AccessType.FIELD)
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="address_id")
	private long id;
    @Column(name="address_key") 
	private String key;
	@Column
	private String address1;
	@Column
	private String city;
	@Column
	private String country;
	@Column
	private String zip;
	@Column 
	private Long company_id;
	@Column
	private boolean isPrimary;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public Long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", key=" + key + ", address1=" + address1 + ", city=" + city + ", country="
				+ country + ", zip=" + zip + ", company_id=" + company_id + "]";
	}
	
	
}
