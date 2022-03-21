package com.pms.management.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menus")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
