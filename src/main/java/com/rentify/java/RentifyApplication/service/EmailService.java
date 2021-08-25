package com.rentify.java.RentifyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentify.java.RentifyApplication.entity.RentifyContactModel;
import com.rentify.java.RentifyApplication.entity.RentifyContactPageModel;
import com.rentify.java.RentifyApplication.entity.RentifyQueryModel;
import com.rentify.java.RentifyApplication.entity.VstlContactModel;
import com.rentify.java.RentifyApplication.entity.VstlQuoteModel;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    
    @Value("${flybunch.email}")
    private String email;

    
    @Value("${rentify.email}")
    private String rentifyEmail;
    
    
    @Value("${vstl.email}")
    private String vstlEmail;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(RentifyContactModel model) {

    	SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Flybunch Query");
        mailMessage.setText("First Name : "+model.getFirstname()+"\n"+"Last Name : "+model.getLastname()+"\n"+"Contact : "+model.getContact()+"\n"+"Customer email : "+model.getEmailAddress()+"\n"+"Message : "+model.getMessage()+"\n \n Regards \n Team Flybunch");
        javaMailSender.send(mailMessage);
    }
    
    public void sendMail(String toEmail, RentifyQueryModel model) {

    	SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(rentifyEmail);
        mailMessage.setSubject("Rentify Query");
        mailMessage.setText("Name : "+model.getName()==null?"":model.getName()+"\n"+"Customer email : "+toEmail+"\n"+"Product Type : "+model.getProductType()+"\n"+"Configuration : "+model.getConfiguration()+"\n"+"Duration : "+model.getDuration()+"\n"+"Contact No. : "+model.getPhoneNo()+"\n"+"Hard Disk : "+model.getHardDisk()+"\n"+"Ram Size : "+model.getRam()+"\n"+"Quantity : "+model.getQuantity()+" \n \n Resgards \n Team Flybunch");
        javaMailSender.send(mailMessage);
    }
    public void sendMail(String toEmail, RentifyContactPageModel model) {

    	SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(rentifyEmail);
        mailMessage.setSubject("Rentify Contact Query");
        mailMessage.setText("Name : "+model.getSenderName()==null?"":model.getSenderName()+"\n"+"Customer email : "+toEmail+"\n"+"Message : "+model.getSenderMessage()+"\n"+"Subject : "+model.getSenderSubject()+"\n"+"Customer Contact No. : "+model.getTelephone()+"\n \n Regards \n Team Flybunch");
        javaMailSender.send(mailMessage);
    }
    
    public void sendMail(String toEmail, VstlContactModel model) {

    	SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(vstlEmail);
        mailMessage.setSubject("Vstl Contact Query");
        mailMessage.setText("Name : "+model.getName()==null?"":model.getName()+"\n"+"Customer email : "+toEmail+"\n"+"question: "+model.getQuestion()+"\n"+"Subject : "+model.getSubject()+"\n"+"Customer Contact No. : "+model.getPhone()+"\n \n Regards \n Team Flybunch");
        javaMailSender.send(mailMessage);
    }
    
    public void sendMail(String toEmail, VstlQuoteModel model) {
    	SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(vstlEmail);
        mailMessage.setSubject("VSTL quote Query");
        mailMessage.setText("Name : "+model.getName()==null?"":model.getName()+"\n"+"Customer email : "+toEmail+"\n"+"Contact No. : "+model.getPhone()+"\n"+"Company Name : "+model.getCompany()+"\n"+"Item : "+model.getItem()+"\n"+"Other : "+model.getOther()+"\n"+"Quantity : "+model.getQuantity()+"\n"+" \n \n Resgards \n Team Flybunch");
        javaMailSender.send(mailMessage);
    }
    
    
    public static void main(String[] args) {
    	VstlContactModel contactModel = new VstlContactModel();
    	contactModel.setEmail("anuragpundir621@gmail.com");
    	contactModel.setName("Anurag Pundir");
    	contactModel.setPhone("987789987");
    	contactModel.setQuestion("how");
    	contactModel.setSubject("query");
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			System.out.println(mapper.writeValueAsString(contactModel));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}