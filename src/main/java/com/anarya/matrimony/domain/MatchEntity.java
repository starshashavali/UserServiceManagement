package com.anarya.matrimony.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matchtbl")
public class MatchEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matchId;

	@ManyToOne
	@JoinColumn(name = "user1_id")
	private UserEntity user1;

	@ManyToOne
	@JoinColumn(name = "user2_id")
	private UserEntity user2;

}
