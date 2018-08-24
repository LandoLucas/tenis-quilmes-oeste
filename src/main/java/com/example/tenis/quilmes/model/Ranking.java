package com.example.tenis.quilmes.model;

import java.util.List;

public class Ranking {

	List<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Ranking(List<Player> players) {
		super();
		this.players = players;
	}

}
