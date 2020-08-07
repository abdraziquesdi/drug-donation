/**
 * 
 */
package com.care.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author abdra
 *
 */
@Entity
@Table(schema="CARE",name="USERPROFILE")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = -978430940379697225L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private long id;
	
	@Column(name = "FIRSTNAME")
    private String firstName;
 
	@Column(name = "LASTNAME")
    private String lastName;
    
	@Column(name = "PHONENO")
    private String phoneNo;
    
	@Column(name = "EMAILID")
    private String emailId;
	
	@Column(name = "PWD")
    private String pd;
    
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PID")  
    private List<Address> address;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the pd
	 */
	public String getPd() {
		return pd;
	}

	/**
	 * @param pd the pd to set
	 */
	public void setPd(String pd) {
		this.pd = pd;
	}
	
	
	
}
