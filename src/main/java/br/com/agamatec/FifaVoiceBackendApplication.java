package br.com.agamatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import br.com.agamatec.service.FutDBService;

@SpringBootApplication
public class FifaVoiceBackendApplication {

	@Autowired
	private FutDBService futDBService;

	public static void main(String[] args) {
		SpringApplication.run(FifaVoiceBackendApplication.class, args);
	}

	@EventListener(ContextRefreshedEvent.class)
	public void fillInternalDatabaseOfPlayers() throws Exception {
		futDBService.fetchAndSavePlayers();
	}

}
