package com.idexcel.auditservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MongoInfo {

	private String mongoHost;
	private String mongoPort;
	private String mongoDatabase;
	
	public MongoInfo(String  mongoHost, String mongoPort, String mongoDatabase) {
		this.mongoHost = mongoHost;
		this.mongoPort = mongoPort;
		this.mongoDatabase = mongoDatabase;
	}
	
}
