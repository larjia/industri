package com.winkelmann.swl.dc.project.production.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winkelmann.swl.dc.framework.web.controller.BaseController;
import com.winkelmann.swl.dc.framework.web.page.TableDataInfo;
import com.winkelmann.swl.dc.project.production.domain.ProdReportHist;
import com.winkelmann.swl.dc.project.production.service.IProdReportHistService;

/**
 * 生产报工信息
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/production/prodreporthist/")
public class ProdReportHistController extends BaseController
{
	@Autowired
	private IProdReportHistService prodReportHistService;
	
	/**
	 * 获取生产报工信息列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(ProdReportHist reportHist)
	{
		startPage();
		List<ProdReportHist> list = prodReportHistService.selectProdReportHistList(reportHist);
		return getDataTable(list);
	}
}
