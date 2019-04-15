package com.chit.chat.dao;

import org.springframework.data.repository.CrudRepository;

import com.chit.chat.entity.TroopEntity;

public interface GroupDAO extends CrudRepository<TroopEntity, Integer> {

}
