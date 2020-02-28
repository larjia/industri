package com.winkelmann.swl.dc.project.system.domain;

import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;

/*
 * 角色表 sys_role
 */
public class SysRole extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// 角色Id
	private Long roleId;
	// 角色名称
	private String roleName;
	// 角色权限
	private String roleKey;
	// 角色排序
	private String roleSort;
	// 数据范围(1.所有数据权限 2.自定义数据权限 3.本部门数据权限 4.本部门及以下数据权限)
	private String dataScope;
	
}
