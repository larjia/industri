package com.winkelmann.swl.dc.framework.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 用户验证处理
 * @author JiangL
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private ISysUserService userService;
	
	
}
