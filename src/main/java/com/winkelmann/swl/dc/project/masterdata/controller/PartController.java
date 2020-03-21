package com.winkelmann.swl.dc.project.masterdata.controller;

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
import com.winkelmann.swl.dc.project.masterdata.domain.Part;
import com.winkelmann.swl.dc.project.masterdata.service.IPartService;

/**
 * 物料Controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/masterdata/part")
public class PartController extends BaseController
{
	@Autowired
	private IPartService partService;
	
	@GetMapping("/list")
	public TableDataInfo list(Part part)
	{
		startPage();
		List<Part> list = partService.selectPartList(part);
		return getDataTable(list);
	}
	
	@GetMapping("/id/{id}")
	public AjaxResult getPartById(@PathVariable Long id)
	{
		return AjaxResult.success(partService.selectPartById(id));
	}
	
	@GetMapping("/number/{partNumber}")
	public AjaxResult getPartByNumber(@PathVariable String partNumber)
	{
		return AjaxResult.success(partService.selectPartByNumber(partNumber));
	}
	
	@Log(title = "物料管理", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@PathVariable @RequestBody Part part)
	{
		if (UserConstants.NOT_UNIQUE.equals(partService.checkPartNumberUnique(part)))
		{
			return AjaxResult.error("新增物料'" + part.getPartNumber() + "'失败,物料编码已存在.");
		}
		part.setCreateBy(SecurityUtils.getUserName());
		return toAjax(partService.insertPart(part));
	}
	
	@Log(title = "物料管理", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@PathVariable @RequestBody Part part)
	{
		if (UserConstants.NOT_UNIQUE.equals(partService.checkPartNumberUnique(part)))
		{
			return AjaxResult.error("修改物料'" + part.getPartNumber() + "'失败,物料编码已经存在.");
		}
		part.setUpdateBy(SecurityUtils.getUserName());
		return toAjax(partService.updatePart(part));
	}
	
	@Log(title = "物料管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
	public AjaxResult remove(@PathVariable Long id)
	{
		return toAjax(partService.deletePartById(id));
	}
}
