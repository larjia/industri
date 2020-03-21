package com.winkelmann.swl.dc.project.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.project.production.domain.ProdSFOperation;
import com.winkelmann.swl.dc.project.production.mapper.ProdSFOperationMapper;
import com.winkelmann.swl.dc.project.production.service.IProdSFOperationService;

/**
 * 车间班组管理 服务层
 * @author Administrator
 *
 */
@Service
public class ProdSFOperationService implements IProdSFOperationService
{
	@Autowired
	private ProdSFOperationMapper operationMapper;
	
	@Override
	public List<ProdSFOperation> selectOperationList(ProdSFOperation op)
	{
		return operationMapper.selectOperationList(op);
	}

	@Override
	public ProdSFOperation selectOperationById(Long opId)
	{
		return operationMapper.selectOperationById(opId);
	}

	@Override
	public String checkOperationNameUnique(ProdSFOperation op)
	{
		Long opId = StringUtils.isNull(op.getId()) ? -1L : op.getId();
		ProdSFOperation info = operationMapper.checkOperationNameUnique(op.getName(), op.getGroupId());
		if (StringUtils.isNotNull(info) && info.getId().longValue() != opId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}

	@Override
	public int insertOperation(ProdSFOperation op)
	{
		return operationMapper.insertOperation(op);
	}

	@Override
	public int updateOperation(ProdSFOperation op)
	{
		return operationMapper.updateOperation(op);
	}

	@Override
	public int deleteOperationById(Long id)
	{
		return operationMapper.deleteOperationById(id);
	}

}
