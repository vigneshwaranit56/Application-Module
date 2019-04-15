package com.chit.chat.service;

import com.chit.chat.entity.TroopEntity;
import com.chit.chat.model.Troop;

public interface TroopService {

	Troop save(Troop troop);

	Troop getTroop(int groupId);

	void delete(int troopId);

	void addUser(int groupId, int userId);

	void removeUser(int groupId, int userId);

	TroopEntity getTroop1(int groupId);



}
