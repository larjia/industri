package com.winkelmann.swl.dc.project.production.service;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdShopFloorOperation;

/**
 * 工序管理 服务层
 * @author Administrator
 *
 */
public interface IProdShopFloorOperationService
{
	// 查询所有工序数据
	public List<ProdShopFloorOperation> selectOperationList(ProdShopFloorOperation op);
	// 根据Id查询工序
	public ProdShopFloorOperation selectOperationById(Long opId);
	// 校验工序名称是否唯一
	public String checkOperationNameUnique(ProdShopFloorOperation op);
	// 新增工序
	public int insertOperation(ProdShopFloorOperation op);
	// 修改工序
	public int updateOperation(ProdShopFloorOperation op);
	// 通过Id删除工序
	public int deleteOperationById(Long opId);
}
