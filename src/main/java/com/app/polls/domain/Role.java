package com.app.polls.domain;

import javax.persistence.*;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.app.polls.util.RoleName;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private RoleName name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	public Role() {

	}

	public Role(RoleName name) {
		this.name = name;
	}
}
