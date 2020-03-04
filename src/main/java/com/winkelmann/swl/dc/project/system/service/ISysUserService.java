package com.winkelmann.swl.dc.project.system.service;

import java.util.List;

import com.winkelmann.swl.dc.project.system.domain.SysUser;

/**
 * 用户 业务层
 * @author JiangL
 *
 */
public interface ISysUserService
{
	// 根据条件分页查询用户列表
	public List<SysUser> selectUserList(SysUser user);
	// 通过用户名查询用户
	public SysUser selectUserByUserName(String userName);
	// 通过用户Id查询用户
	public SysUser selectUserById(Long userId);
	// 根据用户Id查询用户所属角色组
	public String selectUserRoleGroup(String userName);
	// 根据用户Id查询用户所属岗位组
	public String selectUserPostGroup(String userName);
	// 校验用户名称是否唯一
	public String checkUserNameUnique(String userName);
	// 校验手机号码是否唯一
	public String checkPhoneUnique(SysUser user);
	// 校验Email是否唯一
	public String checkEmailUnique(SysUser user);
	// 校验用户是否允许操作
	public void checkUserAllowed(SysUser user);
	// 新增用户信息
	public int insertUser(SysUser user);
	// 修改用户信息
	public int updateUser(SysUser user);
	// 修改用户状态
	public int updateUserStatus(SysUser user);
	// 修改用户基本信息
	public int updateUserProfile(SysUser user);
	// 修改用户头像
	public boolean updateUserAvatar(String userName, String avatar);
	// 重置用户密码
	public int resetPwd(SysUser user);
	// 重置用户密码
	public int resetUserPwd(String userName, String password);
	// 通过用户Id删除用户
	public int deleteUserById(Long userId);
	// 批量删除用户信息
	public int deleteUserByIds(Long[] userIds);
	// 导入用户数据
	public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName);
}
