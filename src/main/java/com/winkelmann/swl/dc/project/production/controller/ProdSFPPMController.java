package com.winkelmann.swl.dc.project.production.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winkelmann.swl.dc.framework.web.controller.BaseController;
import com.winkelmann.swl.dc.framework.web.page.TableDataInfo;
import com.winkelmann.swl.dc.project.production.domain.ProdSFPPM;
import com.winkelmann.swl.dc.project.production.service.IProdSFPPMService;

/**
 * 质量PPM信息
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/production/quality/ppm")
public class ProdSFPPMController extends BaseController
{
	@Autowired
	private IProdSFPPMService prodSFPPMService;
	
	/**
	 * 获取质量PPM列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(ProdSFPPM ppm)
	{
		startPage();
		List<ProdSFPPM> list = prodSFPPMService.selectProdSFPPMList(ppm);
		return getDataTable(list);
	}
}
