package com.elbon.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalizationController {

	@Autowired
	MessageSource messageSource;
	
	@GetMapping("i18n")
	public String getMessage() {
		return messageSource.getMessage("wishes.goodmorning", null, LocaleContextHolder.getLocale());
	}
}
