package com.synergisticit.onlinebanking.javafirstws;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;


@XmlType(name="AccountRequest")
public class AccountRequest {
	
	private long accno;
	private String accType;
	private String accholdername;
	private double accBalance;
	private int bcode;
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
	
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	@Override
	public String toString() {
		return "AccountRequest [accno=" + accno + ", accType=" + accType + ", accholdername=" + accholdername
				+ ", accBalance=" + accBalance + ", bcode=" + bcode + ", opendate=" + opendate + "]";
	}
	
	
	
	
	
}
