package com.winkelmann.swl.dc.project.system.controller;

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
import com.winkelmann.swl.dc.project.system.domain.SysDictData;
import com.winkelmann.swl.dc.project.system.service.ISysDictDataService;

/**
 * 数据字典信息
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController extends BaseController
{
	@Autowired
	private ISysDictDataService dictDataService;
	
	@GetMapping("/list")
	public TableDataInfo list(SysDictData dictData)
	{
		startPage();
		List<SysDictData> list = dictDataService.selectDictDataList(dictData);
		return getDataTable(list);
	}
	
	/**
	 * 查询字典数据详细
	 */
	@GetMapping("/{dictCode}")
	public AjaxResult getInfo(@PathVariable Long dictCode)
	{
		return AjaxResult.success(dictDataService.selectDictDataById(dictCode));
	}
	
	/**
	 * 根据字典类型查询字典数据信息
	 */
	@GetMapping("/dictType/{dictType}")
	public AjaxResult dictType(@PathVariable String dictType)
	{
		return AjaxResult.success(dictDataService.selectDictDataByType(dictType));
	}
	
	/**
	 * 新增字典类型
	 */
	@Log(title = "字典数据", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@Validated @RequestBody SysDictData dict)
	{
		dict.setCreateBy(SecurityUtils.getUserName());
		return toAjax(dictDataService.insertDictData(dict));
	}
	
	/**
	 * 修改保存字典类型
	 */
	@Log(title = "字典数据", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@Validated @RequestBody SysDictData dict)
	{
		dict.setUpdateBy(SecurityUtils.getUserName());
		return toAjax(dictDataService.updateDictData(dict));
	}
	
	/**
	 * 删除字典类型
	 */
	@Log(title = "字典类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dictCodes}")
	public AjaxResult remove(@PathVariable Long[] dictCodes)
	{
		return toAjax(dictDataService.deleteDictDataByIds(dictCodes));
	}
}
