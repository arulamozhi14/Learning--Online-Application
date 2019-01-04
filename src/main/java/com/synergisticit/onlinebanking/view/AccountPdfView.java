package com.synergisticit.onlinebanking.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.synergisticit.onlinebanking.domain.Account;
@Component
public class AccountPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("######## from pdf class");
		List<Account> accountList = (List<Account>) model.get("accountList");
		
		document.setPageSize(PageSize.A4);
		HeaderFooter header = new HeaderFooter(new Phrase("List of Accounts"), false);
		document.add(header);
		Table table = new Table(6);
		Cell cell = new Cell("accno");
		table.addCell(cell);
		
		cell = new Cell("accType");
		table.addCell(cell);
		
		cell = new Cell("accholdername");
		table.addCell(cell);
		
		cell = new Cell("opendate");
		table.addCell(cell);
		
		cell = new Cell("accBalance");
		table.addCell(cell);
		
		//cell = new Cell("branch");
		//table.addCell(cell);
		
		for(Account account : accountList) {
			table.addCell(""+account.getAccno());
			table.addCell(""+account.getAccType());
			table.addCell(""+account.getAccholdername());
			table.addCell(""+account.getAccBalance());
			table.addCell(""+account.getOpendate());
			//table.addCell(""+account.getBranch());
			
		}
		
		document.add(table);
	}

	
}
