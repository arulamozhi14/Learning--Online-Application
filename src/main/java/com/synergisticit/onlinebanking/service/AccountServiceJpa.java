package com.synergisticit.onlinebanking.service;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.onlinebanking.domain.Account;
import com.synergisticit.onlinebanking.repository.AccountRepository;

@Service(value="accountServiceJpa")
public class AccountServiceJpa implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void save(Account acc) {
		System.out.println("using service jpa to save details");
		accountRepository.save(acc);
	}
	

	@Override
	public List<Account> findAllAccount() {
		System.out.println("list all account holders from JPA respository");
		
		return accountRepository.findAll();

	}
/*	@Transactional//(propagation=Propagation.REQUIRED)
	public double deposit(long accno,double accBalance){
		
		 Optional<Account>opAcc=accountRepository.findById(accno);
		 Account account = opAcc.get();
		 System.out.println("@@@@ CHECK account"+account);
		 Account acc=new Account();
		 acc.setAccno(acc.getAccno());
		 double balance=account.getAccBalance()+accBalance;
		 acc.setAccBalance(balance);
		acc.setAccholdername(account.getAccholdername());
		acc.setAccType(account.getAccType());
		acc.setBranch(account.getBranch());
		acc.setOpendate(account.getOpendate());
		acc.setTransactions(account.getTransactions());
		 accountRepository.save(acc);
		 accountRepository.flush();
		 System.out.println("@@@@ CHECK"+acc);
		 return balance;
		
	}*/
	
	@Override
	public void updateById(long accno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long accno) {
		// TODO Auto-generated method stub
		 accountRepository.deleteById(accno);
		
	}

	@Override
	public Account getById(long accno) {
		// TODO Auto-generated method stub
		return accountRepository.getOne(accno);
	}

	

	@Override
	public boolean exists(long accno) {
		// TODO Auto-generated method stub
		return accountRepository.existsById(accno);
	}


	@Override
	public ModelAndView downloadPdf() {
		// TODO Auto-generated method stub
		return new ModelAndView("AccountPdfView","account",accountRepository.findAll());
	}


	


}
