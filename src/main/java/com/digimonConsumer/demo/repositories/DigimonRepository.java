package com.digimonConsumer.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.digimonConsumer.demo.entitiesDto.DigimonDto;

public interface DigimonRepository  extends JpaRepository<DigimonDto, String>, QueryByExampleExecutor<DigimonDto>{

}
