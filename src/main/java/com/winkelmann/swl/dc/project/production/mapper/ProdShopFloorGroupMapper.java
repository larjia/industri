package com.winkelmann.swl.dc.project.production.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.production.domain.ProdShopFloorGroup;

/**
 * 管理班组 数据层
 * @author JiangL
 *
 */
public interface ProdShopFloorGroupMapper
{
	// 查询所有班组数据
	public List<ProdShopFloorGroup> selectShopFloorGroupList(ProdShopFloorGroup group);
	// 根据Id查询班组
	public ProdShopFloorGroup selectShopFloorGroupById(Long groupId);
	// 校验班组名称是否唯一
	public ProdShopFloorGroup checkGroupNameUnique(@Param("groupName") String groupName, @Param("deptId") Long deptId);
	// 新增班组
	public int insertShopFloorGroup(ProdShopFloorGroup shopFloorGroup);
	// 修改班组
	public int updateShopFloorGroup(ProdShopFloorGroup shopFloorGroup);
	// 通过Id删除班组
	public int deleteShopFloorGroupById(Long shopFloorGroupId);
}
