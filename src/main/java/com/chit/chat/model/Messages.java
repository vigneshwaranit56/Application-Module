package com.chit.chat.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Messages implements Serializable {
	
	@Id
	private int id;

	private boolean isprivate;

	private String messages;

	private Long time_stamp;

	private  Integer troop_id;

	private int send_by;

	private int send_to;

	public boolean isIsprivate() {
		return isprivate;
	}

	public void setIsprivate(boolean isprivate) {
		this.isprivate = isprivate;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public Long getTimestamp() {
		return time_stamp;
	}

	public void setTimestamp(Long timestamp) {
		this.time_stamp = timestamp;
	}

	public Integer getTroopid() {
		return troop_id;
	}

	public void setTroopid(Integer troopid) {
		this.troop_id = troopid;
	}

	public int getSendby() {
		return send_by;
	}

	public void setSendby(int sendby) {
		this.send_by = sendby;
	}

	public int getSendto() {
		return send_to;
	}

	public void setSendto(int sendto) {
		this.send_to = sendto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
