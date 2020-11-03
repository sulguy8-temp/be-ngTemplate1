package com.ng.temp1.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

	@Resource
	private AuthInterceptor adminInterceptor;

	@Value("${allrowed.origins}")
	private String allrowedOrigins;

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().indexOf("window")!=-1) {
			config.addAllowedOrigin("http://localhost");
			config.addAllowedOrigin("http://localhost:4200");
			config.addAllowedOrigin("https://localhost");
			config.addAllowedOrigin("https://localhost:4200");
		}
		String[] origins = allrowedOrigins.split(",");
		for(String origin:origins) {
			config.addAllowedOrigin(origin);
		}
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminInterceptor)
		.excludePathPatterns("/**/*.css","/**/*.js")
		.excludePathPatterns("/test")
		.excludePathPatterns("/login/user")
		.addPathPatterns("/**"); 
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
