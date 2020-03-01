package com.winkelmann.swl.dc.project.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;

/**
 * 岗位表 sys_position
 * @author Administrator
 *
 */
public class SysPosition extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// 岗位序号
	private long positionId;
	// 岗位编码
	private String positionCode;
	// 岗位名称
	private String positionName;
	// 岗位排序
	private String positionSort;
	// 状态 0正常 1停用
	private String status;
	// 用户是否存在此岗位标识 默认不存在
	private boolean flag = false;
	
	public long getPositionId()
	{
		return positionId;
	}
	
	public void setPositionId(long positionId)
	{
		this.positionId = positionId;
	}
	
	@NotBlank(message = "岗位编码不能为空")
	@Size(min = 0, max = 64, message = "岗位编码长度不能超过64个字符")
	public String getPositionCode()
	{
		return positionCode;
	}
	
	public void setPositionCode(String positionCode)
	{
		this.positionCode = positionCode;
	}
	
	@NotBlank(message = "岗位名称不能为空")
	@Size(min = 0, max = 50, message = "岗位名称长度不能超过50个字符")
	public String getPositionName()
	{
		return positionName;
	}
	
	public void setPositionName(String positionName)
	{
		this.positionName = positionName;
	}
	
	@NotBlank(message = "显示顺序不能为空")
	public String getPositionSort()
	{
		return positionSort;
	}
	
	public void setPositionSort(String positionSort)
	{
		this.positionSort = positionSort;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public boolean isFlag()
	{
		return flag;
	}
	
	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("positionId", getPositionId())
				.append("positionCode", getPositionCode())
				.append("positionName", getPositionName())
				.append("positionSort", getPositionSort())
				.append("status", getStatus())
				.append("createBy", getCreateBy())
				.append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime())
				.append("remark", getRemark())
				.toString();
	}
}
