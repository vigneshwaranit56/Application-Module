package com.chit.chat.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")

public class UsersEntity implements Serializable {
	
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="email")
		private String email;
		
		@Column(name="username")
		private String username;
		
		@Column(name="password")
		private String password;	
		
		@Column(name="enabled")
		private boolean eanabled;

		@Column(name="picture")
		private byte[] picture;
//		
//		@Nullable
//		@ManyToMany(fetch=FetchType.LAZY,
//				cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//				 CascadeType.DETACH, CascadeType.REFRESH})
//		@JoinTable(name="user_troop",
//				joinColumns =@JoinColumn(name="user_id"),
//				inverseJoinColumns=@JoinColumn(name="troop_id"))
//		private Set<Troop> troops;
		
		public UsersEntity(String email, String username, String password, byte[] picture) {
			this.email = email;
			this.username = username;
			this.password = password;
			this.picture = picture;
		}

		public UsersEntity() {

		}

		
//		public void addGroup(Troop troop){
//			
//			if(troops == null)
//				troops = new HashSet<Troop>();
//			
//			troops.add(troop);
//				
//		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public byte[] getPicture() {
			return picture;
		}


		public void setPicture(byte[] picture) {
			this.picture = picture;
		}
//
//		
//
//		public Set<Troop> getGroups() {
//			return troops;
//		}
//
//
//		public void setGroups(Set<Troop> troops) {
//			this.troops = troops;
//		}
//
//


}