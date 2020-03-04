package com.winkelmann.swl.dc.project.monitor.service;

import java.util.List;

import com.winkelmann.swl.dc.project.monitor.domain.SysOperLog;

/**
 * 操作日志 服务层
 * @author JiangL
 *
 */
public interface ISysOperLogService
{
	// 新增操作日志
	public void insertOperLog(SysOperLog operLog);
	
	// 查询系统操作日志集合
	public List<SysOperLog> selectOperLogList(SysOperLog operLog);
	
	// 批量删除系统操作日志
	public int deleteOperLogByIds(Long[] operIds);
	
	// 查询操作日志详细
	public SysOperLog selectOperLogById(Long operId);
	
	// 清空操作日志
	public void cleanOperLog();
}
