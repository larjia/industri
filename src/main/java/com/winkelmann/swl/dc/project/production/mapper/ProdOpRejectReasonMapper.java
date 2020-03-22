package com.winkelmann.swl.dc.project.production.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.production.domain.ProdOpRejectReason;

/**
 * 工序不良原因
 * @author Administrator
 *
 */
public interface ProdOpRejectReasonMapper
{
	// 查询不良原因
	public List<ProdOpRejectReason> selectReasonList(ProdOpRejectReason reason);
	// 校验原因名称是否唯一
	public ProdOpRejectReason checkReasonNameUnique(@Param("reason") String reason, @Param("opId") Long opId);
	// 新增原因
	public int insertReason(ProdOpRejectReason reason);
	// 修改原因
	public int updateReason(ProdOpRejectReason reason);
	// 通过Id删除原因
	public int deleteReasonById(Long id);
}
