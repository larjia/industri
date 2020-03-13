package com.winkelmann.swl.dc.project.system.service;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysDictData;

/**
 * 字典 业务层
 * @author Administrator
 */
public interface ISysDictDataService
{
	// 根据条件分页查询字典数据
	public List<SysDictData> selectDictDataList(SysDictData dictData);
	// 根据字典类型查询字典数据
	public List<SysDictData> selectDictDataByType(String dictType);
	// 根据字典类型和字典键值查询字典数据信息
	public String selectDictLabel(String dictType, String dictValue);
	// 根据字典数据ID查询信息
	public SysDictData selectDictDataById(Long dictCode);
	// 通过字典Id删除字典数据信息
	public int deleteDictDataById(Long dictCode);
	// 批量删除字典数据信息
	public int deleteDictDataByIds(Long[] dictCodes);
	// 新增保存字典数据信息
	public int insertDictData(SysDictData dictData);
	// 修改保存字典数据信息
	public int updateDictData(SysDictData dictData);
}
