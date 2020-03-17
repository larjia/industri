package com.winkelmann.swl.dc.project.system.service;

import java.util.List;

import com.winkelmann.swl.dc.framework.web.domain.TreeSelect;
import com.winkelmann.swl.dc.project.system.domain.SysDept;

/**
 * 部门管理 服务层
 * @author JiangL
 *
 */
public interface ISysDeptService
{
	// 查询部门管理数据
	public List<SysDept> selectDeptList(SysDept dept);
	// 查询车间部门
	public List<SysDept> selectProdDeptList(SysDept dept);
	// 构建前端所需要树结构
	public List<SysDept> buildDeptTree(List<SysDept> depts);
	// 构建前端所需要下拉树结构
	public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);
	// 根据角色Id查询部门树信息
	public List<Integer> selectDeptListByRoleId(Long roleId);
	// 根据部门Id查询信息
	public SysDept selectDeptById(Long deptId);
	// 是否存在部门子节点
	public boolean hasChildByDeptId(Long deptId);
	// 查询部门是否存在用户
	public boolean checkDeptExistUser(Long userId);
	// 校验部门名称是否唯一
	public String checkDeptNameUnique(SysDept dept);
	// 新增部门信息
	public int insertDept(SysDept dept);
	// 修改保存部门信息
	public int updateDept(SysDept dept);
	// 删除部门管理信息
	public int deleteDeptById(Long deptId);
}
