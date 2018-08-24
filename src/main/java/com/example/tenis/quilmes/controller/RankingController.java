package com.example.tenis.quilmes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tenis.quilmes.model.Player;
import com.example.tenis.quilmes.model.Ranking;

@RestController
@RequestMapping("api" + "/ranking")
public class RankingController {

	private Ranking ranking = buildRanking();
	
	private Ranking buildRanking() {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(1));
		return new Ranking(players);
	}
	
	@GetMapping(produces="application/json")
	public @ResponseBody Ranking getRanking() {
		return ranking;
	}
	
}
