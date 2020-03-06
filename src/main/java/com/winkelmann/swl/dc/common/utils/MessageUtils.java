package com.winkelmann.swl.dc.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.winkelmann.swl.dc.common.utils.spring.SpringUtils;

/**
 * 获取i18n资源文件
 * @author Administrator
 *
 */
public class MessageUtils
{
	/**
	 * 根据消息键和参数 获取消息 委托给spring
	 */
	public static String message(String code, Object... args)
	{
		MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}
}
