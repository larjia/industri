package com.winkelmann.swl.dc.project.production.domain;

import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;

/**
 * 工序不良原因
 * @author Administrator
 *
 */
public class ProdOpRejectReason extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// Id
	private Long id;
	// 工序Id
	private Long opId;
	// 不良原因
	private String reason;
	
	public ProdOpRejectReason()
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

	public Long getOpId()
	{
		return opId;
	}

	public void setOpId(Long opId)
	{
		this.opId = opId;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}
	
}
