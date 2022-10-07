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
public class DribblingAttributes {
	public int agility;
	
	public int balance;
	
	public int reactions;
	
	@Column(name = "ball_control")
	public int ballControl;
	
	public int dribbling;
	
	public int composure;
}
