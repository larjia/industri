package com.winkelmann.swl.dc.project.production.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdReportHist;

/**
 * 生产报工 数据层
 * @author Administrator
 *
 */
public interface ProdReportHistMapper
{
	// 查询所有生产报工数据
	public List<ProdReportHist> selectProdReportHistList(ProdReportHist reportHist);
	// 根据Id查询生产报工记录
	public ProdReportHist selectProdReportHistById(Long id);
	// 新增生产报工
	public int insertProdReportHist(ProdReportHist prodReport);
	// 修改生产报工
	public int updateProdReportHist(ProdReportHist prodReport);
	// 通过Id删除生产报工
	public int deleteProdReportHist(Long id);
}
