package com.digimonConsumer.demo.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.digimonConsumer.demo.consumers.DigimonService;
import com.digimonConsumer.demo.entitiesDto.DigimonDto;
import com.digimonConsumer.demo.repositories.DigimonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	DigimonService apiDigimon = new DigimonService();
    List<DigimonDto> digimons = new ArrayList<>();
    
    @Autowired
    private DigimonRepository digimonRepo;
    
    @Override
	public void run(String... args) throws Exception {
	    try {
			digimons = apiDigimon.getDigimons();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
	    for(DigimonDto d : digimons) {
	    	System.out.println(d.getLevel());
	    }
		
	    digimonRepo.saveAll(digimons);
    }
}
