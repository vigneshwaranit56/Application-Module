package com.chit.chat.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chit.chat.entity.MessageEntity;
import com.chit.chat.model.Messages;

public interface MessageDAO  {

	List<Messages> getAllByTroop(int troopId);

	List<Messages> getAllSenderAndReceiver(int sender, int receiver);

	void deleteAllSenderAndReceiver(int sender, int receiver);

	void deleteAllByTroop(int troopId);

	void save(MessageEntity message);

}
