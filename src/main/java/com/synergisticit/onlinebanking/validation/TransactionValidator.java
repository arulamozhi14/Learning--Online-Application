package com.synergisticit.onlinebanking.validation;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.onlinebanking.domain.Transaction;
import com.synergisticit.onlinebanking.service.AccountService;
import com.synergisticit.onlinebanking.service.TransactionService;

@Component
public class TransactionValidator implements Validator  {
//	private Pattern pattern;
//	private Matcher matcher;
//	private static final String DATE_PATTERN="((?:19|20)\\d\\d)/(0?[1-9]|1[012])/([12][0-9]|3[01]|0?[1-9])";
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AccountService accountService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Transaction.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Transaction transaction=(Transaction)obj;

		//VALIDATING EXIST ACCOUNT NUMBER //FROM ACCOUNT
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromAccount", "transaction.fromAccount.value", "fromAccount is required.");
		if(!accountService.exists(transaction.getFromAccount())){
			System.out.println(transaction.getFromAccount());
			errors.rejectValue("fromAccount", "transaction.fromAccount.value", "fromAccount id not  exists");
		}
		//VALIDATING TOACCOUNT
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toAccount", "transaction.toAccount.value", "toAccount is required.");
		if(!accountService.exists(transaction.getToAccount())){
			System.out.println(transaction.getToAccount());
			errors.rejectValue("toAccount", "transaction.toAccount.value", "toAccount id not  exists");
		}
		
//		//VALIDATING DATE
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "txdate", "transaction.txdate.value", "todays date is required not future date");
//
//		if(isValidDatefuture(transaction.getTxdate())){
//			errors.rejectValue("txdate", "transaction.txdate.value", "todays date is required not future date");		}
//
//	
//}
//	
//		public boolean isValidDatefuture(Date value){
//			  Calendar calendar = Calendar.getInstance(); 
//		        calendar.set(Calendar.HOUR_OF_DAY, 0);
//		        calendar.set(Calendar.MINUTE, 0);
//		        calendar.set(Calendar.SECOND, 0);
//		        Date today = calendar.getTime();
//		        System.out.println("today future date"+today);
//		        System.out.println("@@@@@" +value.after(today));
//			return value.after(today);
//		}
	
	}
}



