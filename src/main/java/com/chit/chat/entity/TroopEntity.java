package com.chit.chat.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.chit.chat.model.Troop;

/**
 * The persistent class for the troop database table.
 * 
 */
@Entity
@Table(name = "troop")
public class TroopEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int groupId;

	@Column(name = "name")
	private String name;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "time_stamp")
	private Long timeStamp;

	@Column(name = "destination_path")
	private String destinationPath;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })

	@JoinTable(name = "user_troop", joinColumns = @JoinColumn(name = "troop_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<UsersEntity> users;

	@OneToMany(mappedBy = "troop")
	private Set<MessageEntity> message;

	public TroopEntity() {
		this.users = new HashSet<UsersEntity>();

	}

	public TroopEntity(String name, int createdBy, Long timeStamp, String destinationPath) {
		this.name = name;
		this.createdBy = createdBy;
		this.timeStamp = timeStamp;
		this.destinationPath = destinationPath;
		this.users = new HashSet<UsersEntity>();

	}

	

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDestinationPath() {
		return destinationPath;
	}

	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}

	public Set<UsersEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UsersEntity> users) {
		this.users = users;
	}

	public void addUsers(UsersEntity user) {

		if (users == null)
			users = new HashSet<UsersEntity>();

		users.add(user);
	}

	public void removeUser(UsersEntity users2) {

		if (users == null) {
			users = new HashSet<UsersEntity>();
			return;
		}

		users.remove(users2);

	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MessageEntity> getMessage() {
		return message;
	}

	public void setMessage(Set<MessageEntity> message) {
		this.message = message;
		
		
	}
	
	public Troop convertToTroop(TroopEntity entity){
		
		Troop trp = new Troop(entity.getGroupId(),entity.getCreatedBy(),entity.getName(),entity.getDestinationPath(),entity.getTimeStamp());
		
		return trp;
		
	}

}