package com.winkelmann.swl.dc.project.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.project.production.domain.ProdShopFloorGroup;
import com.winkelmann.swl.dc.project.production.mapper.ProdShopFloorGroupMapper;
import com.winkelmann.swl.dc.project.production.service.IProdShopFloorGroupService;

/**
 * 车间班组管理 服务层
 * @author Administrator
 *
 */
@Service
public class ProdShopFloorGroupService implements IProdShopFloorGroupService
{
	@Autowired
	private ProdShopFloorGroupMapper shopFloorGroupMapper;

	// 查询车间班组数据
	@Override
	public List<ProdShopFloorGroup> selectShopFloorGroupList()
	{
		return shopFloorGroupMapper.selectShopFloorGroupList();
	}

	// 根据班组Id查询班组
	@Override
	public ProdShopFloorGroup selectShopFloorGroupById(Long shopFloorGroupId)
	{
		return shopFloorGroupMapper.selectShopFloorGroupById(shopFloorGroupId);
	}

	// 根据名称查询班组
	@Override
	public List<ProdShopFloorGroup> selectShopFloorGroupByName(String shopFloorGroupName)
	{
		return shopFloorGroupMapper.selectShopFloorGroupByName(shopFloorGroupName);
	}

	// 新增车间班组
	@Override
	public int insertShopFloorGroup(ProdShopFloorGroup shopFloorGroup)
	{
		return shopFloorGroupMapper.insertShopFloorGroup(shopFloorGroup);
	}

	// 更新班组信息
	@Override
	public int updateShopFloorGroup(ProdShopFloorGroup shopFloorGroup)
	{
		return shopFloorGroupMapper.updateShopFloorGroup(shopFloorGroup);
	}

	// 根据Id删除班组信息
	@Override
	public int deleteShopFloorGroupById(Long shopFloorGroupId)
	{
		return shopFloorGroupMapper.deleteShopFloorGroupById(shopFloorGroupId);
	}

	// 检验班组名称唯一性
	@Override
	public String checkShopFloorGroupNameUnique(ProdShopFloorGroup group)
	{
		Long groupId = StringUtils.isNull(group.getShopFloorGroupId()) ? -1L : group.getShopFloorGroupId();
		ProdShopFloorGroup info = shopFloorGroupMapper.checkGroupNameUnique(group.getShopFloorGroupName(), group.getShopFloorGroupId());
		if (StringUtils.isNotNull(info) && info.getDeptId().longValue() != groupId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}

}
