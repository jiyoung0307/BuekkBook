package com.bukkeubook.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* CORS 허용을 위한 설정(반드시 필수는 아님) */
@Configuration
public class WebConfig implements WebMvcConfigurer{


	 @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	  }
	 
	 @Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins("*");							//모든 외부 리소스 허용
//					.allowedOrigins("http://127.0.0.1:8888","","");	// 특정 허용
		}
}
