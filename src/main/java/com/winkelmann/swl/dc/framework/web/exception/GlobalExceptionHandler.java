package com.winkelmann.swl.dc.framework.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.winkelmann.swl.dc.common.constant.HttpStatus;
import com.winkelmann.swl.dc.common.exception.BaseException;
import com.winkelmann.swl.dc.common.exception.CustomException;
import com.winkelmann.swl.dc.common.exception.DemoModeException;
import com.winkelmann.swl.dc.common.utils.StringUtils;
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
	
	/**
	 * 业务异常
	 */
	@ExceptionHandler(CustomException.class)
	public AjaxResult businessException(CustomException e)
	{
		if (StringUtils.isNull(e.getCode()))
		{
			return AjaxResult.error(e.getMessage());
		}
		return AjaxResult.error(e.getCode(), e.getMessage());
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public AjaxResult handlerNotFoundException(Exception e)
	{
		log.error(e.getMessage(), e);
		return AjaxResult.error(HttpStatus.NOT_FOUND, "路径不存在,请检查路径是否正确");
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public AjaxResult handleAuthorizationException(AccessDeniedException e)
	{
		log.error(e.getMessage());
		return AjaxResult.error(HttpStatus.FORBIDDEN, "没有权限,请联系管理员授权");
	}
	
	@ExceptionHandler(AccountExpiredException.class)
	public AjaxResult handleAccountExpiredException(AccessDeniedException e)
	{
		log.error(e.getMessage(), e);
		return AjaxResult.error(e.getMessage());
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public AjaxResult handleUsernameNotFoundException(UsernameNotFoundException e)
	{
		log.error(e.getMessage(), e);
		return AjaxResult.error(e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public AjaxResult handleExcetion(Exception e)
	{
		log.error(e.getMessage(), e);
		return AjaxResult.error(e.getMessage());
	}
	
	/**
	 * 自定义验证异常
	 */
	@ExceptionHandler(BindException.class)
	public AjaxResult validateBindException(BindException e)
	{
		log.error(e.getMessage(), e);
		String message = e.getAllErrors().get(0).getDefaultMessage();
		return AjaxResult.error(message);
	}
	
	/**
	 * 自定义验证异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object validExceptionHandler(MethodArgumentNotValidException e)
	{
		log.error(e.getMessage(), e);
		String message = e.getBindingResult().getFieldError().getDefaultMessage();
		return AjaxResult.error(message);
	}
	
	/**
	 * 演示模式异常
	 */
	@ExceptionHandler(DemoModeException.class)
	public AjaxResult demoModeException(DemoModeException e)
	{
		return AjaxResult.error("演示模式,不允许操作");
	}
}
