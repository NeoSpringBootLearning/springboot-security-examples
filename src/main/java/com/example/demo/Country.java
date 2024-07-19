package com.example.demo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String countryCode;
	private String countryName;
	private String capital;
	private Integer population;
	private Integer gdp;
	private List<String> languages;
}
