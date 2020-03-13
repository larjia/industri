package com.winkelmann.swl.dc.project.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.project.system.domain.SysDictType;
import com.winkelmann.swl.dc.project.system.mapper.SysDictDataMapper;
import com.winkelmann.swl.dc.project.system.mapper.SysDictTypeMapper;
import com.winkelmann.swl.dc.project.system.service.ISysDictTypeService;

/**
 * 字典 业务层处理
 * @author Administrator
 *
 */
@Service
public class SysDictTypeServiceImpl implements ISysDictTypeService
{
	@Autowired
	private SysDictTypeMapper dictTypeMapper;
	
	@Autowired
	private SysDictDataMapper dictDataMapper;

	/**
	 * 根据条件分页查询字典类型
	 */
	@Override
	public List<SysDictType> selectDictTypeList(SysDictType dictType)
	{
		return dictTypeMapper.selectDictTypeList(dictType);
	}

	/**
	 * 查询所有字典类型
	 */
	@Override
	public List<SysDictType> selectDictTypeAll()
	{
		return dictTypeMapper.selectDictTypeAll();
	}

	/**
	 * 根据字典类型ID查询信息
	 */
	@Override
	public SysDictType selectDictTypeById(Long dictId)
	{
		return dictTypeMapper.selectDictTypeById(dictId);
	}

	/**
	 * 根据字典类型查询信息
	 */
	@Override
	public SysDictType selectDictTypeByType(String dictType)
	{
		return dictTypeMapper.selectDictTypeByType(dictType);
	}

	/**
	 * 通过字典Id删除字典信息
	 */
	@Override
	public int deleteDictTypeById(Long dictId)
	{
		return dictTypeMapper.deleteDictTypeById(dictId);
	}

	/**
	 * 批量删除字典类型信息
	 */
	@Override
	public int deleteDictTypeByIds(Long[] dictIds)
	{
		return dictTypeMapper.deleteDictTypeByIds(dictIds);
	}

	/**
	 * 新增保存字典类型信息
	 */
	@Override
	public int insertDictType(SysDictType dictType)
	{
		return dictTypeMapper.insertDictType(dictType);
	}

	/**
	 * 修改保存字典类型信息
	 */
	@Override
	@Transactional
	public int updateDictType(SysDictType dictType)
	{
		SysDictType oldDict = dictTypeMapper.selectDictTypeById(dictType.getDictId());
		dictDataMapper.updateDictDataType(oldDict.getDictType(), dictType.getDictType());
		return dictTypeMapper.updateDictType(dictType);
	}

	/**
	 * 校验字典类型名称是否唯一
	 */
	@Override
	public String checkDictTypeUnique(SysDictType dict)
	{
		Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
		SysDictType dictType = dictTypeMapper.checkDictTypeUnique(dict.getDictType());
		if (StringUtils.isNotNull(dictType) && dictType.getDictId().longValue() != dictId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}

}
