package com.chit.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chit.chat.dao.GroupDAO;
import com.chit.chat.entity.TroopEntity;
import com.chit.chat.model.Troop;

@Service
public class TroopServiceImplementation implements TroopService {
	
	@Autowired
	GroupDAO groupDaO;
	
	@Autowired
	UserService userService;

	public TroopServiceImplementation() {
	}

	@Override
	public Troop save(Troop trp) {
		
		TroopEntity troop = trp.convertToTroopEntity(trp);
		troop.setTimeStamp(System.currentTimeMillis());
		troop.addUsers(userService.get(trp.getCreatedBy()));
		 troop = groupDaO.save(troop);
		 
		 trp = troop.convertToTroop(troop);
		 
		 return trp;
	}

	/**
	 * @param trp
	 * @return
	 */
	

	@Override
	public Troop getTroop(int groupId) {
		
		TroopEntity troop = groupDaO.findById(groupId).get();
		
		
	Troop trp = troop.convertToTroop(troop);
	
	return trp;
		
		
	}

	@Override
	public TroopEntity getTroop1(int groupId) {
		
		TroopEntity troop = groupDaO.findById(groupId).get();
	return troop;	
	}
		
	@Override
	public void delete(int groupId) {
		groupDaO.delete(getTroop1(groupId));
	}

	@Override
	public void addUser(int groupId, int userId) {
		
		TroopEntity troop =  getTroop1(groupId);
		troop.addUsers(userService.get(userId));
		groupDaO.save(troop);

	}

	@Override
	public void removeUser(int groupId, int userId) {
		TroopEntity troop =  getTroop1(groupId);
		troop.removeUser(userService.get(userId));
		groupDaO.save(troop);


	}

}
