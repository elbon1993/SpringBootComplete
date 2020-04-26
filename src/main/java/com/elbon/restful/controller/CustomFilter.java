package com.elbon.restful.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter {

	Logger logger = LoggerFactory.getLogger(CustomFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("Custom Filter started running....");
		logger.info("Request \nremote address:"+request.getRemoteAddr()+"\nhost:"+request.getRemoteHost()+"\nserver:"+request.getServerName()+"\ncontext path:"+request.getServletContext().getContextPath());
		
		chain.doFilter(request, response);
		
		logger.info("Custom Filter processed request...");
	}
}
