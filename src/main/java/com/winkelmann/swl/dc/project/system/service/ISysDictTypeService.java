package com.winkelmann.swl.dc.project.system.service;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysDictType;

/**
 * 字典 业务层
 * @author Administrator
 *
 */
public interface ISysDictTypeService
{
	// 根据条件分页查询字典类型
	public List<SysDictType> selectDictTypeList(SysDictType dictType);
	// 根据所有字典类型
	public List<SysDictType> selectDictTypeAll();
	// 根据字典类型Id查询信息
	public SysDictType selectDictTypeById(Long dictId);
	// 根据字典类型查询信息
	public SysDictType selectDictTypeByType(String dictType);
	// 通过字典ID删除字典信息
	public int deleteDictTypeById(Long dictId);
	// 批量删除字典信息
	public int deleteDictTypeByIds(Long[] dictIds);
	// 新增保存字典类型信息
	public int insertDictType(SysDictType dictType);
	// 修改保存字典类型信息
	public int updateDictType(SysDictType dictType);
	// 校验字典类型称是否唯一
	public String checkDictTypeUnique(SysDictType dictType);
}
