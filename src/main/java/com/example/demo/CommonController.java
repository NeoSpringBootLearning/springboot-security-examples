package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class CommonController {

	@Autowired
	private CommonService commonService;
	
	@GetMapping("/greetings")
	public ResponseEntity<String> greetings() {
		
		String response = commonService.greetings();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getAllDevlopedCountries() {
		
		List<Country> response = commonService.getAllDevlopedCountries();
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/countries/add")
	public ResponseEntity<Void> addCountry(@RequestBody CountryRequest countryRequest) throws Exception {
		
		commonService.addCountry(countryRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
