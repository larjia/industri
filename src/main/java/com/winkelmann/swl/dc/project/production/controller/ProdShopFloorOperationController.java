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

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.utils.SecurityUtils;
import com.winkelmann.swl.dc.framework.aspectj.lang.annotation.Log;
import com.winkelmann.swl.dc.framework.aspectj.lang.enums.BusinessType;
import com.winkelmann.swl.dc.framework.web.controller.BaseController;
import com.winkelmann.swl.dc.framework.web.domain.AjaxResult;
import com.winkelmann.swl.dc.framework.web.page.TableDataInfo;
import com.winkelmann.swl.dc.project.production.domain.ProdShopFloorOperation;
import com.winkelmann.swl.dc.project.production.service.IProdShopFloorOperationService;

/**
 * 生产车间班组工序信息
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/production/shopfloor/operation")
public class ProdShopFloorOperationController extends BaseController
{
	@Autowired
	private IProdShopFloorOperationService operationService;
	
	/**
	 * 获取工序列表
	 */
	public TableDataInfo list(ProdShopFloorOperation op)
	{
		startPage();
		List<ProdShopFloorOperation> list = operationService.selectOperationList(op);
		return getDataTable(list);
	}
	
	/**
	 * 根据工序Id获取工序信息
	 */
	@GetMapping("/{opId}")
	public AjaxResult getInfoById(@PathVariable Long opId)
	{
		return AjaxResult.success(operationService.selectOperationById(opId));
	}
	
	/**
	 * 新增工序
	 */
	@Log(title = "工序管理", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@Validated @RequestBody ProdShopFloorOperation op)
	{
		if (UserConstants.NOT_UNIQUE.equals(operationService.checkOperationNameUnique(op)))
		{
			return AjaxResult.error("新增工序'" + op.getOperationName() + "'失败,工序名称已存在.");
		}
		op.setCreateBy(SecurityUtils.getUserName());
		return toAjax(operationService.insertOperation(op));
	}
	
	/**
	 * 修改工序
	 */
	@Log(title = "工序管理", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@Validated @RequestBody ProdShopFloorOperation op)
	{
		if (UserConstants.NOT_UNIQUE.equals(operationService.checkOperationNameUnique(op)))
		{
			return AjaxResult.error("修改工序'" + op.getOperationName() + "'失败,工序名称已存在.");
		}
		op.setUpdateBy(SecurityUtils.getUserName());
		return toAjax(operationService.updateOperation(op));
	}
	
	/**
	 * 删除工序
	 */
	@Log(title = "工序管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{opId}")
	public AjaxResult remove(@PathVariable Long opId)
	{
		// TODO 校验不允许删除工序的情况
		return toAjax(operationService.deleteOperationById(opId));
	}
}
