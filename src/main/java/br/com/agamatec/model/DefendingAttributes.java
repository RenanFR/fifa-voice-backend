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
public class DefendingAttributes {
	public int interceptions;
	public int headingAccuracy;
	public int standingTackle;
	public int slidingTackle;
	public int defenseAwareness;
}
