package br.com.agamatec.model;

import java.util.List;

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
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(of = { "name", "height", "age", "position", "rating" })
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(name = "resource_id")
	public int resourceId;

	@Column(name = "resource_base_id")
	public int resourceBaseId;

	@Column(name = "fut_bin_id")
	public int futBinId;

	@Column(name = "fut_wiz_id")
	public String futWizId;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	public String name;

	@Column(name = "common_name")
	public String commonName;

	public int height;

	public int weight;

	@Column(name = "birth_date")
	public String birthDate;

	public int age;

	public int league;

	public int nation;

	public int club;

	public int rarity;

	@Transient
	public List<Trait> traits;

	@Transient
	public List<Object> specialities;

	public String position;

	@Column(name = "skill_moves")
	public int skillMoves;

	@Column(name = "weak_foot")
	public int weakFoot;

	public String foot;

	@Column(name = "attack_work_rate")
	public String attackWorkRate;

	@Column(name = "defense_work_rate")
	public String defenseWorkRate;

	@Column(name = "total_stats")
	public int totalStats;

	@Column(name = "total_stats_in_game")
	public int totalStatsInGame;

	public String color;
	
	public int rating;

	@Column(name = "rating_average")
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
