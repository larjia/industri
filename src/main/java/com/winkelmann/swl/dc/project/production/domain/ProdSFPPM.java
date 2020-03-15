package com.winkelmann.swl.dc.project.production.domain;

import java.sql.Date;

import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;

/**
 * 车间质量PPM报表
 * @author Administrator
 *
 */
public class ProdSFPPM extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// Id
	private Long ppmId;
	// 生产日期
	private Date prodDate;
	// 物料名称
	private String partNumber;
	// 车间部门
	private String prodDept;
	// 班组
	private String prodSFGroup;
	// 工序
	private String prodSFOp;
	// 完成数
	private Integer qtyCompleted;
	// 不良数
	private Integer qtyRejected;
	// 报废数
	private Integer qtyScrapped;
	// 合格数
	private Integer qtyAccepted;
	// 员工操作员
	private String operator;
	// 班次 0白班 1夜班
	private String shift;
	// FTQ
	private Double ftq;
	// PPM
	private Double ppm;
	
	public ProdSFPPM()
	{
	}

	public Long getPpmId()
	{
		return ppmId;
	}

	public void setPpmId(Long ppmId)
	{
		this.ppmId = ppmId;
	}

	public Date getProdDate()
	{
		return prodDate;
	}

	public void setProdDate(Date prodDate)
	{
		this.prodDate = prodDate;
	}

	public String getPartNumber()
	{
		return partNumber;
	}

	public void setPartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	}

	public String getProdDept()
	{
		return prodDept;
	}

	public void setProdDept(String prodDept)
	{
		this.prodDept = prodDept;
	}

	public String getProdSFGroup()
	{
		return prodSFGroup;
	}

	public void setProdSFGroup(String prodSFGroup)
	{
		this.prodSFGroup = prodSFGroup;
	}

	public String getProdSFOp()
	{
		return prodSFOp;
	}

	public void setProdSFOp(String prodSFOp)
	{
		this.prodSFOp = prodSFOp;
	}

	public Integer getQtyCompleted()
	{
		return qtyCompleted;
	}

	public void setQtyCompleted(Integer qtyCompleted)
	{
		this.qtyCompleted = qtyCompleted;
	}

	public Integer getQtyRejected()
	{
		return qtyRejected;
	}

	public void setQtyRejected(Integer qtyRejected)
	{
		this.qtyRejected = qtyRejected;
	}

	public Integer getQtyScrapped()
	{
		return qtyScrapped;
	}

	public void setQtyScrapped(Integer qtyScrapped)
	{
		this.qtyScrapped = qtyScrapped;
	}

	public Integer getQtyAccepted()
	{
		return qtyAccepted;
	}

	public void setQtyAccepted(Integer qtyAccepted)
	{
		this.qtyAccepted = qtyAccepted;
	}

	public Double getFtq()
	{
		return ftq;
	}

	public void setFtq(Double ftq)
	{
		this.ftq = ftq;
	}

	public Double getPpm()
	{
		return ppm;
	}

	public void setPpm(Double ppm)
	{
		this.ppm = ppm;
	}

	public String getShift()
	{
		return shift;
	}

	public void setShift(String shift)
	{
		this.shift = shift;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}
}
