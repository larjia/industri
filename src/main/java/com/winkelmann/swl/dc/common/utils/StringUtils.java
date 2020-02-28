package com.winkelmann.swl.dc.common.utils;

/**
 * 字符串工具类
 * @author JiangL
 *
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils
{
	// 空字符串
	private static final String NULLSTR = "";
	// 下划线
	private static final char SEPARATOR = '_';
	
	/**
	 * 判断一个Collection是否为空,包含List, Set, Queue
	 */
	
	/**
	 * 判断一个字符串是否为空
	 * @param str String
	 * @return true: 为空 false: 非空
	 */
	public static boolean isEmpty(String str)
	{
		return isNull(str) || NULLSTR.equals(str.trim());
	}
	
	/** 
	 * 判断一个对象是否为空
	 * @param object Object
	 * @return true: 为空  false: 非空
	 */
	public static boolean isNull(Object object)
	{
		return object == null;
	}
	
	/** 
	 * 判断一个对象是否非空
	 * @param object Object
	 * @return true: 非空  false: 为空
	 */
	public static boolean isNotNull(Object object)
	{
		return !isNull(object);
	}
	
    /**
     * 下划线转驼峰命名
     */
    public static String toUnderScoreCase(String str)
    {
        if (str == null)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase = true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase = true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (i > 0)
            {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            }
            else
            {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1))
            {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
}
