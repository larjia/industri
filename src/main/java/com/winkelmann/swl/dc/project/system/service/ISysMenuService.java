package com.winkelmann.swl.dc.project.system.service;

import java.util.List;
import java.util.Set;

import com.winkelmann.swl.dc.framework.web.domain.TreeSelect;
import com.winkelmann.swl.dc.project.system.domain.SysMenu;
import com.winkelmann.swl.dc.project.system.domain.vo.RouterVo;

/**
 * 菜单业务层
 * @author JiangL
 *
 */
public interface ISysMenuService
{
	// 根据用户查询系统菜单列表
	public List<SysMenu> selectMenuList(Long userId);
	// 根据用户查询系统菜单列表
	public List<SysMenu> selectMenuList(SysMenu menu, Long userId);
	// 根据用户Id查询权限
	public Set<String> selectMenuPermsByUserId(Long userId);
	// 根据用户Id查询菜单树信息
	public List<SysMenu> selectMenuTreeByUserId(Long userId);
	// 根据角色Id查询菜单树信息
	public List<Integer> selectMenuListByRoleId(Long roleId);
	// 构建前端路由所需要的菜单
	public List<RouterVo> buildMenus(List<SysMenu> menus);
	// 构建前端所需要树结构
	public List<SysMenu> buildMenuTree(List<SysMenu> menus);
	// 构建前端所需要下拉树结构
	public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);
	// 根据菜单Id查询信息
	public SysMenu selectMenuById(Long menuId);
	// 是否存在菜单子节点
	public boolean hasChildByMenuId(Long menuId);
	// 查询菜单是否存在角色
	public boolean checkMenuExistRole(Long menuId);
	// 新增保存菜单信息
	public int insertMenu(SysMenu menu);
	// 修改保存菜单信息
	public int updateMenu(SysMenu menu);
	// 删除菜单管理信息
	public int deleteMenuById(Long menuId);
	// 校验菜单名称是否唯一
	public String checkMenuNameUnique(SysMenu menu);
}
