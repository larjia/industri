package com.winkelmann.swl.dc.project.production.domain;

/*
 * 生产车间班组 比如钎焊班 检验班 包装入库班
 */
public class ProdShopFloorGroup
{
	private static final long serialVersionUID = 1L;
	
	// 班组Id
	private Long groupId;
	// 班组名称
	private Long groupName;
	// 部门Id
	private Long deptId;
	
	public ProdShopFloorGroup()
	{
	}

	public Long getShopFloorGroupId()
	{
		return groupId;
	}

	public void setShopFloorGroupId(Long groupId)
	{
		this.groupId = groupId;
	}

	public Long getShopFloorGroupName()
	{
		return groupName;
	}

	public void setShopFloorGroupName(Long groupName)
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
}
