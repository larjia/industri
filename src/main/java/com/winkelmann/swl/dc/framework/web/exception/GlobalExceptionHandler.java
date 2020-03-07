package com.winkelmann.swl.dc.framework.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.winkelmann.swl.dc.common.exception.BaseException;
import com.winkelmann.swl.dc.framework.web.domain.AjaxResult;

/**
 * 全局异常处理器
 * @author Administrator
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 基础异常
	 */
	@ExceptionHandler(BaseException.class)
	public AjaxResult baseException(BaseException e)
	{
		return AjaxResult.error(e.getMessage());
	}
}
