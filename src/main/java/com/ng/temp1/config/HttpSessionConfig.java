
package com.ng.temp1.config;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpSessionConfig implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setMaxInactiveInterval(60 * 60);
	}

	@Bean
	public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty("resource.loader", "class");
		ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		ve.setProperty("input.encoding", "UTF-8");
		ve.setProperty("output.encoding", "UTF-8");
		ve.setProperty("response.encoding", "UTF-8");
		return ve;
	}
}
