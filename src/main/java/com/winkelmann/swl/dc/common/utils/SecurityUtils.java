package com.winkelmann.swl.dc.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.winkelmann.swl.dc.common.constant.HttpStatus;
import com.winkelmann.swl.dc.common.exception.CustomException;
import com.winkelmann.swl.dc.framework.security.LoginUser;

/**
 * 安全服务工具类
 * @author Administrator
 *
 */
public class SecurityUtils
{
	/**
	 * 获取用户账户
	 * @return
	 */
	public static String getUserName()
	{
		try
		{
			return getLoginUser().getUsername();
		}
		catch (Exception e)
		{
			throw new CustomException("获取用户账户异常", HttpStatus.UNAUTHORIZED);
		}
	}
	
	/**
	 * 获取用户
	 * @return
	 */
	public static LoginUser getLoginUser()
	{
		try
		{
			return (LoginUser) getAuthentication().getPrincipal();
		}
		catch (Exception e)
		{
			throw new CustomException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
		}
	}
	
	/**
	 * 获取Authentication
	 */
	public static Authentication getAuthentication()
	{
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	/**
	 * 生成BCryptPasswordEncoder密码
	 */
	public static String encryptPassword(String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
	
	/**
	 * 判断密码是否相同
	 */
	public static boolean matchesPassword(String rawPassword, String encodedPassword)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
	
	/**
	 * 是否为管理员
	 */
	public static boolean isAdmin(Long userId)
	{
		return userId != null && 1L == userId;
	}
}
