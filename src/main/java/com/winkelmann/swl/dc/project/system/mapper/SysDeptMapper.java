package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.system.domain.SysDept;

/**
 * 部门管理 数据层
 * @author Administrator
 *
 */
public interface SysDeptMapper
{
	/**
	 * 查询部门管理数据
	 */
	public List<SysDept> selectDeptList(SysDept dept);
	
	/**
	 * 查询车间部门
	 */
	public List<SysDept> selectProdDeptList(SysDept dept);
	
	/**
	 * 根据角色Id查询部门树信息
	 */
	public List<Integer> selectDeptListByRoleId(Long roleId);
	
	/**
	 * 根据部门Id查询信息
	 */
	public SysDept selectDeptById(Long deptId);
	
	/**
	 * 根据Id查询所有子部门
	 */
	public List<SysDept> selectChildrenDeptById(Long deptId);
	
	/**
	 * 是否存在子节点
	 */
	public int hasChildByDeptId(Long deptId);
	
	/**
	 * 查询部门是否存在用户
	 */
	public int checkDeptExistUser(Long deptId);
	
	/**
	 * 校验部门名称是否唯一
	 */
	public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);
	
	/**
	 * 新增部门信息
	 */
	public int insertDept(SysDept dept);
	
	/**
	 * 修改部门信息
	 */
	public int updateDept(SysDept dept);
	
	/**
	 * 修改所在部门的父级部门状态
	 */
	public void updateDeptStatus(SysDept dept);
	
	/**
	 * 修改子元素关系
	 */
	public int updateDeptChildren(@Param("depts") List<SysDept> depts);
	
	/**
	 * 删除部门管理信息
	 */
	public int deleteDeptById(Long deptId);
}
