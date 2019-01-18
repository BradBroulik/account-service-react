package com.example.account.controller;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;

@RestController
public class AccountController {

	@GetMapping("/accounts")
	@ResponseStatus(HttpStatus.OK)
	Flux<Account> getAccounts() {
//		return Flux.fromIterable(getAccountsData())
//				   .delaySubscription(Duration.ofMillis(200));
		
		return Flux.just(
					new Account("1", "Async"),
					new Account("2", "Bran"),
					new Account("3", "Jon")
			   ).delaySubscription(Duration.ofMillis(200));
	}
	
//	private List<Account> getAccountsData() {
//		ConfigurationPropertySource sources = new MapConfigurationPropertySource(getAccountsYaml());
//		return new Binder(sources).bind("accounts", Bindable.listOf(Account.class)).get();
//	}
//
//	private Properties getAccountsYaml() {
//		YamlPropertiesFactoryBean properties = new YamlPropertiesFactoryBean();
//		properties.setResources(new ClassPathResource("accounts.yml"));
//		return properties.getObject();
//	}
}
