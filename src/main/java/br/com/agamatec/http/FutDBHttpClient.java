package br.com.agamatec.http;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.agamatec.model.Player;
import br.com.agamatec.model.PlayersResponse;

@Component
public class FutDBHttpClient {

	private static final String AUTH_HEADER = "X-AUTH-TOKEN";
	private static final String FUTDB_URL = "https://futdb.app";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${X-AUTH-TOKEN}")
	private String xAuthToken;

	public List<Player> fetchPlayers(int pageTotal, int currentPage) throws Exception {
		List<Player> players = new ArrayList<>();
		logger.info("Page {} of {}", currentPage, pageTotal);
		URI uri = new URIBuilder(FUTDB_URL).setPath("/api/players").setParameter("page", String.valueOf(currentPage))
				.build();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add(AUTH_HEADER, xAuthToken);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<String>(headers), PlayersResponse.class);

		PlayersResponse playersResponse = restTemplate
				.exchange(uri, HttpMethod.GET, new HttpEntity<String>(headers), PlayersResponse.class).getBody();
		playersResponse.getItems().stream().map(Player::toString).forEach(logger::info);
		players.addAll(playersResponse.getItems());
		return players;
	}

}
