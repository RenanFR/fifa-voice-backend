package br.com.agamatec.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agamatec.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
