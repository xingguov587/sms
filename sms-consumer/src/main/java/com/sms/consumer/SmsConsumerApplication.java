package com.sms.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.sms.consumer.controller")
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class SmsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsConsumerApplication.class, args);
	}

}
