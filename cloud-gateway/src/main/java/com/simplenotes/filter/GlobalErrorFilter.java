package com.simplenotes.filter;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


public class GlobalErrorFilter implements ErrorWebExceptionHandler {
	
	@Override
	public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
		System.out.println(exchange);
		return null;
	}

}
