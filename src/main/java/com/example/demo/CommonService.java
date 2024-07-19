package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

	@Autowired
	private CountryRepository countryRepository;

	public String greetings() {

		LocalDateTime dateTime = LocalDateTime.now();
		String date = String.valueOf(dateTime).substring(0, 20);
		return "Greetings from Hello World Controller" + "-- Current Date and Time --" + date;
	}

	public void addCountry(CountryRequest countryRequest) throws Exception {

		if(countryRequest==null) {
			throw new Exception("Bad Request");
		}
		Country country = new Country();
		country.setCountryCode(countryRequest.getCountryCode());
		country.setCountryName(countryRequest.getCountryName());
		country.setCapital(countryRequest.getCapital());
		country.setGdp(countryRequest.getGdp());
		country.setPopulation(countryRequest.getPopulation());
		country.setLanguages(country.getLanguages());
		countryRepository.save(country);
	}

	public List<Country> getAllDevlopedCountries() {

		List<Country> countries = countryRepository.findAll();
		List<Country> devlopedCountries = countries.stream().filter(x -> x.getGdp() > 12000)
				.collect(Collectors.toList());
		return devlopedCountries;
	}

}
