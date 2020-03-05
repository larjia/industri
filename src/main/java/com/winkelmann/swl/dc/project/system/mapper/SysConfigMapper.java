package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysConfig;

/**
 * 参数配置 数据层
 * @author Administrator
 *
 */
public interface SysConfigMapper
{
	// 查询参数配置信息
	public SysConfig selectConfig(SysConfig config);
	// 查询参数配置列表
	public List<SysConfig> selectConfigList(SysConfig config);
	// 根据键名查询参数配置信息
	public SysConfig checkConfigKeyUnique(String configKey);
	// 新增参数配置
	public int insertConfig(SysConfig config);
	// 修改参数配置
	public int updateConfig(SysConfig config);
	// 删除参数配置
	public int deleteConfigById(Long configId);
	// 批量删除参数信息
	public int deleteConfigByIds(Long[] configIds);
}
