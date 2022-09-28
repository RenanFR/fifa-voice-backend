package br.com.agamatec.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agamatec.model.Player;
import br.com.agamatec.service.FutDBService;

@RestController
@RequestMapping("players")
public class PlayerController {
	
	@Autowired
	private FutDBService futDBService;
	
    @GetMapping(produces = "application/json")
    public List<Player> getBestPlayers(@RequestParam int amountOfPlayers) {
        return futDBService.getBestPlayers(amountOfPlayers);
    }
    

}
