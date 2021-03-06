/**
 * 
 */
package com.care.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author abdra
 *
 */
@Entity
@Table(schema="CARE",name="REQUESTED_MEDICINE")
public class RequestedMedicine implements Serializable {

	private static final long serialVersionUID = -4639990328940560923L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="POWER")
	private String power;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="REQUESTEDBY")
	private int requestedBy;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="REQUESTEDDATE")
	private Date requestedDate;
	
	@Column(name="DONATEDDATE")
	private Date donatedDate;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the requestedBy
	 */
	public int getRequestedBy() {
		return requestedBy;
	}

	/**
	 * @param requestedBy the requestedBy to set
	 */
	public void setRequestedBy(int requestedBy) {
		this.requestedBy = requestedBy;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the requestedDate
	 */
	public Date getRequestedDate() {
		return requestedDate;
	}

	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	/**
	 * @return the donatedDate
	 */
	public Date getDonatedDate() {
		return donatedDate;
	}

	/**
	 * @param donatedDate the donatedDate to set
	 */
	public void setDonatedDate(Date donatedDate) {
		this.donatedDate = donatedDate;
	}
	
	
}
