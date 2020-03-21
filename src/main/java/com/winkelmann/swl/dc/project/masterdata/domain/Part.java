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
	private String number;
	// 物料描述1
	private String desc;
	// 物料描述2
	private String desc2;
	// 项目名称
	private String projName;
	// 状态
	private String status;
	
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

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getDesc2()
	{
		return desc2;
	}

	public void setDesc2(String desc2)
	{
		this.desc2 = desc2;
	}

	public String getProjName()
	{
		return projName;
	}

	public void setProjName(String projName)
	{
		this.projName = projName;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
}
