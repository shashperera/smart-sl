package com.esad.smartsl.domain.dto;

import java.io.Serializable;

import com.esad.smartsl.enums.UserRoleName;

public class UserRoleDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 8237934312148355747L;

	private Integer id;
	private String label;
	private UserRoleName name;
	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public UserRoleName getName() {
		return name;
	}

	public void setName(UserRoleName name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
