package com.synergisticit.onlinebanking.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.onlinebanking.domain.Account;
import com.synergisticit.onlinebanking.domain.Transaction;

public interface AccountService {
	public void save(Account acc);
	public void updateById(long accno);
	public void deleteById(long accno);
	public Account getById(long accno);
	
	public ModelAndView downloadPdf();
	public boolean exists(long accno);
	public List<Account> findAllAccount();
	//public Account findById(long accno);
	//public double deposit(long accno,double accBalance);


	
	

}
