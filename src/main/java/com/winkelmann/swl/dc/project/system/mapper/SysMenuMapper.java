package com.winkelmann.swl.dc.project.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winkelmann.swl.dc.project.system.domain.SysMenu;

/**
 * 菜单表 数据层
 * @author JiangL
 *
 */
public interface SysMenuMapper
{
	/**
	 * 查询系统菜单列表
	 */
	public List<SysMenu> selectMenuList(SysMenu menu);
	
	/**
	 * 查询用户所有权限
	 * @return 权限列表
	 */
	public List<String> selectMenuPerms();
	
	/**
	 * 根据用户查询系统菜单列表
	 */
	public List<SysMenu> selectMenuListByUserId(SysMenu menu);
	
	/**
	 * 根据用户Id查询权限
	 */
	public List<String> selectMenuPermsByUserId(Long userId);
	
	/**
	 * 根据用户Id查询菜单
	 */
	public List<SysMenu> selectMenuTreeAll();
	
	/**
	 * 根据用户Id查询菜单
	 */
	public List<SysMenu> selectMenuTreeByUserId(Long userId);
	
	/**
	 * 根据角色Id查询菜单树信息
	 */
	public List<Integer> selectMenuListByRoleId(Long roleId);
	
	/**
	 * 根据菜单Id查询信息
	 */
	public SysMenu selectMenuById(Long menuId);
	
	/**
	 * 是否存在菜单子节点
	 */
	public int hasChildByMenuId(Long menuId);
	
	/**
	 * 新增菜单信息
	 */
	public int insertMenu(SysMenu menu);
	
	/**
	 * 修改菜单信息
	 */
	public int updateMenu(SysMenu menu);
	
	/**
	 * 删除菜单管理信息
	 */
	public int deleteMenuById(Long menuId);
	
	/**
	 * 检验菜单名称是否唯一
	 */
	public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
}

