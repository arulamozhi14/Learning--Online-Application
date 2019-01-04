package com.synergisticit.onlinebanking.javafirstws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="CustomerRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRequest {
	
	@XmlElement(name="customerid")
	private int customerid;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "CustomerRequest [customerid=" + customerid + "]";
	}
	
}
