package com.synergisticit.onlinebanking.view;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import com.synergisticit.onlinebanking.domain.Account;
public class AccountCsvView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		buildCsvDocument(model, request, response);
	
	}

	
	private void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		System.out.println("$$$$$$$$$ from csv class");
		List<Account> accountList = (List<Account>) model.get("accountList");
		//System.out.println("$$$$$$$$$ from csv class"+accountList);
		String[] header = {"accno","accType","accholdername","opendate","accBalance","branch"};
		csvWriter.writeHeader(header);
		for(Account account : accountList) {
			csvWriter.write(account, header);
		}
		csvWriter.close();
		
	}
	
}
