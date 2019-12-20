package com.simplenotes.config;

import com.simplenotes.filter.GlobalErrorFilter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.List;

@Configuration
public class GlobalGatewayConfig {
	
	@Bean
	public ErrorWebExceptionHandler errorWebExceptionHandler(ObjectProvider<List<ViewResolver>> viewResolversProvider,
	                                                         ServerCodecConfigurer serverCodecConfigurer) {
		return new GlobalErrorFilter();
	}
}
