package com.synergisticit.onlinebanking.javafirstws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="TransferamountRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferamountRequest {
	
	@XmlElement(name="fromAccountNumber")
	private long fromAccountNumber;
	
	@XmlElement(name="toAccountNumber")
	private long toAccountNumber;
	
	@XmlElement(name="amountToBeTransfer")
	private double amountToBeTransfer;

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

	public double getAmountToBeTransfer() {
		return amountToBeTransfer;
	}

	public void setAmountToBeTransfer(double amountToBeTransfer) {
		this.amountToBeTransfer = amountToBeTransfer;
	}

	@Override
	public String toString() {
		return "TransferamountRequest [fromAccountNumber=" + fromAccountNumber + ", toAccountNumber=" + toAccountNumber
				+ ", amountToBeTransfer=" + amountToBeTransfer + "]";
	}
	
	
	
}
