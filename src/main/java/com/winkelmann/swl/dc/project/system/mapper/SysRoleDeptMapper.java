package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysRoleDept;

/**
 * 角色与部门关联表 数据层
 * @author Administrator
 *
 */
public interface SysRoleDeptMapper
{
	// 通过角色Id删除角色和部门关联
	public int deleteRoleDeptByRoleId(Long roleId);
	
	// 批量删除角色部门关联信息
	public int deleteRoleDept(Long[] ids);
	
	// 查询部门使用数量
	public int selectCountRoleDeptByDeptId(Long deptId);
	
	// 批量新增角色部门信息
	public int batchRoleDept(List<SysRoleDept> roleDeptList);
}
