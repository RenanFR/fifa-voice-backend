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
public class PaceAttributes {
	public int acceleration;
	
	@Column(name = "sprint_speed")
	public int sprintSpeed;
}
