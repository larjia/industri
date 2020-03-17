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
}
