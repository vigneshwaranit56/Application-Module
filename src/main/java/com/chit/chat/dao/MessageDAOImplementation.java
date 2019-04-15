package com.chit.chat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.chit.chat.entity.MessageEntity;
import com.chit.chat.model.Messages;
@Repository
@Transactional
public class MessageDAOImplementation implements MessageDAO {
@PersistenceContext
EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Messages> getAllByTroop(int troopId) {

		Query query = entityManager.createNativeQuery("select id,isprivate,messages,troop_id,time_stamp,send_by,send_to from messages where troop_id = ?",Messages.class);
		query.setParameter(1, troopId);

		List<Messages> message = query.getResultList();

		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Messages> getAllSenderAndReceiver(int sender, int receiver) {
		

		Query query = entityManager.createNativeQuery("select id,isprivate,messages,troop_id,time_stamp,send_by,send_to from messages where send_by = ? and  send_to = ? ;",Messages.class);
		query.setParameter(1, sender).setParameter(2, receiver);

		List<Messages> message = query.getResultList();
		
		System.out.println(message.size());

		return message;
	}

	@Override
	public void deleteAllSenderAndReceiver(int sender, int receiver) {

		Query query = entityManager.createNativeQuery("delete from messages where send_by = ? and send_to = ?");
		query.setParameter(1, sender).setParameter(2, receiver);
		query.executeUpdate();

	}

	@Override
	public void deleteAllByTroop(int troopId) {
		
		Query query = entityManager.createNativeQuery("delete from messages where troop_id = ?;");
		query.setParameter(1, troopId);

		query.executeUpdate();

	}

	@Override
	public void save(MessageEntity message) {

		entityManager.persist(message);

	}

}
