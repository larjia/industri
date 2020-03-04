package com.winkelmann.swl.dc.project.monitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.project.monitor.domain.SysOperLog;
import com.winkelmann.swl.dc.project.monitor.mapper.SysOperLogMapper;
import com.winkelmann.swl.dc.project.monitor.service.ISysOperLogService;

/**
 * 操作日志 服务层处理
 * @author JiangL
 *
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService
{
	@Autowired
	private SysOperLogMapper operLogMapper;

	// 新增操作日志
	@Override
	public void insertOperLog(SysOperLog operLog) {
		operLogMapper.insertOperLog(operLog);
	}

	// 查询系统操作日志集合
	@Override
	public List<SysOperLog> selectOperLogList(SysOperLog operLog) {
		return operLogMapper.selectOperLogList(operLog);
	}

	// 批量删除系统操作日志
	@Override
	public int deleteOperLogByIds(Long[] operIds) {
		return operLogMapper.deleteOperLogByIds(operIds);
	}

	// 查询操作日志详细
	@Override
	public SysOperLog selectOperLogById(Long operId) {
		return operLogMapper.selectOperLogById(operId);
	}

	// 清空操作日志
	@Override
	public void cleanOperLog() {
		operLogMapper.cleanOperLog();
	}
}
