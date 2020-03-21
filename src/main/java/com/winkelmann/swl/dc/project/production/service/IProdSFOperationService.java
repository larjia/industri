package com.winkelmann.swl.dc.project.production.service;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdSFOperation;

/**
 * 工序管理 服务层
 * @author Administrator
 *
 */
public interface IProdSFOperationService
{
	// 查询所有工序数据
	public List<ProdSFOperation> selectOperationList(ProdSFOperation op);
	// 根据Id查询工序
	public ProdSFOperation selectOperationById(Long id);
	// 校验工序名称是否唯一
	public String checkOperationNameUnique(ProdSFOperation op);
	// 新增工序
	public int insertOperation(ProdSFOperation op);
	// 修改工序
	public int updateOperation(ProdSFOperation op);
	// 通过Id删除工序
	public int deleteOperationById(Long id);
}
