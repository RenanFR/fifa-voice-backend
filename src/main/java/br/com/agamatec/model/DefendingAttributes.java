package br.com.agamatec.model;

import javax.persistence.Column;
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
	
	@Column(name = "heading_accuracy")
	public int headingAccuracy;
	
	@Column(name = "standing_tackle")
	public int standingTackle;
	
	@Column(name = "sliding_tackle")
	public int slidingTackle;
	
	@Column(name = "defense_awareness")
	public int defenseAwareness;
}
