package com.chit.chat.model;

import com.chit.chat.entity.TroopEntity;

public class Troop {

	private int groupId;

	private String name;

	private int createdBy;

	private Long timeStamp;

	private String destinationPath;


	public Troop(int groupId2, int createdBy2, String name2, String destinationPath2, Long timeStamp2) {
		this.groupId = groupId2;
		this.createdBy = createdBy2;
		this.name = name2;
		this.destinationPath = destinationPath2;
		this.timeStamp = timeStamp2;	}

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

	public TroopEntity convertToTroopEntity(Troop trp) {
		TroopEntity troop = new TroopEntity(trp.getName(), trp.getCreatedBy(), trp.getTimeStamp(), trp.getDestinationPath());
		
		
		return troop;
	}
}
