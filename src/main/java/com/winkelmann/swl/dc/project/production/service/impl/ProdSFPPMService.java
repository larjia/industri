package com.winkelmann.swl.dc.project.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.project.production.domain.ProdSFPPM;
import com.winkelmann.swl.dc.project.production.mapper.ProdSFPPMMapper;
import com.winkelmann.swl.dc.project.production.service.IProdSFPPMService;

/**
 * 质量PPM管理 服务层
 * @author Administrator
 *
 */
@Service
public class ProdSFPPMService implements IProdSFPPMService
{
	@Autowired
	private ProdSFPPMMapper prodSFPPMMapper;

	// 查询质量PPM数据
	@Override
	public List<ProdSFPPM> selectProdSFPPMList(ProdSFPPM ppm)
	{
		return prodSFPPMMapper.selectProdSFPPMList(ppm);
	}
}
