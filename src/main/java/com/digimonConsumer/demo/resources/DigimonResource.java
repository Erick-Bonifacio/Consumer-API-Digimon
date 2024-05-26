package com.digimonConsumer.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digimonConsumer.demo.entitiesDto.DigimonDto;
import com.digimonConsumer.demo.services.DigimonService;

@RestController
@RequestMapping(value="/digimons")
public class DigimonResource {
	
	@Autowired
	private DigimonService service;
	
	@GetMapping
	public ResponseEntity<List<DigimonDto>> findAll(){
		List<DigimonDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
