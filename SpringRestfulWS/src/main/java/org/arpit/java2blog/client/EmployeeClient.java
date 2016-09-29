package org.arpit.java2blog.client;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeClient {

	public static void main(String args[]) {

		
		
		final String uri = "http://localhost:8280/SpringRestfulWS/createEmployee/SID/AKULA";
//		final String uri = "http://localhost:8280/SpringRestfulWS/delete/13";
		System.out.println(uri);
		
		String plainCreds = "OM:BOSS";
//		String plainCreds = "SUNDEEP:TEST123";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		
		System.out.println(base64Creds);
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
	    headers.add("Authorization", "Basic " + base64Creds);
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    System.out.println(entity);
	    
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		System.out.println(result);

	}

}
