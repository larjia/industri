package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysPosition;

/**
 * 岗位信息 数据层
 * @author JiangL
 *
 */
public interface SysPositionMapper
{
	// 查询岗位数据集合
	public List<SysPosition> selectPositionList(SysPosition position);
	// 查询所有岗位
	public List<SysPosition> selectPositionAll();
	// 通过岗位Id查询岗位信息
	public SysPosition selectPositionById(Long positionId);
	// 根据用户Id获取岗位选择框列表
	public List<Integer> selectPositionListByUserId(Long userId);
	// 查询用户所属岗位组
	public List<SysPosition> selectPositionsByUserName(String userName);
	// 删除岗位信息
	public int deletePositionById(Long positionId);
	// 批量删除岗位信息
	public int deletePositionByIds(Long[] positionIds);
	// 修改岗位信息
	public int updatePosition(SysPosition position);
	// 新增岗位信息
	public int insertPost(SysPosition position);
	// 校验岗位名称
	public SysPosition checkPositionNameUnique(String positionName);
	// 校验岗位编码
	public SysPosition checkPositionCodeUnique(String positionCode);
}
