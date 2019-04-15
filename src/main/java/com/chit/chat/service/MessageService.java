package com.chit.chat.service;

import java.util.List;

import com.chit.chat.entity.MessageEntity;
import com.chit.chat.model.Messages;


public interface MessageService {

	List<Messages> getAllByTroop(int troopId);

	void deleteAllByTroop(int troopId);

	void save(Messages message);
	
	List<Messages> getMessageBySenderAndReceiver(int sender, int receiver);

	List<MessageEntity> deleteMessageBySenderAndReceiver(int sender, int receiver);



	
}
