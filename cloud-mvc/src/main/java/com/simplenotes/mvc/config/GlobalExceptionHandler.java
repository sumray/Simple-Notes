package com.simplenotes.mvc.config;

import com.simplenotes.exception.BaseException;
import com.simplenotes.mvc.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(RuntimeException.class)
	public ResultMessage runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
		logger.error(e.getMessage(), e);
		RuntimeException exception = (RuntimeException) e;
		return ResultMessage.fail(exception.getMessage());
	}

	@ExceptionHandler(BaseException.class)
	public ResultMessage baseExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
		logger.error(e.getMessage(), e);
		RuntimeException exception = (RuntimeException) e;
		return ResultMessage.fail(exception.getMessage());
	}
}
