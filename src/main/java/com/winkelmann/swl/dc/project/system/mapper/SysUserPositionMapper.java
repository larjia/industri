package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysUserPosition;

/**
 * 用户与岗位关联表 数据层
 * @author JiangL
 *
 */
public interface SysUserPositionMapper
{
	// 通过用户Id删除用户和岗位关联
	public int deleteUserPositionByUserId(Long userId);
	// 通过岗位Id查询岗位使用数量
	public int countUserPositionById(Long positionId);
	// 批量删除用户和岗位关联
	public int deleteUserPosition(Long[] ids);
	// 批量新增用户岗位信息
	public int batchUserPosition(List<SysUserPosition> userPosition);
}
