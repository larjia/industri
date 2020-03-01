package com.winkelmann.swl.dc.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色和菜单关联表 sys_role_menu
 * @author Administrator
 *
 */
public class SysRoleMenu
{
	// 角色Id
	private Long roleId;
	// 菜单Id
	private Long menuId;
	
	public Long getRoleId()
	{
		return roleId;
	}
	
	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}
	
	public Long getMenuId()
	{
		return menuId;
	}
	
	public void setMenuId(Long menuId)
	{
		this.menuId = menuId;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("roleId", getRoleId())
				.append("menuId", getMenuId())
				.toString();
	}
}
