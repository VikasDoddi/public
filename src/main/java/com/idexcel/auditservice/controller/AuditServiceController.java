package com.idexcel.auditservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idexcel.auditservice.entity.Audit;
import com.idexcel.auditservice.entity.MongoInfo;

@RestController
@RequestMapping("/praveen")
public class AuditServiceController {
	
	@Autowired
	private Environment env;

	@GetMapping("/audits")
	public List<Audit> getAudits() {
		List<Audit> audits = new ArrayList<Audit>();
		Audit audit1 = new Audit("/vikas/lenders", "GET", 200);
		Audit audit2 = new Audit("/praveen/lenders", "POST", 201);
		audits.add(audit1);
		audits.add(audit2);
		return audits;
	}
	
	@GetMapping("/mongo")
	public MongoInfo getMongoInfo() {
		return new MongoInfo(env.getProperty("mongodb.host"), env.getProperty("mongodb.port"), env.getProperty("mongodb.database"));
	}
}
