package com.chit.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chit.chat.entity.TroopEntity;
import com.chit.chat.exception.handler.NotFoundException;
import com.chit.chat.model.Troop;
import com.chit.chat.service.TroopService;

@RestController
@RequestMapping("/group")
public class TroopController {
	
	@Autowired
	TroopService troopService;
	
	@PostMapping()
	public ResponseEntity<Troop> createGroup(@RequestBody Troop troop){
		Troop troopE =troopService.save(troop);
		
		return new ResponseEntity<Troop>(troopE,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{groupId}")
	public ResponseEntity<Troop> getGroup(@PathVariable int groupId){
		
		Troop troop = troopService.getTroop(groupId);
		
		if(troop == null)
			throw new NotFoundException();
		
		return new ResponseEntity<Troop>(troop,HttpStatus.OK);		
	}
	
	
	@PutMapping()
	public ResponseEntity<Void> updateTroop(@RequestBody Troop troop){
		
		
		troopService.save(troop);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);		

	}
	
	@DeleteMapping()
	public ResponseEntity<Void> deleteTroop(@PathVariable int troopId){
		
		troopService.delete(troopId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@PostMapping("/{groupId}/{userId}")
	public ResponseEntity<Void> addUser(@PathVariable int groupId,@PathVariable int userId){
		
		troopService.addUser(groupId,userId);

		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@DeleteMapping("/{groupId}/{userId}")
	public ResponseEntity<Void> removeUser(@PathVariable int groupId,@PathVariable int userId){
		
		troopService.removeUser(groupId,userId);

		
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
