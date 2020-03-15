package com.winkelmann.swl.dc.project.production.service;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdSFPPM;

/**
 * 质量PPM管理 服务层
 * @author Administrator
 *
 */
public interface IProdSFPPMService
{
	// 查询所有质量PPM数据
	public List<ProdSFPPM> selectProdSFPPMList(ProdSFPPM ppm);
}
