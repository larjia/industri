package com.winkelmann.swl.dc.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户和角色关联 sys_user_role
 * @author Administrator
 *
 */
public class SysUserRole
{
	// 用户Id
	private Long userId;
	// 角色Id
	private Long roleId;
	
	public Long getUserId()
	{
		return userId;
	}
	
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
	
	public Long getRoleId()
	{
		return roleId;
	}
	
	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("userId", getUserId())
				.append("roleId", getRoleId())
				.toString();
	}
}
