package com.digimonConsumer.demo.entitiesDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tb_digimon")
public class DigimonDto {
	
	@Id
	private String name;
	private String img;
	private String level;
	
	public DigimonDto() {}
	
	public DigimonDto(String name, String img, String level) {
		this.name = name;
		this.img = img;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "DigimonDto [name=" + name + ", img=" + img + ", level=" + level + "]";
	}
	
}
