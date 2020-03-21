package com.winkelmann.swl.dc.project.production.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.production.domain.ProdSFGroup;

/**
 * 管理班组 数据层
 * @author JiangL
 *
 */
public interface ProdSFGroupMapper
{
	// 查询所有班组数据
	public List<ProdSFGroup> selectGroupList(ProdSFGroup group);
	// 根据Id查询班组
	public ProdSFGroup selectGroupById(Long id);
	// 校验班组名称是否唯一
	public ProdSFGroup checkGroupNameUnique(@Param("name") String name, @Param("deptId") Long deptId);
	// 新增班组
	public int insertGroup(ProdSFGroup group);
	// 修改班组
	public int updateGroup(ProdSFGroup group);
	// 通过Id删除班组
	public int deleteGroupById(Long id);
}
