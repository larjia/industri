package com.winkelmann.swl.dc.project.production.mapper;

import java.util.List;

import com.winkelmann.swl.dc.project.production.domain.ProdSFPPM;

/**
 * 车间PPM 数据层
 * @author Administrator
 *
 */
public interface ProdSFPPMMapper
{
	// 查询所有PPM数据
	public List<ProdSFPPM> selectProdSFPPMList(ProdSFPPM ppm);
}
