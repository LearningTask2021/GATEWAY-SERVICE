package com.iiht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
//@CrossOrigin(origins = "*")
public class ZullApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(ZullApiGateway.class, args);
	}
	
	 @Bean
	  public RoutingAndGatewayFilters simpleFilter() {
	    return new RoutingAndGatewayFilters();
	  }

	 
	 @Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("*").allowedOrigins("*").allowedMethods("*").allowedHeaders("Content-Type");
				}
			};
		}
	 
	/*	@Bean
		@Primary
	public CorsFilter corsFilter() {
		    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		    final CorsConfiguration config = new CorsConfiguration();
		    config.setAllowCredentials(true);
		    config.addAllowedOrigin("*");
		    config.addAllowedHeader("*");
		    config.addAllowedMethod("*");
		    source.registerCorsConfiguration("*", config);
		    return new CorsFilter(source);
		}*/
}
