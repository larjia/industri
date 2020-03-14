package com.winkelmann.swl.dc.project.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.project.production.domain.ProdShopFloorOperation;
import com.winkelmann.swl.dc.project.production.mapper.ProdShopFloorOperationMapper;
import com.winkelmann.swl.dc.project.production.service.IProdShopFloorOperationService;

/**
 * 车间班组管理 服务层
 * @author Administrator
 *
 */
@Service
public class ProdShopFloorOperationService implements IProdShopFloorOperationService
{
	@Autowired
	private ProdShopFloorOperationMapper operationMapper;
	
	@Override
	public List<ProdShopFloorOperation> selectOperationList(ProdShopFloorOperation op)
	{
		return operationMapper.selectOperationList(op);
	}

	@Override
	public ProdShopFloorOperation selectOperationById(Long opId)
	{
		return operationMapper.selectOperationById(opId);
	}

	@Override
	public String checkOperationNameUnique(ProdShopFloorOperation op)
	{
		Long opId = StringUtils.isNull(op.getOperationId()) ? -1L : op.getOperationId();
		ProdShopFloorOperation info = operationMapper.checkOperationNameUnique(op.getOperationName(), op.getGroupId());
		if (StringUtils.isNotNull(info) && info.getOperationId().longValue() != opId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}

	@Override
	public int insertOperation(ProdShopFloorOperation op)
	{
		return operationMapper.insertOperation(op);
	}

	@Override
	public int updateOperation(ProdShopFloorOperation op)
	{
		return operationMapper.updateOperation(op);
	}

	@Override
	public int deleteOperationById(Long opId)
	{
		return operationMapper.deleteOperationById(opId);
	}

}
