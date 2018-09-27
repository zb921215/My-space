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
create_by            Integer(10)                            //建表人ID
create_time          Date(19)                    CURRENT_TIMESTAMP //建表时间
update_by            Integer(10)                            //更新人ID
update_time          Date(19)                    CURRENT_TIMESTAMP //更新时间
*/
public class
User {
	private	Integer userId;
	private	String userAccount;
	private	String userPassword;
	private	String userName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	private	Integer roleId;
	private	String userRemarks;
	private	Integer createBy;
	private	Date createTime;
	private	Integer updateBy;
	private	Date updateTime;

	/**
	* user_id  Integer(10)  NOTNULL  //用户id    
	*/
	public Integer getUserId(){
		return userId;
	}
	
	/**
	* user_id  Integer(10)  NOTNULL  //用户id    
	*/
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	/**
	* user_account  String(20)  //用户账号    
	*/
	public String getUserAccount(){
		return userAccount;
	}
	
	/**
	* user_account  String(20)  //用户账号    
	*/
	public void setUserAccount(String userAccount){
		this.userAccount = userAccount;
	}
	/**
	* user_password  String(20)  //用户密码    
	*/
	public String getUserPassword(){
		return userPassword;
	}
	
	/**
	* user_password  String(20)  //用户密码    
	*/
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	/**
	* user_name  String(20)  //用户姓名    
	*/
	public String getUserName(){
		return userName;
	}
	
	/**
	* user_name  String(20)  //用户姓名    
	*/
	public void setUserName(String userName){
		this.userName = userName;
	}
	/**
	* user_remarks  String(255)  //备注说明    
	*/
	public String getUserRemarks(){
		return userRemarks;
	}
	
	/**
	* user_remarks  String(255)  //备注说明    
	*/
	public void setUserRemarks(String userRemarks){
		this.userRemarks = userRemarks;
	}
	/**
	* create_by  Integer(10)  //建表人ID    
	*/
	public Integer getCreateBy(){
		return createBy;
	}
	
	/**
	* create_by  Integer(10)  //建表人ID    
	*/
	public void setCreateBy(Integer createBy){
		this.createBy = createBy;
	}
	/**
	* create_time  Date(19)  CURRENT_TIMESTAMP  //建表时间    
	*/
	public Date getCreateTime(){
		return createTime;
	}
	
	/**
	* create_time  Date(19)  CURRENT_TIMESTAMP  //建表时间    
	*/
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	* update_by  Integer(10)  //更新人ID    
	*/
	public Integer getUpdateBy(){
		return updateBy;
	}
	
	/**
	* update_by  Integer(10)  //更新人ID    
	*/
	public void setUpdateBy(Integer updateBy){
		this.updateBy = updateBy;
	}
	/**
	* update_time  Date(19)  CURRENT_TIMESTAMP  //更新时间    
	*/
	public Date getUpdateTime(){
		return updateTime;
	}
	
	/**
	* update_time  Date(19)  CURRENT_TIMESTAMP  //更新时间    
	*/
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
}