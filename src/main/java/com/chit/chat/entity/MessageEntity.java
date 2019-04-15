package com.chit.chat.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name="messages")
public class MessageEntity implements Serializable {
	
	 	private static final long serialVersionUID = 1L;

	 	@Id
	 	@Column(name = "id")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private int id;

	 	@Column(name = "isprivate")
	 	private boolean isprivate;

	 	@Lob
	 	@Column(name = "messages")
	 	private String messages;

	 	
	 	@Column(name = "time_stamp")
	 	private Long timestamp;
	 	
	 	
	 	@ManyToOne
	 	@JoinColumn(name = "troop_id")
	 	private TroopEntity troop;

	 	@Column(name = "send_by")
	 	private int sendby;

	 	@Column(name = "send_to")
	 	private int sendto;

	 	public MessageEntity() {
	 		
	 	}

	 	public MessageEntity(boolean isprivate, String messages, Long timestamp, int sendby, int sendto,TroopEntity troop) {
	 		this.isprivate = isprivate;
	 		this.messages = messages;
	 		this.timestamp = timestamp;
	 		this.sendby = sendby;
	 		this.sendto = sendto;
	 		this.troop = troop;
	 	}
	 	public MessageEntity(boolean isprivate, String messages, Long timestamp, int sendby, int sendto) {
	 		this.isprivate = isprivate;
	 		this.messages = messages;
	 		this.timestamp = timestamp;
	 		this.sendby = sendby;
	 		this.sendto = sendto;
	 	}

	 	public int getId() {
	 		return id;
	 	}

	 	public void setId(int id) {
	 		this.id = id;
	 	}

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
	 		return timestamp;
	 	}

	 	public void setTimestamp(Long timestamp) {
	 		this.timestamp = timestamp;
	 	}

	

	 	public void setGroup(TroopEntity troop) {
	 		this.troop = troop;
	 	}

	 	public int getSendby() {
	 		return sendby;
	 	}

	 	public void setSendby(int sendby) {
	 		this.sendby = sendby;
	 	}

	 	public int getSendto() {
	 		return sendto;
	 	}

	 	public void setSendto(int sendto) {
	 		this.sendto = sendto;
	 	}
	 	

	 



}