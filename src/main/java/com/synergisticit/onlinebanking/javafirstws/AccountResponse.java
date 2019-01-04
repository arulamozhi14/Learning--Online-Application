package com.synergisticit.onlinebanking.javafirstws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.synergisticit.onlinebanking.domain.Branch;

@XmlType(name="AccountResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountResponse {
	
	@XmlElement(name="accno")
	private long accno;
	
	@XmlElement(name="accType")
	private String accType;
	
	@XmlElement(name="accholdername")
	private String accholdername;
	
	@XmlElement(name="accBalance")
	private double accBalance;

	@XmlElement(name="branch")
	private int branch;
	
	@XmlElement(name="opendate")
	private Date opendate;
	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAccholdername() {
		return accholdername;
	}

	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}


	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	@Override
	public String toString() {
		return "AccountResponse [accno=" + accno + ", accType=" + accType + ", accholdername=" + accholdername
				+ ", accBalance=" + accBalance + ", branch=" + branch + ", opendate=" + opendate + "]";
	}

	


	



}
