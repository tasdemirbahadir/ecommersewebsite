package com.btasdemir.dmall.backoffice.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AppConfig {
	
	@Value("${application.environment}")
	private String environment;

}
