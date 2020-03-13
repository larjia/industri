package com.winkelmann.swl.dc.project.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.project.system.domain.SysDictData;
import com.winkelmann.swl.dc.project.system.mapper.SysDictDataMapper;
import com.winkelmann.swl.dc.project.system.service.ISysDictDataService;

/**
 * 字典 业务层处理
 * @author Administrator
 *
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService
{
	@Autowired
	private SysDictDataMapper dictDataMapper;

	/**
	 * 根据条件分页查询字典数据
	 */
	@Override
	public List<SysDictData> selectDictDataList(SysDictData dictData)
	{
		return dictDataMapper.selectDictDataList(dictData);
	}

	/**
	 * 根据字典类型查询字典数据
	 */
	@Override
	public List<SysDictData> selectDictDataByType(String dictType)
	{
		return dictDataMapper.selectDictDataByType(dictType);
	}

	/**
	 * 根据字典类型和字典键值查询字典数据信息
	 */
	@Override
	public String selectDictLabel(String dictType, String dictValue)
	{
		return dictDataMapper.selectDictLabel(dictType, dictValue);
	}

	/**
	 * 根据字典数据ID查询信息
	 */
	@Override
	public SysDictData selectDictDataById(Long dictCode)
	{
		return dictDataMapper.selectDictDataById(dictCode);
	}

	/**
	 * 通过字典ID删除字典数据信息
	 */
	@Override
	public int deleteDictDataById(Long dictCode)
	{
		return dictDataMapper.deleteDictDataById(dictCode);
	}

	/**
	 * 批量删除字典数据信息
	 */
	@Override
	public int deleteDictDataByIds(Long[] dictCodes)
	{
		return dictDataMapper.deleteDictDataByIds(dictCodes);
	}

	/**
	 * 新增保存字典数据信息
	 */
	@Override
	public int insertDictData(SysDictData dictData)
	{
		return dictDataMapper.insertDictData(dictData);
	}

	/**
	 * 修改保存字典数据信息
	 */
	@Override
	public int updateDictData(SysDictData dictData)
	{
		return dictDataMapper.updateDictData(dictData);
	}
}
