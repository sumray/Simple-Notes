package com.simplenotes.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;


public class GlobalErrorFilter extends DefaultErrorWebExceptionHandler {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public GlobalErrorFilter(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
	                            ErrorProperties errorProperties, ApplicationContext applicationContext) {
		super(errorAttributes, resourceProperties, errorProperties, applicationContext);
	}

	/**
	 * 获取异常属性
	 */
	@Override
	protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
		Throwable error = super.getError(request);
		logger.error(error.getMessage(), error);
		int code = 500;
		if (error instanceof org.springframework.cloud.gateway.support.NotFoundException) {
			code = 404;
		}
		return response(code, this.buildMessage(request, error));
	}

	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
		return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
	}

	@Override
	protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
		int statusCode = (int) errorAttributes.get("code");
		return HttpStatus.valueOf(statusCode);
	}

	private String buildMessage(ServerRequest request, Throwable ex) {
		StringBuilder message = new StringBuilder("Failed to handle request [");
		message.append(request.methodName());
		message.append(" ");
		message.append(request.uri());
		message.append("]");
		if (ex != null) {
			message.append(": ");
			message.append(ex.getMessage());
		}
		return message.toString();
	}

	public static Map<String, Object> response(int status, String errorMessage) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", status);
		map.put("msg", errorMessage);
		map.put("data", null);
		return map;
	}

}
