package com.example.tenis.quilmes.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tenis.quilmes.model.Player;
import com.example.tenis.quilmes.repository.PlayerRepository;

@RestController
@RequestMapping("api" + "/ranking")
public class RankingController {

	@Autowired PlayerRepository playerRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Player> getPlayers() {
		return playerRepository.findAll();
	}
	
	@PutMapping(consumes="application/json")
	public void saveNewPlayer(@RequestBody String playerName) {
		Iterable<Player> players = playerRepository.findAll();
		Iterator<Player> it = players.iterator();
		
		int highestNumber = 0;
		while(it.hasNext()) {
			Player p = it.next();
			if(p.getPosition() > highestNumber) {
				highestNumber = p.getPosition();
			}
		}
		
		Player newP = new Player(highestNumber + 1, playerName, 0, 0);
		playerRepository.save(newP);
	}
	
}
