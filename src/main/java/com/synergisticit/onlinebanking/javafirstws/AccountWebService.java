package com.synergisticit.onlinebanking.javafirstws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.synergisticit.onlinebanking.domain.Account;
import com.synergisticit.onlinebanking.service.AccountService;

@WebService(name="AccountWebService")
public interface AccountWebService {
	
	@WebMethod
	public DepositResponse deposit(DepositRequest depositrequest);
	
	@Transactional
	@WebMethod
	public  AccountdetailResponse getAccountdetails(AccountdetailRequest accountdetailRequest);
	
	@Transactional
	@WebMethod
	
	public AccountResponse createAccount(AccountRequest accountrequest);
	
	@WebMethod
	public CustomerResponse getCustomerdetails(CustomerRequest customerrequest);
	
	@WebMethod
	public WithdrawResponse getwithdrawdetails(WithdrawRequest WithdrawRequest);
	
	@WebMethod
	public TransferamountResponse transaferamount(TransferamountRequest transferamountRequest);
	
	
	
	
	
}
