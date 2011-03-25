package com.fbduel.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fbduel.sample.SessionFactoryHelper;
import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

public class Main {

	public static void main(String[] args) throws IOException {

		final String baseUri = "http://localhost:9998/";
		final Map<String, String> initParams = new HashMap<String, String>();

		initParams.put("com.sun.jersey.config.property.packages",
				"com.fbduel.resources");
		
		System.out.println("Starting Hibernate");
		
		SessionFactoryHelper.getSessionFactory();
        
		System.out.println("Starting grizzly...");
		SelectorThread threadSelector = GrizzlyWebContainerFactory.create(
				baseUri, initParams);
		System.in.read();
		threadSelector.stopEndpoint();
		System.exit(0);
	}

}