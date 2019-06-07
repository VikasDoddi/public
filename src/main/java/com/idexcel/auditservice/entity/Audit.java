package com.idexcel.auditservice.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Audit {

	private String apiPath;
	private String apiMethod;
	private int apiResponseCode;
	private Date apiDate;
	
	public Audit(String apiPath, String apiMethod, int apiResponseCode) {
		this.apiPath = apiPath;
		this.apiMethod = apiMethod;
		this.apiResponseCode = apiResponseCode;
		this.apiDate = new Date();
	}
}
