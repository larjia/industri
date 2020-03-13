package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.system.domain.SysDictData;

/**
 * 字典表 数据层
 * @author Administrator
 *
 */
public interface SysDictDataMapper
{
	// 根据条件分页查询字典数据
	public List<SysDictData> selectDictDataList(SysDictData dictData);
	// 根据字典类型查询字典数据
	public List<SysDictData> selectDictDataByType(String dictType);
	// 根据字典类型和字典键值查询字典数据信息
	public String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);
	// 根据字典数据Id查询信息
	public SysDictData selectDictDataById(Long dictCode);
	// 查询字典数据
	public int countDictDataByTypes(String dictType);
	// 通过字典Id删除字典数据信息
	public int deleteDictDataById(Long dictCode);
	// 批量删除字典数据信息
	public int deleteDictDataByIds(Long[] dictCodes);
	// 新增字典数据信息
	public int insertDictData(SysDictData dictData);
	// 修改字典数据信息
	public int updateDictData(SysDictData dictData);
	// 同步修改字典类型
	public int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);
}
