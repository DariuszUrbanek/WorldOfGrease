package com.example.du.shop.generated;
// Generated 01-Sep-2018 16:53:30 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "address", schema = "dbo", catalog = "shop")
public class Address implements java.io.Serializable {

	private Integer addId;
	private Client client;
	private String addName;
	private String addCountry;
	private String addCity;
	private String addPostcode;
	private String addStreet;
	private String addHouseNumber;
	private String addFlatNumber;

	public Address() {
	}

	public Address(Client client, String addName, String addCountry, String addCity, String addPostcode,
			String addStreet, String addHouseNumber, String addFlatNumber) {
		this.client = client;
		this.addName = addName;
		this.addCountry = addCountry;
		this.addCity = addCity;
		this.addPostcode = addPostcode;
		this.addStreet = addStreet;
		this.addHouseNumber = addHouseNumber;
		this.addFlatNumber = addFlatNumber;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "add_id", unique = true, nullable = false)
	public Integer getAddId() {
		return this.addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "add_cl_id")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "add_name", length = 100)
	public String getAddName() {
		return this.addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	@Column(name = "add_country", length = 50)
	public String getAddCountry() {
		return this.addCountry;
	}

	public void setAddCountry(String addCountry) {
		this.addCountry = addCountry;
	}

	@Column(name = "add_city", length = 100)
	public String getAddCity() {
		return this.addCity;
	}

	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}

	@Column(name = "add_postcode", length = 20)
	public String getAddPostcode() {
		return this.addPostcode;
	}

	public void setAddPostcode(String addPostcode) {
		this.addPostcode = addPostcode;
	}

	@Column(name = "add_street", length = 100)
	public String getAddStreet() {
		return this.addStreet;
	}

	public void setAddStreet(String addStreet) {
		this.addStreet = addStreet;
	}

	@Column(name = "add_house_number", length = 20)
	public String getAddHouseNumber() {
		return this.addHouseNumber;
	}

	public void setAddHouseNumber(String addHouseNumber) {
		this.addHouseNumber = addHouseNumber;
	}

	@Column(name = "add_flat_number", length = 20)
	public String getAddFlatNumber() {
		return this.addFlatNumber;
	}

	public void setAddFlatNumber(String addFlatNumber) {
		this.addFlatNumber = addFlatNumber;
	}

}