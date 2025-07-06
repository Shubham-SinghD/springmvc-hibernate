package com.jsp.controller;


import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.entity.ReqData;

@RestController
@RequestMapping("/api")
public class HomeController {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	  @PostMapping("/add")
	  public ResponseEntity<String> addUser(@RequestBody ReqData cust) {
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try {
	          tx = session.beginTransaction();
	          System.out.println(cust.getCustomer_dto().getCust_id());
	          
	          if(cust.getCustomer_dto().getCust_id().isBlank()||cust.getUser_dto().getUser_name()==null) {
	        	  throw new RuntimeException("Not Save");
	          }
	        Serializable save = session.save(cust); 

	          if(save!=null) {
	        	  tx.commit();
		          return new ResponseEntity<>("User added: " + cust.getAppid(), HttpStatus.CREATED);
	          }else {
	        	  tx.rollback();
	        	  return new ResponseEntity<>("User Added Fail : " + cust.getAppid(), HttpStatus.FAILED_DEPENDENCY);
	          }
	      } catch (Exception e) {
	          tx.rollback();
	          return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      } 
	  }

}
