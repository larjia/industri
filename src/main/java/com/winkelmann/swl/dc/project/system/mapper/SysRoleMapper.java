package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysRole;

/**
 * 角色表
 * @author Administrator
 *
 */
public interface SysRoleMapper
{
	// 根据条件分页查询角色数据
	public List<SysRole> selectRoleList(SysRole role);
	// 根据用户Id查询角色
	public List<SysRole> selectRolePermissionByUserId(Long userId);
	// 查询所有角色
	public List<SysRole> selectRoleAll();
	// 根据用户Id获取角色选择框列表
	public List<Integer> selectRoleListByUserId(Long userId);
	// 通过角色Id查询角色
	public SysRole selectRoleById(Long roleId);
	// 通过用户Id查询角色
	public List<SysRole> selectRolesByUserName(String userName);
	// 校验角色名称是否唯一
	public SysRole checkRoleNameUnique(String roleName);
	// 校验角色权限是否唯一
	public SysRole checkRoleKeyUnique(String roleKey);
	// 修改角色信息
	public int updateRole(SysRole role);
	// 新增角色信息
	public int insertRole(SysRole role);
	// 通过角色Id删除角色
	public int deleteRoleById(Long roleId);
	// 批量删除角色信息
	public int deleteRoleByIds(Long[] roleIds);
}
