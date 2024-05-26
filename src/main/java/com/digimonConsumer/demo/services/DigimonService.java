package com.digimonConsumer.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.digimonConsumer.demo.entitiesDto.DigimonDto;
import com.digimonConsumer.demo.repositories.DigimonRepository;
import com.digimonConsumer.demo.services.exceptions.DigimonNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
        Optional<DigimonDto> opt = repo.findOne(example);
	    if(opt.isEmpty()) {
	    	throw new DigimonNotFoundException(name);
	    }
	    else {
        	return opt;
        }
    }
	
	public List<DigimonDto> findByLevel(String level) {
        DigimonDto digimonExample = new DigimonDto();
        digimonExample.setLevel(level);
        Example<DigimonDto> example = Example.of(digimonExample);
        List<DigimonDto> list = repo.findAll(example);
        if(list.isEmpty()) {
        	throw new DigimonNotFoundException(level);
        }
        else {
        	return list;
        }
    }
}
