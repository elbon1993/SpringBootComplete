package com.elbon.restful.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest-template")
public class RestTemplateController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/users", produces="application/json")
	public ResponseEntity<Object> getEmployees() {
	
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return new ResponseEntity<Object>(restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET, entity, String.class).getBody(), HttpStatus.OK);
	}
}
