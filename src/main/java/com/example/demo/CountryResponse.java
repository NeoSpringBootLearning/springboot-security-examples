package com.example.demo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponse {

	private Integer id;
	private String countryCode;
	private String countryName;
	private String capital;
	private Integer population;
	private List<String> languages;
}
