package com.lara.projectApp02.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(nullable = false)
	private String subjectName;
	
	@ManyToMany
	private List<Batchs> batchSubjects;
	
	@OneToOne()
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JoinColumn(name="teacher_id")
	private Teachers teacher;

}
