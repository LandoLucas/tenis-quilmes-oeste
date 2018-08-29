package com.example.tenis.quilmes.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tenis.quilmes.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
