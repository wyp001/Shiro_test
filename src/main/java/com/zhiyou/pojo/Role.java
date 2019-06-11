package com.zhiyou.pojo;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@ManyToMany
	@Fetch(FetchMode.JOIN)
	@JoinTable(name="user_role",
	joinColumns=@JoinColumn(name="role_id"),
	inverseJoinColumns=@JoinColumn(name="user_id"))
	private Set<User> users = new HashSet<User>();
	
	@ManyToMany(mappedBy="roles")
	@Fetch(FetchMode.JOIN)
	private Set<Permission> permissions = new HashSet<Permission>();
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", permissions=" + permissions + "]";
	}
	


}
