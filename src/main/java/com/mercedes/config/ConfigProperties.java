package com.mercedes.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring")
public class ConfigProperties {

	public Map<String,String> config= new HashMap<>();

	public Map<String, String> getConfig() {
		return config;
	}
}
