package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.winkelmann.swl.dc.project.system.domain.SysDictType;

/**
 * 字典表 数据层
 * @author Administrator
 *
 */
@Mapper
public interface SysDictTypeMapper
{
	// 根据条件分页查询字典类型
	public List<SysDictType> selectDictTypeList(SysDictType dictType);
	// 查询所有字典类型
	public List<SysDictType> selectDictTypeAll();
	// 根据字典类型Id查询信息
	public SysDictType selectDictTypeById(Long dictId);
	// 根据字典类型查询信息
	public SysDictType selectDictTypeByType(String dictType);
	// 通过字典Id删除字典信息
	public int deleteDictTypeById(Long dictId);
	// 批量删除字典类型信息
	public int deleteDictTypeByIds(Long[] dictIds);
	// 新增字典类型信息
	public int insertDictType(SysDictType dictType);
	// 修改字典类型信息
	public int updateDictType(SysDictType dictType);
	// 校验字典类型名称是否唯一
	public SysDictType checkDictTypeUnique(String dictType);
}
