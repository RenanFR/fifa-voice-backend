package br.com.agamatec.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class GoalkeeperAttributes {
	public int diving;
	public int handling;
	public int kicking;
	public int positioning;
	public int reflexes;
}
