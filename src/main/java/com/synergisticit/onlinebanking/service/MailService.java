package com.synergisticit.onlinebanking.service;

import java.io.ByteArrayOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.synergisticit.onlinebanking.domain.Account;


@Service
public class MailService {

	@Autowired
	JavaMailSender mailSender;


	public void sendMail(String mailTo, String subject, String body,Account account) throws MessagingException, DocumentException {
		System.out.println("###### from mailservice");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo(mailTo);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);
		mailSender.send(simpleMailMessage);
		
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeBodyPart mimeBodyPartTest = new MimeBodyPart();
		mimeBodyPartTest.setText("Hello, you have created an Account");
		
		//writePdf(outputStream, account);
		
		byte [] bytes = outputStream.toByteArray();
		DataSource dataSource = new ByteArrayDataSource(bytes,"application/pdf");
		MimeBodyPart mimeBodyPartPdf = new MimeBodyPart();
		mimeBodyPartPdf.setDataHandler(new DataHandler(dataSource));
		
		MimeMultipart mimeMultiPart = new MimeMultipart();
		mimeMultiPart.addBodyPart(mimeBodyPartTest);
		mimeMultiPart.addBodyPart(mimeBodyPartPdf);
		
		mimeMessage.setContent(mimeMultiPart);
		mimeMessage.setSender(new InternetAddress("synergisticitsessionusc11@gmail.com"));
		mimeMessage.setSubject(subject);
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
		mailSender.send(mimeMessage);
	}
	//FOR MAKING DOCU AS PDF DOCUMENTS
	public void writePdf(ByteArrayOutputStream outputStream, Account account) throws DocumentException	{
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream); //get pdf writer
		document.open();
		document.addTitle("Account Information");
		Paragraph paragraph = new Paragraph("Account Information");
		
		document.add(paragraph); 
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
		
		cell = new Cell("branch");
		table.addCell(cell);
		
		
			table.addCell(""+account.getAccno());
			table.addCell(""+account.getAccType());
			table.addCell(""+account.getAccholdername());
			table.addCell(""+account.getAccBalance());
			table.addCell(""+account.getBranch());
			table.addCell(""+account.getOpendate());
		
		
		document.add(table);
		document.close();
	}
	}

