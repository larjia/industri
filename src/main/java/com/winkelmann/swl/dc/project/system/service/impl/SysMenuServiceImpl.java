package com.winkelmann.swl.dc.project.system.service.impl;

import java.util.List;
import java.util.Set;

import com.winkelmann.swl.dc.framework.web.domain.TreeSelect;
import com.winkelmann.swl.dc.project.system.domain.SysMenu;
import com.winkelmann.swl.dc.project.system.domain.vo.RouterVo;
import com.winkelmann.swl.dc.project.system.service.ISysMenuService;

/**
 * 菜单业务层处理
 * @author JiangL
 *
 */
public class SysMenuServiceImpl implements ISysMenuService
{
	public static final String PREMISSION_STRING = "perms[\"{0}\"]";

	@Override
	public List<SysMenu> selectMenuList(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> selectMenuList(SysMenu menu, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> selectMenuPermsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> selectMenuTreeByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectMenuListByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RouterVo> buildMenus(List<SysMenu> menus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> buildMenuTree(List<SysMenu> menus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysMenu selectMenuById(Long menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildByMenuId(Long menuId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkMenuExistRole(Long menuId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertMenu(SysMenu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMenu(SysMenu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMenuById(Long menuId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String checkMenuNameUnique(SysMenu menu) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
