package com.synergisticit.onlinebanking.javafirstws;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergisticit.onlinebanking.domain.Account;
import com.synergisticit.onlinebanking.domain.Branch;
import com.synergisticit.onlinebanking.domain.Customer;
import com.synergisticit.onlinebanking.service.BranchService;

@Transactional
@Service(value="accountWebServiceImpl")
public class AccountWebServiceImpl implements AccountWebService {

	//BEFORE THIS WE TRY TO AUTOWIRE ACCOUNTSERVICE IMPL/ACCOUNTSERVICE JPA TO USE METHOD FROM THERE. 
	//IS NOT WORKING ..SO HERE WE USING SESSION FACTORY TO DO THAT 
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	BranchService branchService;
	

	@Override
	public DepositResponse deposit(DepositRequest depositrequest) {
		System.out.println("######"+depositrequest.getAccountId());
		Account account=getSession().get(Account.class, depositrequest.getAccountId());
		double balance=account.getAccBalance()+depositrequest.getAmount();
		System.out.println("new balance is"+balance);
		account.setAccBalance(balance);
		getSession().persist(account);
		
		DepositResponse response=new DepositResponse();
		response.setAccBalance(balance);
		response.setAccno(depositrequest.getAccountId());
		
		return response;
	}
	
	@Override
	public AccountResponse createAccount(AccountRequest accountrequest) {
		Account account=new Account();
		account.setAccno(accountrequest.getAccno());
		account.setAccType(accountrequest.getAccType());
		account.setAccholdername(accountrequest.getAccholdername());
		account.setOpendate(accountrequest.getOpendate());
		account.setAccBalance(accountrequest.getAccBalance());

		Branch branch=getSession().get(Branch.class, accountrequest.getBcode());
	
		account.setBranch(branch);
		
		getSession().merge(account);
		
		Criteria criteria=getSession().createCriteria(Account.class).setProjection(Projections.max("accno"));
		Long accountNumber=(Long)criteria.uniqueResult();
		account.setAccno(accountNumber+1);
		System.out.println("#####"+accountNumber);
		
		AccountResponse accountResponse=new AccountResponse();
		accountResponse.setAccno(account.getAccno());
		accountResponse.setAccholdername(account.getAccholdername());
		accountResponse.setAccType(account.getAccType());
		accountResponse.setBranch(account.getBranch().getBcode());
		accountResponse.setAccBalance(account.getAccBalance());
		accountResponse.setOpendate(account.getOpendate());
		return accountResponse;
	}
	
	
	@Override
	public WithdrawResponse getwithdrawdetails(WithdrawRequest WithdrawRequest) {
		Account account=getSession().get(Account.class,WithdrawRequest.getFromAccountnumber());
		double total=account.getAccBalance()-WithdrawRequest.getAmtwithdraw();
		System.out.println("total amount is "+total);
		account.setAccBalance(total);
		getSession().persist(account);
		
		WithdrawResponse withdrawResponse=new WithdrawResponse();
		withdrawResponse.setAccBalance(total);
		withdrawResponse.setFromAccount(WithdrawRequest.getFromAccountnumber());
		return withdrawResponse;
	}

	@Override
	public TransferamountResponse transaferamount(TransferamountRequest transferamountRequest) {
		Account fromAccount=getSession().get(Account.class, transferamountRequest.getToAccountNumber());
		double fromAccountOldBalance=fromAccount.getAccBalance();
		
		Account toAccount=getSession().get(Account.class, transferamountRequest.getFromAccountNumber());
		double toAccountOldBalance=toAccount.getAccBalance();
		double total_amount=fromAccount.getAccBalance()-transferamountRequest.getAmountToBeTransfer();
		
		System.out.println("transfer amount is "+total_amount);
		fromAccount.setAccBalance(total_amount);
		getSession().persist(fromAccount);
		toAccount.setAccBalance(toAccount.getAccBalance()+transferamountRequest.getAmountToBeTransfer());
		getSession().persist(toAccount);
		
		TransferamountResponse transferamountResponse=new TransferamountResponse();
		
		transferamountResponse.setTransaferredamount(transferamountRequest.getAmountToBeTransfer());
		transferamountResponse.setFromAccountNumber(fromAccount.getAccno());
		transferamountResponse.setFromAccountNewBalance(fromAccount.getAccBalance());
		transferamountResponse.setFromAccountOldBalance(fromAccountOldBalance);
		transferamountResponse.setToAccountNumber(toAccount.getAccno());
		transferamountResponse.setToAccountNewBalance(toAccount.getAccBalance());
		transferamountResponse.setToAccountOldBalance(toAccountOldBalance);
		
		return transferamountResponse;
	}

	@Override
	public  AccountdetailResponse getAccountdetails(AccountdetailRequest accountdetailRequest){
		System.out.println("#######"+accountdetailRequest.getAccno());
		Account account=getSession().get(Account.class, accountdetailRequest.getAccno());
		System.out.println("account details from getAccountdetails method"+account);
		AccountdetailResponse accountdetailResponse= new AccountdetailResponse();
		accountdetailResponse.setAccholdername(account.getAccholdername());
		accountdetailResponse.setBranch(account.getBranch().getBcode());
		accountdetailResponse.setOpendate(account.getOpendate());
		accountdetailResponse.setAccType(account.getAccType());
		accountdetailResponse.setAccBalance(account.getAccBalance());
		return accountdetailResponse;
		
	}
	
	@Override
	public CustomerResponse getCustomerdetails(CustomerRequest customerrequest) {
		Customer customer=getSession().get(Customer.class,customerrequest.getCustomerid());
		System.out.println("displaying customer details"+customer);
		
		CustomerResponse customerResponse=new CustomerResponse();
		customerResponse.setCustomerfname(customer.getCustomerfname());
		customerResponse.setCustomerlname(customer.getCustomerlname());
		customerResponse.setGender(customer.getGender());
		customerResponse.setMobile(customer.getMobile());
		customerResponse.setPassportid(customer.getCustomerid());
		return customerResponse;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
		
	}

	

	}