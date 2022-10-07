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
public class PassingAttributes {
	public int vision;
	
	public int crossing;
	
	@Column(name = "free_kick_accuracy")
	public int freeKickAccuracy;
	
	@Column(name = "short_passing")
	public int shortPassing;
	
	@Column(name = "long_passing")
	public int longPassing;
	
	public int curve;
}
