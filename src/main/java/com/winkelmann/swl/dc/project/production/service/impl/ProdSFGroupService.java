package com.winkelmann.swl.dc.project.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.project.production.domain.ProdSFGroup;
import com.winkelmann.swl.dc.project.production.mapper.ProdSFGroupMapper;
import com.winkelmann.swl.dc.project.production.service.IProdSFGroupService;

/**
 * 车间班组管理 服务层
 * @author Administrator
 *
 */
@Service
public class ProdSFGroupService implements IProdSFGroupService
{
	@Autowired
	private ProdSFGroupMapper groupMapper;

	// 查询车间班组数据
	@Override
	public List<ProdSFGroup> selectGroupList(ProdSFGroup group)
	{
		return groupMapper.selectGroupList(group);
	}

	// 根据班组Id查询班组
	@Override
	public ProdSFGroup selectGroupById(Long id)
	{
		return groupMapper.selectGroupById(id);
	}
	
	// 根据车间Id查询班组
	@Override
	public List<ProdSFGroup> selectGroupByDeptId(Long deptId)
	{
		return groupMapper.selectGroupByDeptId(deptId);
	}

	// 新增车间班组
	@Override
	public int insertGroup(ProdSFGroup group)
	{
		return groupMapper.insertGroup(group);
	}

	// 更新班组信息
	@Override
	public int updateGroup(ProdSFGroup group)
	{
		return groupMapper.updateGroup(group);
	}

	// 根据Id删除班组信息
	@Override
	public int deleteGroupById(Long id)
	{
		return groupMapper.deleteGroupById(id);
	}

	// 检验班组名称唯一性
	@Override
	public String checkGroupNameUnique(ProdSFGroup group)
	{
		Long groupId = StringUtils.isNull(group.getId()) ? -1L : group.getId();
		ProdSFGroup info = groupMapper.checkGroupNameUnique(group.getName(), group.getDeptId());
		if (StringUtils.isNotNull(info) && info.getDeptId().longValue() != groupId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}

}
