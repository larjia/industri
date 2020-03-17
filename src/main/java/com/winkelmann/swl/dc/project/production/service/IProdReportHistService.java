package com.winkelmann.swl.dc.project.production.service;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdReportHist;

/**
 * 生产报工数据管理 服务层
 * @author Administrator
 *
 */
public interface IProdReportHistService
{
	// 查询所有生产报工数据
	public List<ProdReportHist> selectProdReportHistList(ProdReportHist reportHist);
}
