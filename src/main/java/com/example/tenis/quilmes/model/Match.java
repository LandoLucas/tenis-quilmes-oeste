package com.example.tenis.quilmes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "tennismatches")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	String winner;
	String loser;
	String result;
	String date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getLoser() {
		return loser;
	}

	public void setLoser(String loser) {
		this.loser = loser;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Match(String winner, String loser, String result, String date) {
		super();
		this.winner = winner;
		this.loser = loser;
		this.result = result;
		this.date = date;
	}

	public Match() {
		super();
	}

}
