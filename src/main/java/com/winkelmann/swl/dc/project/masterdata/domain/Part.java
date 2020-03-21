package com.winkelmann.swl.dc.project.masterdata.domain;

import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;

/**
 * 物料表
 * @author Administrator
 *
 */
public class Part extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// 物料Id
	private Long id;
	// 物料编码
	private String partNumber;
	// 物料描述1
	private String partDesc;
	// 物料描述2
	private String partDesc2;
	// 项目名称
	private String partProjName;
	// 状态
	private String partStatus;
	
	public Part()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getPartNumber()
	{
		return partNumber;
	}

	public void setPartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	}

	public String getPartDesc()
	{
		return partDesc;
	}

	public void setPartDesc(String partDesc)
	{
		this.partDesc = partDesc;
	}

	public String getPartDesc2()
	{
		return partDesc2;
	}

	public void setPartDesc2(String partDesc2)
	{
		this.partDesc2 = partDesc2;
	}

	public String getPartProjName()
	{
		return partProjName;
	}

	public void setPartProjName(String partProjName)
	{
		this.partProjName = partProjName;
	}

	public String getPartStatus()
	{
		return partStatus;
	}

	public void setPartStatus(String partStatus)
	{
		this.partStatus = partStatus;
	}
	
}
