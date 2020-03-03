package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.system.domain.SysUserRole;

/**
 * 用户与角色关联表 数据层
 * @author Administrator
 *
 */
public interface SysUserRoleMapper
{
	// 通过用户Id删除用户和角色关联
	public int deleteUserRoleByUserId(Long userId);
	// 批量删除用户和角色关联
	public int deleteUserRole(Long[] ids);
	// 通过角色Id查询角色使用数量
	public int countUserRoleByRoleId(Long roleId);
	// 批量新增用户角色信息
	public int batchUserRole(List<SysUserRole> userRoleList);
	// 删除用户和角色关联信息
	public int deleteUserRoleInfo(SysUserRole userRole);
	// 批量取消授权用户角色
	public int deleteUserRoleInfos(@Param("roleId") Long roleId, @Param("userIds") Long[] userIds);
}
