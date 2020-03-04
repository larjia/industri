package com.winkelmann.swl.dc.project.system.service;

/**
 * 参数配置 服务层
 * @author JiangL
 *
 */
public interface ISysConfigService
{
	// 查询参数配置信息
	public SysConfig selectConfigById(Long configId);
}
