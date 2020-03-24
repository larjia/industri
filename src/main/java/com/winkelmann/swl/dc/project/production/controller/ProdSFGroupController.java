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
import com.winkelmann.swl.dc.project.production.domain.ProdSFGroup;
import com.winkelmann.swl.dc.project.production.service.IProdSFGroupService;

/**
 * 生产车间班组信息
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/production/sf/group")
public class ProdSFGroupController extends BaseController
{
	@Autowired
	private IProdSFGroupService groupService;
	
	/**
	 * 获取班组列表
	 */
	@GetMapping("/list")
//	public AjaxResult list()
//	{
//		List<ProdShopFloorGroup> groups = shopFloorGroupService.selectShopFloorGroupList();
//		return AjaxResult.success(groups);
//	}
	public TableDataInfo list(ProdSFGroup group)
	{
		startPage();
		List<ProdSFGroup> list = groupService.selectGroupList(group);
		return getDataTable(list);
	}
	
	/**
	 * 根据班组Id获取班组信息
	 */
	@GetMapping("/{groupId}")
	public AjaxResult getInfoById(@PathVariable Long groupId)
	{
		return AjaxResult.success(groupService.selectGroupById(groupId));
	}
	
	/**
	 * 根据车间Id获取班组
	 */
	@GetMapping("/getgroupbydeptid/{deptId}")
	public AjaxResult getGroupByDeptId(@PathVariable Long deptId)
	{
		return AjaxResult.success(groupService.selectGroupByDeptId(deptId));
	}
	
	/**
	 * 新增班组
	 */
	@Log(title = "班组管理", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@Validated @RequestBody ProdSFGroup group)
	{
		if (UserConstants.NOT_UNIQUE.equals(groupService.checkGroupNameUnique(group)))
		{
			return AjaxResult.error("新增班组'" + group.getName() + "'失败, 班组名称已存在.");
		}
		group.setCreateBy(SecurityUtils.getUserName());
		return toAjax(groupService.insertGroup(group));
	}
	
	/**
	 * 修改班组
	 */
	@Log(title = "班组管理", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@Validated @RequestBody ProdSFGroup group)
	{
		if (UserConstants.NOT_UNIQUE.equals(groupService.checkGroupNameUnique(group)))
		{
			return AjaxResult.error("修改部门'" + group.getName() + "'失败, 部门名称已存在.");
		}
		// TODO 增加班组所属部门是否为车间部门的校验.班组所属部门需为车间部门
		group.setUpdateBy(SecurityUtils.getUserName());
		return toAjax(groupService.updateGroup(group));
	}
	
	/**
	 * 删除班组
	 */
	@Log(title = "班组管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groupId}")
	public AjaxResult remove(@PathVariable Long groupId)
	{
		// TODO 校验不允许删除班组的情况
		return toAjax(groupService.deleteGroupById(groupId));
	}
}
