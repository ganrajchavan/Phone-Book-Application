package com.GaneshIT.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("app1")
public class AppProps {

	private Map<String,String> message=new HashMap<String,String>();

	public Map<String,String> getMessage() {
		return message;
	}
	public void setMessage() {
		this.message =message;
	}
	
}
