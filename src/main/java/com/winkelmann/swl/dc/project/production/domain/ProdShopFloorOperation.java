package com.winkelmann.swl.dc.project.production.domain;

import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;

/**
 * 生产车间工序(按班组分,比如焊接班组下有点胶、上料工序)
 * @author Administrator
 *
 */
public class ProdShopFloorOperation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// 工序Id
	private Long operationId;
	// 工序名称
	private String operationName;
	// 班组Id
	private Long groupId;
	// 班组对象
	private ProdShopFloorGroup group;
	
	public ProdShopFloorOperation()
	{
	}

	public Long getOperationId()
	{
		return operationId;
	}

	public void setOperationId(Long operationId)
	{
		this.operationId = operationId;
	}

	public String getOperationName()
	{
		return operationName;
	}

	public void setOperationName(String operationName)
	{
		this.operationName = operationName;
	}

	public Long getGroupId()
	{
		return groupId;
	}

	public void setGroupId(Long groupId)
	{
		this.groupId = groupId;
	}

	public ProdShopFloorGroup getGroup()
	{
		return group;
	}

	public void setGroup(ProdShopFloorGroup group)
	{
		this.group = group;
	}
	
}
