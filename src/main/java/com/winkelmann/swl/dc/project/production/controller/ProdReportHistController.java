package com.winkelmann.swl.dc.project.production.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winkelmann.swl.dc.common.utils.SecurityUtils;
import com.winkelmann.swl.dc.framework.aspectj.lang.annotation.Log;
import com.winkelmann.swl.dc.framework.aspectj.lang.enums.BusinessType;
import com.winkelmann.swl.dc.framework.web.controller.BaseController;
import com.winkelmann.swl.dc.framework.web.domain.AjaxResult;
import com.winkelmann.swl.dc.framework.web.page.TableDataInfo;
import com.winkelmann.swl.dc.project.production.domain.ProdReportHist;
import com.winkelmann.swl.dc.project.production.service.IProdReportHistService;

/**
 * 生产报工信息
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/production/report/prodreporthist")
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
	
	/**
	 * 根据Id获取生产报工信息
	 */
	@GetMapping("/{id}")
	public AjaxResult getInfoById(@PathVariable Long id)
	{
		return AjaxResult.success(prodReportHistService.selectProdReportHistById(id));
	}
	
	/**
	 * 新增生产报工
	 */
	@Log(title = "生产报工", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@Validated @RequestBody ProdReportHist reportHist)
	{
		reportHist.setCreateBy(SecurityUtils.getUserName());
		return toAjax(prodReportHistService.insertProdReportHist(reportHist));
	}
	
	/**
	 * 修改生产报工
	 */
	@Log(title = "生产报工", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@Validated @RequestBody ProdReportHist reportHist)
	{
		reportHist.setUpdateBy(SecurityUtils.getUserName());
		return toAjax(prodReportHistService.updateProdReportHist(reportHist));
	}
	
	/**
	 * 根据Id删除生产报工
	 */
	@Log(title = "生产报工", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
	public AjaxResult remove(@PathVariable Long id)
	{
		// TODO 校验不允许删除生产报工的情况
		return toAjax(prodReportHistService.deleteProdReportHistById(id));
	}
}
