package com.synergisticit.onlinebanking.javafirstws;

public class AccountdetailRequest {

	private long accno;

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	@Override
	public String toString() {
		return "AccountdetailRequest [accno=" + accno + "]";
	}
	
}
