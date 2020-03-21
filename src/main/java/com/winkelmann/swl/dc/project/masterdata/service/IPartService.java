package com.winkelmann.swl.dc.project.masterdata.service;

import java.util.List;

import com.winkelmann.swl.dc.project.masterdata.domain.Part;

/**
 * 物料管理 服务层
 * @author Administrator
 *
 */
public interface IPartService
{
	// 查询物料数据
	public List<Part> selectPartList(Part part);
	// 根据Id查询物料
	public Part selectPartById(Long id);
	// 根据物料编码查询物料
	public Part selectPartByNumber(String number);
	// 校验物料编码是否唯一
	public String checkPartNumberUnique(Part part);
	// 新增物料
	public int insertPart(Part part);
	// 修改物料
	public int updatePart(Part part);
	// 通过Id删除班组
	public int deletePartById(Long id);
	// 通过编码删除物料
	public int deletePartByNumber(String number);
}
