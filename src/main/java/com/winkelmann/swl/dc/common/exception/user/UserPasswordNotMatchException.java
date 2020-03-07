package com.winkelmann.swl.dc.common.exception.user;

/**
 * 用户密码不正确或不符合
 * @author Administrator
 *
 */
public class UserPasswordNotMatchException extends UserException
{
	private static final long serialVersionUID = 1L;
	
	public UserPasswordNotMatchException()
	{
		super("user.password.not.match", null);
	}
}
