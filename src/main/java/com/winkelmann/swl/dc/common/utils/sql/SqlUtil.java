package com.winkelmann.swl.dc.common.utils.sql;

import com.winkelmann.swl.dc.common.utils.StringUtils;

/**
 * sql操作工具类
 * @author JiangL
 *
 */
public class SqlUtil
{
	/**
	 * 仅支持字母、数字、下划线、空格、逗号(支持多个字段排序)
	 */
	public static String SQL_PATTERN = "[a-zA-Z0-9_\\\\ \\\\,]+";
	
	/**
	 * 检查字符,防止注入绕过
	 */
	public static String escapeOrderBySql(String value)
	{
		if (StringUtils.isNotNull(value) && !isValidOrderBySql(value))
		{
			return StringUtils.EMPTY;
		}
		return value;
	}
	
	/**
	 * 验证order by语法是否符合规范
	 */
	public static boolean isValidOrderBySql(String value)
	{
		return value.matches(SQL_PATTERN);
	}
}
