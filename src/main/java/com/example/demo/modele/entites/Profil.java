package com.example.demo.modele.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class Profil {
	@Id
	private long id;
	@Column(nullable = true)
	
	private String bio;
	@Column(nullable = true)
	private String photo;
	@OneToOne(optional = false,fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("profile")
	private Utilisateur user;
}
