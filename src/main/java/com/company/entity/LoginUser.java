package com.company.entity;

import java.util.Date;

/**
TABLE:.t_user                   
--------------------------------------------------------
user_id              Integer(10)        NOTNULL             //用户id
user_account         String(20)                             //用户账号
user_password        String(20)                             //用户密码
user_name            String(20)                             //用户姓名
user_remarks         String(255)                            //备注说明
user_id     		 Integer(10)                            //角色ID
*/
public class LoginUser {
	private	Integer userId;
	private	String userAccount;
	private	String userPassword;
	private	String userName;
	private	String userRemarks;
	private	Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

}