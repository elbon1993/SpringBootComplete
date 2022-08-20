package com.elbon.restful.controller;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingTask {

	@Scheduled(cron="0 41/1 20 * * ?")
	public void showTime() {
		System.out.println(LocalDateTime.now().toString());
	}
}
