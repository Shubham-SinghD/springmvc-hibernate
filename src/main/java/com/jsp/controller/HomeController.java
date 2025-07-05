package com.jsp.controller;


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
	  @PostMapping("/add")
	  public ResponseEntity<String> addUser(@RequestBody ReqData cust) {
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try {
	          tx = session.beginTransaction();
	          session.save(cust);  
	          tx.commit();
	          return new ResponseEntity<>("User added: " + cust.getAppid(), HttpStatus.CREATED);
	      } catch (Exception e) {
	          if (tx != null) tx.rollback();
	          return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      } finally {
	          session.close();
	      }
	  }

}
