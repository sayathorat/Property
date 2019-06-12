package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="lease")

public class Lease implements Serializable
{

	private long property_id;
	
	private Date Move_In_Date;
	private Date Lease_End_Date;
	private Double Rent;
	private Boolean No_End_Date;
	private Integer Due_Dom;
	private Boolean First_Month_Partial;
	private Boolean Last_Month_Partial;
	private String Agreement_s3_um;
	private String Status;
	private Date Created_on;
	private Date Updated_on;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lease_id;
	
	
	@ManyToOne
    @JoinColumn(name = "property_id",referencedColumnName="property_id",insertable=false, updatable=false)
    private Property property;
	
	public long getLease_id() {
		return lease_id;
	}
	public void setLease_id(long lease_id) {
		this.lease_id = lease_id;
	}
	public long getProperty_id() {
		return property_id;
	}
	public void setProperty_id(long property_id) {
		this.property_id = property_id;
	}
	public Date getMove_In_Date() {
		return Move_In_Date;
	}
	public void setMove_In_Date(Date move_In_Date) {
		Move_In_Date = move_In_Date;
	}
	public Date getLease_End_Date() {
		return Lease_End_Date;
	}
	public void setLease_End_Date(Date lease_End_Date) {
		Lease_End_Date = lease_End_Date;
	}
	public Double getRent() {
		return Rent;
	}
	public void setRent(Double rent) {
		Rent = rent;
	}
	public Boolean getNo_End_Date() {
		return No_End_Date;
	}
	public void setNo_End_Date(Boolean no_End_Date) {
		No_End_Date = no_End_Date;
	}
	public Integer getDue_Dom() {
		return Due_Dom;
	}
	public void setDue_Dom(Integer due_Dom) {
		Due_Dom = due_Dom;
	}
	public Boolean getFirst_Month_Partial() {
		return First_Month_Partial;
	}
	public void setFirst_Month_Partial(Boolean first_Month_Partial) {
		First_Month_Partial = first_Month_Partial;
	}
	public Boolean getLast_Month_Partial() {
		return Last_Month_Partial;
	}
	public void setLast_Month_Partial(Boolean last_Month_Partial) {
		Last_Month_Partial = last_Month_Partial;
	}
	public String getAgreement_s3_um() {
		return Agreement_s3_um;
	}
	public void setAgreement_s3_um(String agreement_s3_um) {
		Agreement_s3_um = agreement_s3_um;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getCreated_on() {
		return Created_on;
	}
	public void setCreated_on(Date created_on) {
		Created_on = created_on;
	}
	public Date getUpdated_on() {
		return Updated_on;
	}
	public void setUpdated_on(Date updated_on) {
		Updated_on = updated_on;
	}

}
