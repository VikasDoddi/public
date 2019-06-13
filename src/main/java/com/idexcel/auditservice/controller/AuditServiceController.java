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
import com.amazonaws.auth.AWSCredentialsProvider;                                                                   
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;

import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;

@RestController
@RequestMapping("/praveen")
public class AuditServiceController {
	
	@Autowired
	private Environment env;

	@GetMapping("/audits")
	public List<Audit> getAudits() {
		List<Audit> audits = new ArrayList<Audit>();
		String env = System.getenv("ENVIRONMENT");
		if (env == null) {
			env = "dev";
		}
		Audit audit1 = new Audit("/praveen-" + env + "/lenders", "GET", 200);
		Audit audit2 = new Audit("/praveen-" + env + "/lenders", "POST", 201);
		audits.add(audit1);
		audits.add(audit2);
		return audits;
	}
	
	@GetMapping("/mongo")
	public MongoInfo getMongoInfo() {
		return new MongoInfo(
				getParameterFromSSMByName(System.getenv("ENVIRONMENT") + "/vikasApp/mongoHost"), 
				getParameterFromSSMByName(System.getenv("ENVIRONMENT") + "/vikasApp/mongoUsername"), 
				getParameterFromSSMByName(System.getenv("ENVIRONMENT") + "/vikasApp/mongoPassword"));
	}
	private String getParameterFromSSMByName(String parameterKey) {
    		AWSCredentialsProvider credentials = InstanceProfileCredentialsProvider.getInstance();
        AWSSimpleSystemsManagement simpleSystemsManagementClient = 
        		(AWSSimpleSystemsManagement)((AWSSimpleSystemsManagementClientBuilder)((AWSSimpleSystemsManagementClientBuilder)AWSSimpleSystemsManagementClientBuilder.standard().withCredentials(credentials)).withRegion("us-east-1")).build();

        GetParameterRequest parameterRequest = new GetParameterRequest();
        parameterRequest.withName(parameterKey).setWithDecryption(Boolean.valueOf(true));
        GetParameterResult parameterResult = simpleSystemsManagementClient.getParameter(parameterRequest);
        return parameterResult.getParameter().getValue();
    }
}
