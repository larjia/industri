package com.winkelmann.swl.dc.project.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winkelmann.swl.dc.common.constant.UserConstants;
import com.winkelmann.swl.dc.common.exception.CustomException;
import com.winkelmann.swl.dc.common.utils.SecurityUtils;
import com.winkelmann.swl.dc.common.utils.StringUtils;
import com.winkelmann.swl.dc.framework.aspectj.lang.annotation.DataScope;
import com.winkelmann.swl.dc.project.system.domain.SysPosition;
import com.winkelmann.swl.dc.project.system.domain.SysRole;
import com.winkelmann.swl.dc.project.system.domain.SysUser;
import com.winkelmann.swl.dc.project.system.domain.SysUserPosition;
import com.winkelmann.swl.dc.project.system.domain.SysUserRole;
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
	
	/**
	 * 根据条件分页查询用户列表
	 */
	@Override
	@DataScope()
	public List<SysUser> selectUserList(SysUser user)
	{
		return userMapper.selectUserList(user);
	}
	
	/**
	 * 通过用户名查询用户
	 */
	@Override
	public SysUser selectUserByUserName(String userName)
	{
		return userMapper.selectUserByUserName(userName);
	}
	
	/**
	 * 通过用户Id查询用户
	 */
	@Override
	public SysUser selectUserById(Long userId)
	{
		return userMapper.selectUserById(userId);
	}
	
	/**
	 * 查询用户所属角色组
	 */
	@Override
	public String selectUserRoleGroup(String userName)
	{
		List<SysRole> list = roleMapper.selectRolesByUserName(userName);
		StringBuffer idsStr = new StringBuffer();
		for (SysRole role : list)
		{
			idsStr.append(role.getRoleName()).append(",");
		}
		if (StringUtils.isNotEmpty(idsStr.toString()))
		{
			return idsStr.substring(0, idsStr.length() - 1);
		}
		
		return idsStr.toString();
	}
	
	/**
	 * 查询用户所属岗位组
	 */
	@Override
	public String selectUserPositionGroup(String userName)
	{
		List<SysPosition> list = positionMapper.selectPositionsByUserName(userName);
		StringBuffer idsStr = new StringBuffer();
		for (SysPosition position : list)
		{
			idsStr.append(position.getPositionName()).append(",");
		}
		if (StringUtils.isNotEmpty(idsStr.toString()))
		{
			return idsStr.substring(0, idsStr.length() - 1);
		}
		
		return idsStr.toString();
	}
	
	/**
	 * 校验用户名称是否唯一
	 */
	@Override
	public String checkUserNameUnique(String userName)
	{
		int count = userMapper.checkUserNameUnique(userName);
		if (count > 0)
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}
	
	/**
	 * 校验电话是否唯一
	 */
	@Override
	public String checkPhoneUnique(SysUser user)
	{
		Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
		SysUser info = userMapper.checkPhoneUnique(user.getPhoneNumber());
		if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}
	
	/**
	 * 检验Email是否唯一
	 */
	@Override
	public String checkEmailUnique(SysUser user)
	{
		Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
		SysUser info = userMapper.checkEmailUnique(user.getEmail());
		if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
		{
			return UserConstants.NOT_UNIQUE;
		}
		return UserConstants.UNIQUE;
	}
	
	/**
	 * 校验用户是否允许操作
	 */
	public void checkUserAllowed(SysUser user)
	{
		if (StringUtils.isNotNull(user.getUserId()) && user.isAdmin())
		{
			throw new CustomException("不允许操作超级管理员用户");
		}
	}
	
	/**
	 * 新增保存用户信息
	 */
	@Override
	@Transactional
	public int insertUser(SysUser user)
	{
		// 新增用户信息
		int rows = userMapper.insertUser(user);
		// 新增用户岗位关联
		insertUserPosition(user);
		// 新增用户与角色管理
		insertUserPosition(user);
		return rows;
	}
	
	/**
	 * 修改保存用户信息
	 */
	@Override
	@Transactional
	public int updateUser(SysUser user)
	{
		Long userId = user.getUserId();
		// 删除用户与角色关联
		userRoleMapper.deleteUserRoleByUserId(userId);
		// 新增用户与角色管理
		insertUserRole(user);
		// 删除用户与岗位管理
		userPositionMapper.deleteUserPositionByUserId(userId);
		// 新增用户与岗位管理
		insertUserPosition(user);
		
		return userMapper.updateUser(user);
	}
	
	/**
	 * 修改用户状态
	 */
	@Override
	public int updateUserStatus(SysUser user)
	{
		return userMapper.updateUser(user);
	}
	
	/**
	 * 修改用户基本信息
	 */
	@Override
	public int updateUserProfile(SysUser user)
	{
		return userMapper.updateUser(user);
	}
	
	/**
	 * 修改用户头像
	 */
	public boolean updateUserAvatar(String userName, String avatar)
	{
		return userMapper.updateUserAvatar(userName, avatar) > 0;
	}
	
	/**
	 * 重置用户密码
	 */
	@Override
	public int resetPwd(SysUser user)
	{
		return userMapper.updateUser(user);
	}
	
	/**
	 * 重置用户密码
	 */
	@Override
	public int resetUserPwd(String userName, String password)
	{
		return userMapper.resetUserPwd(userName, password);
	}
	
	/**
	 * 新增用户角色信息
	 */
	public void insertUserRole(SysUser user)
	{
		Long[] roles = user.getRoleIds();
		if (StringUtils.isNotNull(roles))
		{
			// 新增用户与角色管理
			List<SysUserRole> list = new ArrayList<SysUserRole>();
			for (Long roleId : roles)
			{
				SysUserRole ur = new SysUserRole();
				ur.setUserId(user.getUserId());
				ur.setRoleId(roleId);
				list.add(ur);
			}
			if (list.size() > 0)
			{
				userRoleMapper.batchUserRole(list);
			}
		}
	}
	
	/**
	 * 新增用户岗位信息
	 */
	public void insertUserPosition(SysUser user)
	{
		Long[] positions = user.getPositionIds();
		if (StringUtils.isNotNull(positions))
		{
			// 新增用户与岗位管理
			List<SysUserPosition> list = new ArrayList<SysUserPosition>();
			for (Long positionId : positions)
			{
				SysUserPosition up = new SysUserPosition();
				up.setUserId(user.getUserId());
				up.setPositionId(positionId);
				list.add(up);
			}
			if (list.size() > 0)
			{
				userPositionMapper.batchUserPosition(list);
			}
		}
	}
	
	/**
	 * 通过用户Id删除用户
	 */
	@Override
	public int deleteUserById(Long userId)
	{
		// 删除用户与角色关联
		userRoleMapper.deleteUserRoleByUserId(userId);
		// 删除用户与岗位表
		userPositionMapper.deleteUserPositionByUserId(userId);
		return userMapper.deleteUserById(userId);
	}
	
	/**
	 * 批量删除用户信息
	 */
	public int deleteUserByIds(Long[] userIds)
	{
		for (Long userId : userIds)
		{
			checkUserAllowed(new SysUser(userId));
		}
		return userMapper.deleteUserByIds(userIds);
	}
	
	/**
	 * 导入用户数据
	 */
	@Override
	public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName)
	{
		if (StringUtils.isNull(userList) || userList.size() == 0)
		{
			throw new CustomException("导入用户数据不能为空!");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		String password = configService.selectConfigByKey("sys.user.initPassword");
		for (SysUser user : userList)
		{
			try
			{
				// 验证是否存在这个用户
				SysUser u = userMapper.selectUserByUserName(user.getUserName());
				if (StringUtils.isNull(u))
				{
					user.setPassword(SecurityUtils.encryptPassword(password));
					user.setCreateBy(operName);
					this.insertUser(user);
					successNum++;
					successMsg.append("<br/>" + successNum + ": 账号" + user.getUserName() + " 导入成功");
				}
				else if (isUpdateSupport)
				{
					user.setUpdateBy(operName);
					this.updateUser(user);
					successNum++;
					successMsg.append("<br/>" + successNum + ": 账号 " + user.getUserName() + " 更新成功");
				}
				else
				{
					failureNum++;
					failureMsg.append("<br/>" + failureNum + ": 账号 " + user.getUserName() + " 已存在");
				}
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + ": 账号 " + user.getUserName() + " 导入失败: ";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉, 导入失败!共 " + failureNum + " 条数据格式不正确,错误如下: ");
			throw new CustomException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您, 数据已全部导入成功! 共 " + successNum + " 条, 数据如下: ");
		}
		return successMsg.toString();
	}
}
