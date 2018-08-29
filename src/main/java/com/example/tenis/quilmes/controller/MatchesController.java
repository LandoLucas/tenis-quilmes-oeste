package com.example.tenis.quilmes.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tenis.quilmes.model.Match;
import com.example.tenis.quilmes.model.Player;
import com.example.tenis.quilmes.repository.MatchRepository;
import com.example.tenis.quilmes.repository.PlayerRepository;

@RestController
@RequestMapping("api" + "/matches")
@CrossOrigin
public class MatchesController {

	@Autowired MatchRepository matchRepository;
	@Autowired PlayerRepository playerRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Match> getMatches() {
		return matchRepository.findAll();
	}
	
	@PostMapping(consumes="application/json")
	public void saveMatch(@RequestBody Match match) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		match.setDate(day + "/" + month + "/" + year);
		matchRepository.save(match);
		
		Iterable<Player> players = playerRepository.findAll();
		Player winner = null;
		Player loser = null;
		Iterator<Player> it = players.iterator();
		while(it.hasNext()) {
			Player p = it.next();
			if(p.getName().equals(match.getWinner())) {
				winner = p;
			}
			if(p.getName().equals(match.getLoser())) {
				loser = p;
			}
		}
		
		if(winner.getPosition() > loser.getPosition()) {
			Integer temp = loser.getPosition();
			loser.setPosition(winner.getPosition());
			winner.setPosition(temp);
		}
		winner.setWon(winner.getWon() + 1);
		loser.setLost(loser.getLost() + 1);
		playerRepository.save(winner);
		playerRepository.save(loser);
	}
}
