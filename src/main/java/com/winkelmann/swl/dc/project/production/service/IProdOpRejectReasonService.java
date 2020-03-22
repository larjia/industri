package com.winkelmann.swl.dc.project.production.service;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdOpRejectReason;

/**
 * 工序不良原因 服务层
 * @author Administrator
 *
 */
public interface IProdOpRejectReasonService
{
	// 查询不良原因
	public List<ProdOpRejectReason> selectReasonList(ProdOpRejectReason reason);
	// 校验原因名称是否唯一
	public String checkReasonNameUnique(ProdOpRejectReason reason);
	// 新增原因
	public int insertReason(ProdOpRejectReason reason);
	// 修改原因
	public int updateReason(ProdOpRejectReason reason);
	// 删除原因
	public int deleteReasonById(Long id);
}
