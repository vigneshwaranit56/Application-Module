package com.chit.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chit.chat.dao.MessageDAO;
import com.chit.chat.entity.MessageEntity;
import com.chit.chat.entity.TroopEntity;
import com.chit.chat.model.Messages;

@Service
public class MessageServiceImplementation implements MessageService {

	@Autowired
	MessageDAO messagDAO;

	@Autowired
	TroopService tService;

	@Override
	public List<Messages> getAllByTroop(int troopId) {

		List<Messages> list = messagDAO.getAllByTroop(troopId);
		return list;
	}
	

	@Override
	public void deleteAllByTroop(int troopId) {
		messagDAO.deleteAllByTroop(troopId);

	}

	@Override
	public void save(Messages message) {

		boolean isPrivate = false;

		TroopEntity tEntity = null;

		if (message.getTroopid() == 0)
			isPrivate = true;
		else
			tEntity = tService.getTroop1(message.getTroopid());

		message.setTimestamp(System.currentTimeMillis());

		MessageEntity mEntity = new MessageEntity(isPrivate, message.getMessages(), message.getTimestamp(),
				message.getSendby(), message.getSendto(), tEntity);
		messagDAO.save(mEntity);
	}

	@Override
	public List<Messages> getMessageBySenderAndReceiver(int sender, int receiver) {
		List<Messages> list = messagDAO.getAllSenderAndReceiver(sender, receiver);
		return list;
	}

	@Override
	public List<MessageEntity> deleteMessageBySenderAndReceiver(int sender, int receiver) {
		messagDAO.deleteAllSenderAndReceiver(sender, receiver);
		return null;
	}

}
