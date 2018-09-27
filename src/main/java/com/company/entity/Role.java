package com.company.entity;

import java.util.Date;

/**
TABLE:.t_role                   
--------------------------------------------------------
role_id              Integer(10)        NOTNULL             //角色id
role_name            String(50)                             //角色名称
role_mark            String(50)                             //角色描述
create_by            Integer(10)                            //建表人ID
create_time          Date(19)                    CURRENT_TIMESTAMP //建表时间
update_by            Integer(10)                            //更新人ID
update_time          Date(19)                    CURRENT_TIMESTAMP //更新时间
*/
public class Role {
	private	Integer roleId;
	private	String roleName;
	private	String roleMark;
	private	Integer createBy;
	private	Date createTime;
	private	Integer updateBy;
	private	Date updateTime;

	/**
	* role_id  Integer(10)  NOTNULL  //角色id    
	*/
	public Integer getRoleId(){
		return roleId;
	}
	
	/**
	* role_id  Integer(10)  NOTNULL  //角色id    
	*/
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	/**
	* role_name  String(50)  //角色名称    
	*/
	public String getRoleName(){
		return roleName;
	}
	
	/**
	* role_name  String(50)  //角色名称    
	*/
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	/**
	* role_mark  String(50)  //角色描述    
	*/
	public String getRoleMark(){
		return roleMark;
	}
	
	/**
	* role_mark  String(50)  //角色描述    
	*/
	public void setRoleMark(String roleMark){
		this.roleMark = roleMark;
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