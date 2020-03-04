package com.winkelmann.swl.dc.project.monitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.project.monitor.domain.SysLoginInfo;
import com.winkelmann.swl.dc.project.monitor.mapper.SysLoginInfoMapper;
import com.winkelmann.swl.dc.project.monitor.service.ISysLoginInfoService;

/**
 * 系统访问日志情况信息 服务层处理
 * @author JiangL
 *
 */
@Service
public class SysLoginInfoServiceImpl implements ISysLoginInfoService
{
	@Autowired
	private SysLoginInfoMapper loginInfoMapper;
	
	// 新增系统登录日志
	@Override
	public void insertLoginInfo(SysLoginInfo loginInfo)
	{
		loginInfoMapper.insertLoginInfo(loginInfo);
	}
	
	// 查询系统登录日志集合
	@Override
	public List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo)
	{
		return loginInfoMapper.selectLoginInfoList(loginInfo);
	}
	
	// 批量删除系统登录日志
	@Override
	public int deleteLoginInfoByIds(Long[] infoIds)
	{
		return loginInfoMapper.deleteLoginInfoByIds(infoIds);
	}
	
	// 清空系统登录日志
	@Override
	public void cleanLoginInfo()
	{
		loginInfoMapper.cleanLoginInfo();
	}
}
