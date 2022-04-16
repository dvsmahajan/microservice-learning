package com.dvsmahajan.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder
				.routes()
				.route(p -> p.path("/get")
							.filters(f->f.addRequestHeader("MyCustHeader", "HEADER").addRequestParameter("PARAM", "ONE"))	
							.uri("http://httpbin.org:80"))
				.route(p-> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p-> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
//				.route(p-> p.path("/currency-exchange-new/**")
//						.filters(r->r.rewritePath("/currency-exchange-new/(?<segment>.*)", "/currency-exchange/feign/${segment}"))
//						.uri("lb://currency-exchange"))
				.build();
	}

	
}
