package com.springboot.eVallet.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EVallet {

	@Id
	private long id;
	
	private String citizenId;

	private String customerName;
	
	private String customerSurname;
	
	private float found;
	
	public EVallet() {

	}
	
	public EVallet(String citizenId, String customerName, String customerSurname, float found) {
		super();
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.found = found;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public float getFound() {
		return found;
	}

	public void setFound(float found) {
		this.found = found;
	}

	@Override
	public String toString() {
		return "EVallet [id=" + id + ", citizenId=" + citizenId + ", customerName=" + customerName
				+ ", customerSurname=" + customerSurname + ", found=" + found + "]";
	}
}

