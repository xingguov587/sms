package com.sms.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.sms.provider.dao")
@RefreshScope
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class SmsProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsProviderApplication.class, args);
	}

}
