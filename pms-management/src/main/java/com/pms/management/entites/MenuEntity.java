package com.pms.management.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menus")
public class MenuEntity {
	
	@Id
	@Column(name="menu_id")
	private Integer menuId;
	
	
	@Column(name="menu_name")
	private String menuName;
	

	@Column(name="menu_link")
	private String menuLink;
	

	@Column(name="role_id")
	private Integer roleId;


	public Integer getMenuId() {
		return menuId;
	}


	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public String getMenuLink() {
		return menuLink;
	}


	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public MenuEntity(Integer menuId, String menuName, String menuLink, Integer roleId) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuLink = menuLink;
		this.roleId = roleId;
	}


	public MenuEntity() {
		super();
	}
	
	

}
