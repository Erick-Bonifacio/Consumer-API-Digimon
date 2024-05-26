package com.digimonConsumer.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value="/name={name}")
	public ResponseEntity<DigimonDto> findByName(@PathVariable String name){
		Optional<DigimonDto> d = service.findByName(name);
		return ResponseEntity.ok().body(d.get());
	}
	
	@GetMapping(value="/level={level}")
	public ResponseEntity<List<DigimonDto>> findBylevel(@PathVariable String level){
		List<DigimonDto> d = service.findByLevel(level);
		return ResponseEntity.ok().body(d);
	}
}
