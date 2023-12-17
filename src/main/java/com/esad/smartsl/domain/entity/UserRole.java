package com.esad.smartsl.domain.entity;

import javax.persistence.*;

import com.esad.smartsl.enums.UserRoleName;

import java.io.Serializable;

@Entity
@Table(name = "USER_ROLE")
public class UserRole extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4414640670588396587L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "NAME")
	private UserRoleName name;

	@Column(name = "CODE")
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
