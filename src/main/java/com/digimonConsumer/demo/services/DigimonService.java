package com.digimonConsumer.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.digimonConsumer.demo.entitiesDto.DigimonDto;
import com.digimonConsumer.demo.repositories.DigimonRepository;

@Service
public class DigimonService {

	@Autowired
	private DigimonRepository repo;
	
	public List<DigimonDto> findAll() {
		return repo.findAll();
	}
	
	public Optional<DigimonDto> findByName(String name) {
        DigimonDto digimonExample = new DigimonDto();
        digimonExample.setName(name);
        Example<DigimonDto> example = Example.of(digimonExample);
        return repo.findOne(example);
    }
	
	
}
