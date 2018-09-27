package com.company.entity;

import java.util.Date;

/**
TABLE:.t_permission             
--------------------------------------------------------
permission_id        Integer(10)        NOTNULL             //权限id
role_id              Integer(10)                            //角色id
menu_id              Integer(10)                            //菜单id
permission_value    String(25)                            //拥有权限:1:查看；2：查看、添加；3：查看、添加、修改；4：查看、添加、修改、删除
create_by            Integer(10)                            //建表人ID
create_time          Date(19)                    CURRENT_TIMESTAMP //建表时间
update_by            Integer(10)                            //更新人ID
update_time          Date(19)                    CURRENT_TIMESTAMP //更新时间
*/
public class Permission {
	private	Integer permissionId;
	private	Integer roleId;
	private	Integer menuId;
	private	String permissionValue;
	private	Integer createBy;
	private	Date createTime;
	private	Integer updateBy;
	private	Date updateTime;

	/**
	* permission_id  Integer(10)  NOTNULL  //权限id    
	*/
	public Integer getPermissionId(){
		return permissionId;
	}
	
	/**
	* permission_id  Integer(10)  NOTNULL  //权限id    
	*/
	public void setPermissionId(Integer permissionId){
		this.permissionId = permissionId;
	}
	/**
	* role_id  Integer(10)  //角色id    
	*/
	public Integer getRoleId(){
		return roleId;
	}
	
	/**
	* role_id  Integer(10)  //角色id    
	*/
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	/**
	* menu_id  Integer(10)  //菜单id    
	*/
	public Integer getMenuId(){
		return menuId;
	}
	
	/**
	* menu_id  Integer(10)  //菜单id    
	*/
	public void setMenuId(Integer menuId){
		this.menuId = menuId;
	}
	/**
	* permission_value  Integer(10)  //拥有权限:1:查看；2：查看、添加；3：查看、添加、修改；4：查看、添加、修改、删除    
	*/
	public String getPermissionValue(){
		return permissionValue;
	}
	
	/**
	* permission_value  Integer(10)  //拥有权限:1:查看；2：查看、添加；3：查看、添加、修改；4：查看、添加、修改、删除    
	*/
	public void setpermissionValue(String permissionValue){
		this.permissionValue = permissionValue;
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