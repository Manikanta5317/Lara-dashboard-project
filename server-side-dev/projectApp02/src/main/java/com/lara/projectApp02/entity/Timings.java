package com.lara.projectApp02.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="timings")
public class Timings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	 @JoinColumn(nullable = false)
	private String time;
	
	@ManyToMany
	private List<Batchs> batchTimings;

}
