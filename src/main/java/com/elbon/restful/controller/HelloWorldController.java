package com.elbon.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elbon.restful.model.HelloWorldBean;

@RestController
@RequestMapping("rest")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "v1/hello-world")
	public String getHelloWorld() {
		return "v1 - Hello World";
	}

	@GetMapping("v2/hello-world")
	public String getHelloWorldV2() {
		return "v2 - Hello World";
	}

	@GetMapping("hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping("hello-world/path-variable/{name}")
	public HelloWorldBean getHelloWorld(@PathVariable String name) {
		return new HelloWorldBean("Hello World, " + name);
	}
}
