package com.example.demo.modele.entites;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
private long id;
private LocalDateTime createdAt;
@PrePersist
public void prepersist()
{
this.createdAt=LocalDateTime.now();	
}
}
