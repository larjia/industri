package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysRoleMenu;

public interface SysRoleMenuMapper
{
	// 查询菜单使用数量
	public int checkMenuExistRole(Long menuId);
	// 通过角色Id删除角色和菜单关联
	public int deleteRoleMenuByRoleId(Long roleId);
	// 批量新增角色菜单信息
	public int batchRoleMenu(List<SysRoleMenu> roleMenuList);
}
