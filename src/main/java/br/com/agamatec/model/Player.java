package br.com.agamatec.model;

import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public int resourceId;
	public int resourceBaseId;
	public int futBinId;
	public String futWizId;
	public String firstName;
	public String lastName;
	public String name;
	public String commonName;
	public int height;
	public int weight;
	public String birthDate;
	public int age;
	public int league;
	public int nation;
	public int club;
	public int rarity;
	@Transient
	public ArrayList<Trait> traits;
	@Transient
	public ArrayList<Object> specialities;
	public String position;
	public int skillMoves;
	public int weakFoot;
	public String foot;
	public String attackWorkRate;
	public String defenseWorkRate;
	public int totalStats;
	public int totalStatsInGame;
	public String color;
	public int rating;
	public int ratingAverage;
	public int pace;
	public int shooting;
	public int passing;
	public int dribbling;
	public int defending;
	public int physicality;
	@Embedded
	public PaceAttributes paceAttributes;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "positioning", column = @Column(name = "positioning_attribute")) })
	public ShootingAttributes shootingAttributes;
	@Embedded
	public PassingAttributes passingAttributes;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "dribbling", column = @Column(name = "dribbling_attribute")) })
	public DribblingAttributes dribblingAttributes;
	@Embedded
	public DefendingAttributes defendingAttributes;
	@Embedded
	public PhysicalityAttributes physicalityAttributes;
	@Embedded
	public GoalkeeperAttributes goalkeeperAttributes;
}
