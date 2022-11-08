package com.mdorici.domainmodelorm.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "tb_participant")
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Email
	@Column(unique = true)
	private String email;
	
	@ManyToMany
	@JoinTable(name = "tb_participant_activity",
	joinColumns = @JoinColumn(name = "participant_id"),
	inverseJoinColumns = @JoinColumn(name = "activity_id"))
	private Set<Activity> activities = new HashSet<>();

	public Participant() {
	}
	
	public Participant(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Activity> getActivities() {
		return activities;
	}
	
}
