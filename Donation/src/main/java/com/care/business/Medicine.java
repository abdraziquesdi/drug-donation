/**
 * 
 */
package com.care.business;

/**
 * @author abdra
 *
 */
public class Medicine {

	private long id;
	private String name;
	private String type;
	private String power;
	private int quantity;
	private String expiryDate;
	private String donatedBy;
	private String status;
	private String recievedDate;
	private String donatedDate;
	private String requestedDate;
	
	
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
	 * @return the expirayDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expirayDate the expirayDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the donatedBy
	 */
	public String getDonatedBy() {
		return donatedBy;
	}
	/**
	 * @param donatedBy the donatedBy to set
	 */
	public void setDonatedBy(String donatedBy) {
		this.donatedBy = donatedBy;
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
	 * @return the donatedDate
	 */
	public String getDonatedDate() {
		return donatedDate;
	}
	/**
	 * @param donatedDate the donatedDate to set
	 */
	public void setDonatedDate(String donatedDate) {
		this.donatedDate = donatedDate;
	}
	/**
	 * @return the requestedDate
	 */
	public String getRequestedDate() {
		return requestedDate;
	}
	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	/**
	 * @return the recievedDate
	 */
	public String getRecievedDate() {
		return recievedDate;
	}
	/**
	 * @param recievedDate the recievedDate to set
	 */
	public void setRecievedDate(String recievedDate) {
		this.recievedDate = recievedDate;
	}
	
	
	
	
}
