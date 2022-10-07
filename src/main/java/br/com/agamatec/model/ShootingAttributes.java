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
public class ShootingAttributes {
	public int positioning;
	
	public int finishing;
	
	@Column(name = "shot_power")
	public int shotPower;
	
	@Column(name = "long_shots")
	public int longShots;
	
	public int volleys;
	
	public int penalties;
}
