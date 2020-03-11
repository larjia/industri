package com.winkelmann.swl.dc.project.production.service;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdShopFloorGroup;

/**
 * 班组管理 服务层
 * @author JiangL
 *
 */
public interface IProdShopFloorGroupService
{
	// 查询所有班组数据
	public List<ProdShopFloorGroup> selectShopFloorGroupList();
	// 根据Id查询班组
	public ProdShopFloorGroup selectShopFloorGroupById(Long shopFloorGroupId);
	// 根据名称查询班组
	public List<ProdShopFloorGroup> selectShopFloorGroupByName(String shopFloorGroupName);
	// // 校验班组名称是否唯一
	public String checkShopFloorGroupNameUnique(ProdShopFloorGroup group);
	// 新增班组
	public int insertShopFloorGroup(ProdShopFloorGroup shopFloorGroup);
	// 修改班组
	public int updateShopFloorGroup(ProdShopFloorGroup shopFloorGroup);
	// 通过Id删除班组
	public int deleteShopFloorGroupById(Long shopFloorGroupId);
}
