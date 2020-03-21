package com.winkelmann.swl.dc.project.production.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.production.domain.ProdSFOperation;

/**
 * 管理班组工序 数据层
 * @author Administrator
 *
 */
public interface ProdSFOperationMapper
{
	// 查询所有工序数据
	public List<ProdSFOperation> selectOperationList(ProdSFOperation op);
	// 根据Id查询工序
	public ProdSFOperation selectOperationById(Long opId);
	// 校验工序名称是否唯一
	public ProdSFOperation checkOperationNameUnique(@Param("name") String opName, @Param("groupId") Long groupId);
	// 新增工序
	public int insertOperation(ProdSFOperation op);
	// 修改工序
	public int updateOperation(ProdSFOperation op);
	// 通过Id删除工序
	public int deleteOperationById(Long opId);
}
