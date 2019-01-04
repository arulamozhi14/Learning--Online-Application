package com.synergisticit.onlinebanking.javafirstws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="TransactionResponse")
@XmlAccessorType(XmlAccessType.FIELD)  //fromAccount same as like fromAccountnumber from request class
public class WithdrawResponse {
	
	@XmlElement(name="fromAccount")
	private long fromAccount;
	
	@XmlElement(name="accBalance")
	private double accBalance;
	
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	@Override
	public String toString() {
		return "TransactionResponse [fromAccount=" + fromAccount + ", accBalance=" + accBalance + "]";
	}
	
	
}
