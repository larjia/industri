package com.winkelmann.swl.dc.project.production.domain;

import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;
import com.winkelmann.swl.dc.project.system.domain.SysDept;

/*
 * 生产车间班组 比如钎焊班 检验班 包装入库班
 */
public class ProdShopFloorGroup extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// 班组Id
	private Long groupId;
	// 班组名称
	private String groupName;
	// 部门Id
	private Long deptId;
	// 部门对象
	private SysDept dept;
	
	public ProdShopFloorGroup()
	{
	}

	public Long getGroupId()
	{
		return groupId;
	}

	public void setGroupId(Long groupId)
	{
		this.groupId = groupId;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public Long getDeptId()
	{
		return deptId;
	}

	public void setDeptId(Long deptId)
	{
		this.deptId = deptId;
	}

	public SysDept getDept()
	{
		return dept;
	}

	public void setDept(SysDept dept)
	{
		this.dept = dept;
	}
	
}
