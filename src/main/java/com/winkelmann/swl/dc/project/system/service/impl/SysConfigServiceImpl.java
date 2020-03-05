package com.winkelmann.swl.dc.project.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.project.system.domain.SysConfig;
import com.winkelmann.swl.dc.project.system.mapper.SysConfigMapper;
import com.winkelmann.swl.dc.project.system.service.ISysConfigService;

/**
 * 参数配置 服务处实现
 * @author Administrator
 *
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService
{
	@Autowired
	private SysConfigMapper configMapper;

	/**
	 * 查询参数配置信息
	 */
	@Override
	public SysConfig selectConfigById(Long configId)
	{
		SysConfig config = new SysConfig();
		config.setConfigId(configId);
		return configMapper.selectConfig(config);
	}

	/**
	 * 根据键名查询参数配置信息
	 */
	@Override
	public String selectConfigByKey(String configKey)
	{
		SysConfig config = new SysConfig();
		config.setConfigKey(configKey);
		SysConfig retConfig = configMapper.selectConfig(config);
		return StringUtils.isNotNull(retConfig) ? retConfig.getConfigValue() : "";
	}

	/**
	 * 查询参数配置列表
	 */
	@Override
	public List<SysConfig> selectConfigList(SysConfig config)
	{
		return configMapper.selectConfigList(config);
	}

	/**
	 * 新增参数配置
	 */
	@Override
	public int insertConfig(SysConfig config)
	{
		return configMapper.insertConfig(config);
	}

	/**
	 * 修改参数配置
	 */
	@Override
	public int updateConfig(SysConfig config)
	{
		return configMapper.updateConfig(config);
	}

	/**
	 * 删除参数配置信息
	 */
	@Override
	public int deleteConfigById(Long configId)
	{
		return configMapper.deleteConfigById(configId);
	}

	/**
	 * 批量删除参数信息
	 */
	@Override
	public int deleteConfigByIds(Long[] configIds)
	{
		return configMapper.deleteConfigByIds(configIds);
	}

	/**
	 * 校验参数键名是否唯一
	 */
	@Override
	public String checkConfigKeyUnique(SysConfig config)
	{
		Long configId = StringUtils.isNull(config.getConfigId()) ? -1L : config.getConfigId();
		SysConfig info = configMapper.checkConfigKeyUnique(config.getConfigKey());
		if (StringUtils.isNotNull(info) && info.getConfigId().longValue() != configId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}
}
