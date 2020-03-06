package com.winkelmann.swl.dc.project.system.service;

import java.util.List;
import java.util.Set;

import com.winkelmann.swl.dc.project.system.domain.SysRole;

/**
 * 角色业务层
 * @author Administrator
 *
 */
public interface ISysRoleService
{
	// 根据条件分页查询角色数据
	public List<SysRole> selectRoleList(SysRole role);
	
	// 根据用户Id查询角色
	public Set<String> selectRolePermissionByUserId(Long userId);
	
	// 查询所有角色
	public List<SysRole> selectRoleAll();
	
	// 根据用户Id获取角色选择框列表
	public List<Integer> selectRoleListByUserId(Long userId);
	
	// 通过角色Id查询角色
	public SysRole selectRoleById(Long roleId);
	
	// 校验角色名称是否唯一
	public String checkRoleNameUnique(SysRole role);
	
	// 检验角色权限是否唯一
	public String checkRoleKeyUnique(SysRole role);
	
	// 校验角色是否允许操作
	public void checkRoleAllowed(SysRole role);
	
	// 通过角色Id查询角色使用数量
	public int countUserRoleByRoleId(Long roleId);
	
	// 新增保存角色信息
	public int insertRole(SysRole role);
	
	// 修改保存角色信息
	public int updateRole(SysRole role);
	
	// 修改角色状态
	public int updateRoleStatus(SysRole role);
	
	// 修改数据权限信息
	public int authDataScope(SysRole role);
	
	// 通过角色Id删除角色
	public int deleteRoleById(Long roleId);
	
	// 批量删除角色信息
	public int deleteRoleByIds(Long[] roleIds);
}

