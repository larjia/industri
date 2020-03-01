package com.winkelmann.swl.dc.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户和岗位关联 sys_user_post
 * @author Administrator
 *
 */
public class SysUserPosition
{
	// 用户Id
	private Long userId;
	// 岗位Id
	private Long positionId;
	
	public Long getUserId()
	{
		return userId;
	}
	
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
	
	public Long getPositionId()
	{
		return positionId;
	}
	
	public void setPositionId(Long positionId)
	{
		this.positionId = positionId;
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("userId", getUserId())
				.append("positionId", getPositionId())
				.toString();
	}
}
