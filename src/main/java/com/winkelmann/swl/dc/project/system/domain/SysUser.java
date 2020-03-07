package com.winkelmann.swl.dc.project.system.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.winkelmann.swl.dc.framework.web.domain.BaseEntity;

/**
 * 用户对象 sys_user
 * @author Administrator
 *
 */
public class SysUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	// 用户Id
	private Long userId;
	// 部门Id
	private Long deptId;
	// 用户账号
	private String userName;
	// 用户名称
	private String nickName;
	// 用户邮箱
	private String email;
	// 手机号码
	private String phoneNumber;
	// 用户性别
	private String gender;
	// 用户头像
	private String avatar;
	// 密码
	private String password;
	// 盐加密
	private String salt;
	// 账号状态 0正常 1停用
	private String status;
	// 删除标识 0存在 2删除
	private String delFlag;
	// 最后登录IP
	private String loginIp;
	// 最后登录时间
	private Date loginDate;
	// 部门对象
	private SysDept dept;
	// 角色对象
	private List<SysRole> roles;
	// 角色组
	private Long[] roleIds;
	// 岗位组
	private Long[] positionIds;
	
	public SysUser()
	{
	}

	public SysUser(Long userId)
	{
		this.userId = userId;
	}
	
	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getDeptId()
	{
		return deptId;
	}

	public void setDeptId(Long deptId)
	{
		this.deptId = deptId;
	}

	@NotBlank(message = "用户账号不能为空")
	@Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Size(min = 0, max = 30, message = "用户名称长度不能超过30个字符")
	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	@Email(message = "邮箱格式不正确")
	@Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	@JsonProperty
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getDelFlag()
	{
		return delFlag;
	}

	public void setDelFlag(String delFlag)
	{
		this.delFlag = delFlag;
	}

	public String getLoginIp()
	{
		return loginIp;
	}

	public void setLoginIp(String loginIp)
	{
		this.loginIp = loginIp;
	}

	public Date getLoginDate()
	{
		return loginDate;
	}

	public void setLoginDate(Date loginDate)
	{
		this.loginDate = loginDate;
	}

	public SysDept getDept()
	{
		return dept;
	}

	public void setDept(SysDept dept)
	{
		this.dept = dept;
	}

	public List<SysRole> getRoles()
	{
		return roles;
	}

	public void setRoles(List<SysRole> roles)
	{
		this.roles = roles;
	}

	public Long[] getRoleIds()
	{
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds)
	{
		this.roleIds = roleIds;
	}

	public Long[] getPositionIds()
	{
		return positionIds;
	}

	public void setPositionIds(Long[] positionIds)
	{
		this.positionIds = positionIds;
	}
	
	public boolean isAdmin()
	{
		 return isAdmin(this.userId);
	}
	
	public static boolean isAdmin(Long userId)
	{
		return userId != null && 1L == userId;
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("userId", getUserId())
				.append("deptId", getDeptId())
				.append("userName", getUserName())
				.append("nickName", getNickName())
				.append("email", getEmail())
				.append("phoneNumber", getPhoneNumber())
				.append("gender", getGender())
				.append("avatar", getAvatar())
				.append("password", getPassword())
				.append("salt", getSalt())
				.append("delFlag", getDelFlag())
				.append("loginIP", getLoginIp())
				.append("loginDate", getLoginDate())
				.append("createBy", getCreateBy())
				.append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime())
				.append("remark", getRemark())
				.append("dept", getDept())
				.toString();
	}
}
