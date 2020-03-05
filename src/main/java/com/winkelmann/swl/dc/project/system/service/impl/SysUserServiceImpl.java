package com.winkelmann.swl.dc.project.system.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmann.swl.dc.project.system.mapper.SysPositionMapper;
import com.winkelmann.swl.dc.project.system.mapper.SysRoleMapper;
import com.winkelmann.swl.dc.project.system.mapper.SysUserMapper;
import com.winkelmann.swl.dc.project.system.mapper.SysUserPositionMapper;
import com.winkelmann.swl.dc.project.system.mapper.SysUserRoleMapper;
import com.winkelmann.swl.dc.project.system.service.ISysConfigService;
import com.winkelmann.swl.dc.project.system.service.ISysUserService;

/**
 * 用户 业务层处理
 * @author JiangL
 *
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
	private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysPositionMapper positionMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	@Autowired
	private SysUserPositionMapper userPositionMapper;
	
	@Autowired
	private ISysConfigService configService;
	
	
}
