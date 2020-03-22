package com.winkelmann.swl.dc.project.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.project.production.domain.ProdOpRejectReason;
import com.winkelmann.swl.dc.project.production.mapper.ProdOpRejectReasonMapper;
import com.winkelmann.swl.dc.project.production.service.IProdOpRejectReasonService;

@Service
public class ProdOpRejectReasonService implements IProdOpRejectReasonService
{
	@Autowired
	private ProdOpRejectReasonMapper reasonMapper;

	@Override
	public List<ProdOpRejectReason> selectReasonList(ProdOpRejectReason reason)
	{
		return reasonMapper.selectReasonList(reason);
	}

	@Override
	public String checkReasonNameUnique(ProdOpRejectReason reason)
	{
		ProdOpRejectReason info = reasonMapper.checkReasonNameUnique(reason.getReason(), reason.getOpId());
		if (StringUtils.isNotNull(info))
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}

	@Override
	public int insertReason(ProdOpRejectReason reason)
	{
		return reasonMapper.insertReason(reason);
	}

	@Override
	public int updateReason(ProdOpRejectReason reason)
	{
		return reasonMapper.updateReason(reason);
	}

	@Override
	public int deleteReasonById(Long id)
	{
		return reasonMapper.deleteReasonById(id);
	}

}
