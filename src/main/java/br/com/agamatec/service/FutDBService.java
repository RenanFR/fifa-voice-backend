package br.com.agamatec.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agamatec.data.PlayerRepository;
import br.com.agamatec.http.FutDBHttpClient;
import br.com.agamatec.model.Player;

@Service
public class FutDBService {

	@Autowired
	private FutDBHttpClient futDBHttpClient;

	@Autowired
	private PlayerRepository playerRepository;

	public void fetchAndSavePlayers() throws Exception {
		List<Player> players = futDBHttpClient.fetchPlayers();
		playerRepository.saveAll(players);
	}

	public List<Player> getBestPlayers(int amountOfPlayers) {
		return playerRepository.findAll().stream().sorted(Comparator.comparing(Player::getRating))
				.limit(amountOfPlayers).collect(Collectors.toList());

	}

}
