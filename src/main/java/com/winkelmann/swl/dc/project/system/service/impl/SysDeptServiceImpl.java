package com.winkelmann.swl.dc.project.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.exception.CustomException;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.framework.aspectj.lang.annotation.DataScope;
import com.winkelmann.swl.dc.framework.web.domain.TreeSelect;
import com.winkelmann.swl.dc.project.system.domain.SysDept;
import com.winkelmann.swl.dc.project.system.mapper.SysDeptMapper;
import com.winkelmann.swl.dc.project.system.service.ISysDeptService;

/**
 * 部门管理 服务实现
 * @author JiangL
 *
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService
{
	@Autowired
	private SysDeptMapper deptMapper;

	/**
	 * 查询部门管理数据
	 */
	@Override
	@DataScope(deptAlias = "d")
	public List<SysDept> selectDeptList(SysDept dept)
	{
		return deptMapper.selectDeptList(dept);
	}

	/**
	 * 查询车间部门
	 */
	@Override
	public List<SysDept> selectProdDeptList(SysDept dept)
	{
		return deptMapper.selectProdDeptList(dept);
	}

	/**
	 * 构建前端所需要树结构
	 */
	@Override
	public List<SysDept> buildDeptTree(List<SysDept> depts)
	{
		List<SysDept> returnList = new ArrayList<SysDept>();
		List<Long> tempList = new ArrayList<Long>();
		for (SysDept dept : depts)
		{
			tempList.add(dept.getDeptId());
		}
		for (Iterator<SysDept> iterator = depts.iterator(); iterator.hasNext();)
		{
			SysDept dept = (SysDept) iterator.next();
			// 如果是顶级节点,遍历该父节点的所有子节点
			if (!tempList.contains(dept.getParentId()))
			{
				recursionFn(depts, dept);
				returnList.add(dept);
			}
		}
		
		if (returnList.isEmpty())
		{
			returnList = depts;
		}
		return returnList;
	}

	/**
	 * 构建前端所需下拉树结构
	 */
	@Override
	public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts)
	{
		List<SysDept> deptTrees = buildDeptTree(depts);
		return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
	}

	/**
	 * 根据角色Id查询部门树信息
	 */
	@Override
	public List<Integer> selectDeptListByRoleId(Long roleId)
	{
		return deptMapper.selectDeptListByRoleId(roleId);
	}

	/**
	 * 根据部门Id查询信息
	 */
	@Override
	public SysDept selectDeptById(Long deptId)
	{
		return deptMapper.selectDeptById(deptId);
	}

	/**
	 * 是否存在子节点
	 */
	@Override
	public boolean hasChildByDeptId(Long deptId)
	{
		int result = deptMapper.hasChildByDeptId(deptId);
		return result > 0 ? true : false;
	}

	/**
	 * 查询部门是否存在用户
	 */
	@Override
	public boolean checkDeptExistUser(Long deptId)
	{
		int result = deptMapper.checkDeptExistUser(deptId);
		return result > 0 ? true : false;
	}

	/**
	 * 检验部门名称是否唯一
	 */
	@Override
	public String checkDeptNameUnique(SysDept dept)
	{
		Long deptId = StringUtils.isNull(dept.getDeptId()) ? -1L : dept.getDeptId();
		SysDept info = deptMapper.checkDeptNameUnique(dept.getDeptName(), dept.getParentId());
		if (StringUtils.isNotNull(info) && info.getDeptId().longValue() != deptId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}

	/**
	 * 新增保存部门信息
	 */
	@Override
	public int insertDept(SysDept dept)
	{
		SysDept info = deptMapper.selectDeptById(dept.getDeptId());
		// 如果父节点不为正常状态,则不允许新增子节点
		if (!UserConstants.DEPT_NORMAL.equals(info.getStatus()))
		{
			throw new CustomException("部门停用,不允许新增");
		}
		dept.setAncestors(info.getAncestors() + "," + dept.getParentId());
		return deptMapper.insertDept(dept);
	}

	/**
	 * 修改保存部门信息
	 */
	@Override
	public int updateDept(SysDept dept)
	{
		SysDept newParentDept = deptMapper.selectDeptById(dept.getParentId());
		SysDept oldDept = deptMapper.selectDeptById(dept.getDeptId());
		if (StringUtils.isNotNull(newParentDept) && StringUtils.isNotNull(oldDept))
		{
			String newAncestors = newParentDept.getAncestors() + "," + newParentDept.getDeptId();
			String oldAncestors = oldDept.getAncestors();
			dept.setAncestors(newAncestors);
			updateDeptChildren(dept.getDeptId(), newAncestors, oldAncestors);
		}
		int result = deptMapper.updateDept(dept);
		if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
		{
			// 如果该部门是启用状态,则启用该部门的所有上级部门
			updateParentDeptStatus(dept);
		}
		return result;
	}
	
	/**
	 * 修改该部门的父级部门状态
	 */
	private void updateParentDeptStatus(SysDept dept)
	{
		String updateBy = dept.getUpdateBy();
		dept = deptMapper.selectDeptById(dept.getDeptId());
		dept.setUpdateBy(updateBy);
		deptMapper.updateDeptStatus(dept);
	}

	/**
	 * 修改子元素关系
	 */
	public void updateDeptChildren(Long deptId, String newAncestors, String oldAncestors)
	{
		List<SysDept> children = deptMapper.selectChildrenDeptById(deptId);
		for (SysDept child : children)
		{
			child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
		}
		if (children.size() > 0)
		{
			deptMapper.updateDeptChildren(children);
		}
	}
	
	/**
	 * 删除部门管理信息
	 */
	@Override
	public int deleteDeptById(Long deptId)
	{
		return deptMapper.deleteDeptById(deptId);
	}
	
	/**
	 * 递归列表
	 */
	private void recursionFn(List<SysDept> list, SysDept t)
	{
		// 得到子节点列表
		List<SysDept> childList = getChildList(list, t);
		t.setChildren(childList);
		for (SysDept tChild : childList)
		{
			if (hasChild(list, tChild))
			{
				// 判断是否有子节点
				Iterator<SysDept> it = childList.iterator();
				while (it.hasNext())
				{
					SysDept n = (SysDept) it.next();
					recursionFn(list, n);
				}
			}
		}
	}
	
	/**
	 * 得到子节点列表
	 */
	private List<SysDept> getChildList(List<SysDept> list, SysDept t)
	{
		List<SysDept> tlist = new ArrayList<SysDept>();
		Iterator<SysDept> it = list.iterator();
		while (it.hasNext())
		{
			SysDept n = (SysDept) it.next();
			if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getDeptId().longValue())
			{
				tlist.add(n);
			}
		}
		return tlist;
	}
	
	/**
	 * 判断是否有子节点
	 */
	private boolean hasChild(List<SysDept> list, SysDept t)
	{
		return getChildList(list, t).size() > 0 ? true : false;
	}
}
