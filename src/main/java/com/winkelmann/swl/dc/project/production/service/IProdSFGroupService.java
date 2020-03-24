package com.winkelmann.swl.dc.project.production.service;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdSFGroup;

/**
 * 班组管理 服务层
 * @author JiangL
 *
 */
public interface IProdSFGroupService
{
	// 查询所有班组数据
	public List<ProdSFGroup> selectGroupList(ProdSFGroup group);
	// 根据Id查询班组
	public ProdSFGroup selectGroupById(Long groupId);
	// 校验班组名称是否唯一
	public String checkGroupNameUnique(ProdSFGroup group);
	// 新增班组
	public int insertGroup(ProdSFGroup group);
	// 修改班组
	public int updateGroup(ProdSFGroup group);
	// 通过Id删除班组
	public int deleteGroupById(Long id);
}
