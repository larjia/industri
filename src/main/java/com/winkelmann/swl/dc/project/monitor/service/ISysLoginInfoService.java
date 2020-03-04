package com.winkelmann.swl.dc.project.monitor.service;

import java.util.List;

import com.winkelmann.swl.dc.project.monitor.domain.SysLoginInfo;

/**
 * 系统访问日志情况信息 服务层
 * @author JiangL
 *
 */
public interface ISysLoginInfoService
{
	// 新增系统登录日志
	public void insertLoginInfo(SysLoginInfo loginInfo);
	
	// 查询系统登录日志集合
	public List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo);
	
	// 批量删除系统登录日志
	public int deleteLoginInfoByIds(Long[] infoIds);
	
	// 清空系统登录日志
	public void cleanLoginInfo();
}
