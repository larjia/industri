package com.winkelmann.swl.dc.project.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.masterdata.domain.Part;

/**
 * 物料管理 数据层
 * @author Administrator
 *
 */
public interface PartMapper
{
	// 查询物料数据
	public List<Part> selectPartList(Part part);
	// 根据Id查询物料
	public Part selectPartById(Long id);
	// 根据物料项目名称查询物料
//	public List<Part> selectPartListByProjName(String projName);
	// 根据物料编码查询物料
	public Part selectPartListByNumber(String number);
	// 根据物料描述查询物料
//	public List<Part> selectPartListByDesc(String desc);
	// 校验物料编码是否唯一
	public Part checkPartNumberUnique(@Param("partNumber") String partNumber);
	// 新增物料
	public int insertPart(Part part);
	// 修改物料
	public int updatePart(Part part);
	// 删除物料
	public int deletePartById(Long id);
	// 通过编码删除物料
	public int deletePartByNumber(String number);
}
