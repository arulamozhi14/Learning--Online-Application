package com.synergisticit.onlinebanking.javafirstws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="TransactionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class WithdrawRequest {
	
	@XmlElement(name="fromAccountnumber")
	private long fromAccountnumber;
	
	@XmlElement(name="amtwithdraw")
	private double amtwithdraw;

	public long getFromAccountnumber() {
		return fromAccountnumber;
	}

	public void setFromAccountnumber(long fromAccountnumber) {
		this.fromAccountnumber = fromAccountnumber;
	}

	public double getAmtwithdraw() {
		return amtwithdraw;
	}

	public void setAmtwithdraw(double amtwithdraw) {
		this.amtwithdraw = amtwithdraw;
	}

	@Override
	public String toString() {
		return "WithdrawRequest [fromAccountnumber=" + fromAccountnumber + ", amtwithdraw=" + amtwithdraw + "]";
	}
	
	
}
