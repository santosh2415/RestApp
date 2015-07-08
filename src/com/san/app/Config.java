package com.san.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
@ApplicationPath("/api")

public class Config extends ResourceConfig {
	public Config()
	{
		System.out.println(" In config redirecting");
		packages("com.san.rest");
	}

}
