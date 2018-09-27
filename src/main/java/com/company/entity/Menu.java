package com.company.entity;

import java.util.Date;

/**
TABLE:.t_menu                   
--------------------------------------------------------
menu_id              Integer(10)        NOTNULL             //菜单id
menu_pid             Integer(10)                            //上级菜单id
menu_name            String(25)                             //菜单名称
menu_url             String(50)                             //菜单链接
menu_icon            String(50)                             //菜单图标
menu_order           Integer(10)                            //菜单顺序
create_by            Integer(10)                            //建表人ID
create_time          Date(19)                    CURRENT_TIMESTAMP //建表时间
update_by            Integer(10)                            //更新人ID
update_time          Date(19)                    CURRENT_TIMESTAMP //更新时间
*/
public class Menu {
	private	Integer menuId;
	private	Integer menuPid;
	private	String menuName;
	private	String menuUrl;
	private	String menuIcon;
	private	Integer menuOrder;
	private	Integer createBy;
	private	Date createTime;
	private	Integer updateBy;
	private	Date updateTime;

	/**
	* menu_id  Integer(10)  NOTNULL  //菜单id    
	*/
	public Integer getMenuId(){
		return menuId;
	}
	
	/**
	* menu_id  Integer(10)  NOTNULL  //菜单id    
	*/
	public void setMenuId(Integer menuId){
		this.menuId = menuId;
	}
	/**
	* menu_pid  Integer(10)  //上级菜单id    
	*/
	public Integer getMenuPid(){
		return menuPid;
	}
	
	/**
	* menu_pid  Integer(10)  //上级菜单id    
	*/
	public void setMenuPid(Integer menuPid){
		this.menuPid = menuPid;
	}
	/**
	* menu_name  String(25)  //菜单名称    
	*/
	public String getMenuName(){
		return menuName;
	}
	
	/**
	* menu_name  String(25)  //菜单名称    
	*/
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}
	/**
	* menu_url  String(50)  //菜单链接    
	*/
	public String getMenuUrl(){
		return menuUrl;
	}
	
	/**
	* menu_url  String(50)  //菜单链接    
	*/
	public void setMenuUrl(String menuUrl){
		this.menuUrl = menuUrl;
	}
	/**
	* menu_icon  String(50)  //菜单图标    
	*/
	public String getMenuIcon(){
		return menuIcon;
	}
	
	/**
	* menu_icon  String(50)  //菜单图标    
	*/
	public void setMenuIcon(String menuIcon){
		this.menuIcon = menuIcon;
	}
	/**
	* menu_order  Integer(10)  //菜单顺序    
	*/
	public Integer getMenuOrder(){
		return menuOrder;
	}
	
	/**
	* menu_order  Integer(10)  //菜单顺序    
	*/
	public void setMenuOrder(Integer menuOrder){
		this.menuOrder = menuOrder;
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