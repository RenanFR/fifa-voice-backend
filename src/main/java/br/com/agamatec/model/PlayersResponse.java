package br.com.agamatec.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayersResponse {
	public Pagination pagination;
	public ArrayList<Player> items;
}
