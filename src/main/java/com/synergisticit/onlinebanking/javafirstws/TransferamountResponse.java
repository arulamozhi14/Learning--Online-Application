package com.synergisticit.onlinebanking.javafirstws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="TransferamountResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferamountResponse {
	
	
	@XmlElement(name="fromAccountNumber")
	private long fromAccountNumber;
	
	@XmlElement(name="toAccountNumber")
	private long toAccountNumber;
	
	@XmlElement(name="transaferredamount")
	private double transaferredamount;
	
	@XmlElement(name="fromAccountOldBalance")
	private double fromAccountOldBalance;
	
	@XmlElement(name="fromAccountNewBalance")
	private double fromAccountNewBalance;
	
	@XmlElement(name="toAccountOldBalance")
	private double toAccountOldBalance;
	
	@XmlElement(name="toAccountNewBalance")
	private double toAccountNewBalance;

	
	public long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public long getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public double getTransaferredamount() {
		return transaferredamount;
	}

	public void setTransaferredamount(double transaferredamount) {
		this.transaferredamount = transaferredamount;
	}

	public double getFromAccountOldBalance() {
		return fromAccountOldBalance;
	}

	public void setFromAccountOldBalance(double fromAccountOldBalance) {
		this.fromAccountOldBalance = fromAccountOldBalance;
	}

	public double getFromAccountNewBalance() {
		return fromAccountNewBalance;
	}

	public void setFromAccountNewBalance(double fromAccountNewBalance) {
		this.fromAccountNewBalance = fromAccountNewBalance;
	}

	public double getToAccountOldBalance() {
		return toAccountOldBalance;
	}

	public void setToAccountOldBalance(double toAccountOldBalance) {
		this.toAccountOldBalance = toAccountOldBalance;
	}

	public double getToAccountNewBalance() {
		return toAccountNewBalance;
	}

	public void setToAccountNewBalance(double toAccountNewBalance) {
		this.toAccountNewBalance = toAccountNewBalance;
	}

	@Override
	public String toString() {
		return "TransferamountResponse [fromAccountNumber=" + fromAccountNumber + ", toAccountNumber=" + toAccountNumber
				+ ", transaferredamount=" + transaferredamount + ", fromAccountOldBalance=" + fromAccountOldBalance
				+ ", fromAccountNewBalance=" + fromAccountNewBalance + ", toAccountOldBalance=" + toAccountOldBalance
				+ ", toAccountNewBalance=" + toAccountNewBalance + "]";
	}
	
	
	
	
	
	
	
	
	

}
