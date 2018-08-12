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
	@Column
	private long address1;
	@Column
	private long city;
	@Column
	private long country;
	@Column
	private long zip;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAddress1() {
		return address1;
	}
	public void setAddress1(long address1) {
		this.address1 = address1;
	}
	public long getCity() {
		return city;
	}
	public void setCity(long city) {
		this.city = city;
	}
	public long getCountry() {
		return country;
	}
	public void setCountry(long country) {
		this.country = country;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	
	
	
	
	
	
}
