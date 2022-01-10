package com.pms.entity;

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

}
