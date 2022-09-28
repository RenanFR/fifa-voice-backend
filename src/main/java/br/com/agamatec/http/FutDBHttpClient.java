package br.com.agamatec.http;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agamatec.model.Player;
import br.com.agamatec.model.PlayersResponse;

@Component
public class FutDBHttpClient {

	private static final String AUTH_HEADER = "X-AUTH-TOKEN";
	private static final String FUTDB_URL = "https://futdb.app";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${X-AUTH-TOKEN}")
	private String xAuthToken;

	public List<Player> fetchPlayers() throws Exception {
		List<Player> players = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

			extractResponseAndAddToPlayerList(players, objectMapper, httpClient);

		}
		return players;
	}

	private void extractResponseAndAddToPlayerList(List<Player> players, ObjectMapper objectMapper,
			CloseableHttpClient httpClient) throws Exception {
		int pageTotal = 2;
		for (int i = 1; i < pageTotal; i++) {

			HttpGet request = new HttpGet(
					new URIBuilder(FUTDB_URL).setPath("/api/players").setParameter("page", String.valueOf(i)).build());
			request.setHeader(AUTH_HEADER, xAuthToken);
			try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
				try (CloseableHttpResponse subsequentResponse = httpClient.execute(request)) {
					StringWriter stringWriter = new StringWriter();
					IOUtils.copy(httpResponse.getEntity().getContent(), stringWriter, StandardCharsets.UTF_8.name());
					PlayersResponse playersResponse = objectMapper.readValue(stringWriter.toString(),
							PlayersResponse.class);
					logger.info("Just fetched {} players", playersResponse.getPagination().getCountCurrent());
					players.addAll(playersResponse.getItems());
				}
				EntityUtils.consume(httpResponse.getEntity());
			}
		}
	}

}
