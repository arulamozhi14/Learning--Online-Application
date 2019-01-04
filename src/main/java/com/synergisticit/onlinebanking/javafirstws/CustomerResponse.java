package com.synergisticit.onlinebanking.javafirstws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="CustomerResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerResponse {
	
	@XmlElement(name="passportid")
	private int passportid;
	
	@XmlElement(name="customerfname")
	private String customerfname;
	
	@XmlElement(name="customerlname")
	private String customerlname;
	
	@XmlElement(name="gender")
	private String gender;
	
	@XmlElement(name="dob")
	private Date dob;
	
	@XmlElement(name="mobile")
	private long mobile;
	
	public int getPassportid() {
		return passportid;
	}
	public void setPassportid(int passportid) {
		this.passportid = passportid;
	}
	public String getCustomerfname() {
		return customerfname;
	}
	public void setCustomerfname(String customerfname) {
		this.customerfname = customerfname;
	}
	public String getCustomerlname() {
		return customerlname;
	}
	public void setCustomerlname(String customerlname) {
		this.customerlname = customerlname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "CustomerResponse [passportid=" + passportid + ", customerfname=" + customerfname + ", customerlname="
				+ customerlname + ", gender=" + gender + ", dob=" + dob + ", mobile=" + mobile + "]";
	}
	
	
}

