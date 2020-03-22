package com.winkelmann.swl.dc.project.production.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.winkelmann.swl.dc.project.production.domain.ProdOpRejectReason;
import com.winkelmann.swl.dc.project.production.service.IProdOpRejectReasonService;

/**
 * 工序不良原因
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/production/sf/oprejectreason/")
public class ProdOpRejectReasonController extends BaseController
{
	@Autowired
	private IProdOpRejectReasonService reasonService;
	
	@GetMapping("/list")
	public TableDataInfo list(ProdOpRejectReason reason)
	{
		List<ProdOpRejectReason> list = reasonService.selectReasonList(reason);
		return getDataTable(list);
	}
	
	/**
	 * 新增工序不良原因
	 * @param reason
	 * @return
	 */
	@Log(title = "工序不良原因管理", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@PathVariable @RequestBody ProdOpRejectReason reason)
	{
		if (UserConstants.NOT_UNIQUE.equals(reasonService.checkReasonNameUnique(reason)))
		{
			return AjaxResult.error("新增原因'" + reason.getReason() + "'失败,原因名称已存在.");
		}
		reason.setCreateBy(SecurityUtils.getUserName());
		return toAjax(reasonService.insertReason(reason));
	}
	
	/**
	 * 修改工序不良原因
	 */
	@Log(title = "工序不良原因管理", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@PathVariable @RequestBody ProdOpRejectReason reason)
	{
		if (UserConstants.NOT_UNIQUE.equals(reasonService.checkReasonNameUnique(reason)))
		{
			return AjaxResult.error("修改原因'" + reason.getReason() + "'失败,原因名称已存在.");
		}
		reason.setUpdateBy(SecurityUtils.getUserName());
		return toAjax(reasonService.updateReason(reason));
	}
	
	/**
	 * 删除原因
	 */
	@Log(title = "工序不良原因管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
	public AjaxResult remove(@PathVariable Long id)
	{
		return toAjax(reasonService.deleteReasonById(id));
	}
}
