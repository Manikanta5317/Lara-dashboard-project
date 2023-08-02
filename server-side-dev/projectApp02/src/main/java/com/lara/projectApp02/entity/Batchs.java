package com.lara.projectApp02.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
//@Table(name="batchs")
public class Batchs {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    private String date;
    
    @JoinColumn(nullable = false)
    private String batchName;
    
    @ManyToMany(mappedBy = "batchs")
    @JsonIgnore
    private List<Teachers> teachers;
    
    @ManyToMany(mappedBy = "batchTimings")
    @JsonIgnore
    private List<Timings> timings;
    
    @ManyToMany(mappedBy = "batchSubjects")
    @JsonIgnore
    private List<Subjects> subjects; 
}
