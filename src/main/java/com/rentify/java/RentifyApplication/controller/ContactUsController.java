package com.rentify.java.RentifyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentify.java.RentifyApplication.entity.RentifyContactModel;
import com.rentify.java.RentifyApplication.entity.RentifyContactPageModel;
import com.rentify.java.RentifyApplication.entity.RentifyQueryModel;
import com.rentify.java.RentifyApplication.entity.VstlContactModel;
import com.rentify.java.RentifyApplication.entity.VstlQuoteModel;
import com.rentify.java.RentifyApplication.service.EmailService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ContactUsController {
	
	private EmailService emailService;
	
	@Autowired
	public ContactUsController(EmailService emailService) {
		super();
		this.emailService = emailService;
	}


	@PostMapping(value = "/sendemail")
	public ResponseEntity<String> configureResponseAndSendEmail(@RequestBody RentifyContactModel bodyData)
	{
		if(bodyData.getEmailAddress() != null && bodyData.getMessage()!=null)
		{
			try {
			emailService.sendMail(bodyData);
			}
			catch (Exception e) {
				return new ResponseEntity<>("Exception Occoured",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
			return new ResponseEntity<>("Data not filled Properly",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Email Sent", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/rentifyConfiguration")
	public ResponseEntity<String> acceptConfigurationAndSendEmail(@RequestBody RentifyQueryModel bodyData)
	{
		if(bodyData.getEmailAddress() != null && bodyData.getPhoneNo()!=null)
		{
			try {
			emailService.sendMail(bodyData.getEmailAddress(), bodyData);
			}
			catch (Exception e) {
				return new ResponseEntity<>("Exception Occured",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
			return new ResponseEntity<>("Data not filled Properly",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Email Sent", HttpStatus.CREATED);
	}

	
	@PostMapping(value = "/rentifycontact")
	public ResponseEntity<String> acceptContactAndSendEmail(@RequestBody RentifyContactPageModel bodyData)
	{
		if(bodyData.getEmailAddress() != null && bodyData.getTelephone()!=null)
		{
			try {
			emailService.sendMail(bodyData.getEmailAddress(), bodyData);
			}
			catch (Exception e) {
				return new ResponseEntity<>("Exception Occured",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
			return new ResponseEntity<>("Data not filled Properly",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Email Sent", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/vstlcontact")
	public ResponseEntity<String> acceptContactAndSendEmail(@RequestBody VstlContactModel bodyData)
	{
		if(bodyData.getEmail() != null && bodyData.getPhone()!=null)
		{
			try {
			emailService.sendMail(bodyData.getEmail(), bodyData);
			}
			catch (Exception e) {
				return new ResponseEntity<>("Exception Occured",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
			return new ResponseEntity<>("Data not filled Properly",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Email Sent", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/vstlQuote")
	public ResponseEntity<String> vstlQuote(@RequestBody VstlQuoteModel bodyData)
	{
		if(bodyData.getEmail() != null && bodyData.getPhone()!=null)
		{
			try {
			emailService.sendMail(bodyData.getEmail(), bodyData);
			}
			catch (Exception e) {
				return new ResponseEntity<>("Exception Occured",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
			return new ResponseEntity<>("Data not filled Properly",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Email Sent", HttpStatus.CREATED);
	}


	
}
