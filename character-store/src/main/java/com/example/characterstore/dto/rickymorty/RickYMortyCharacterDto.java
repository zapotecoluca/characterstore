package com.example.characterstore.dto.rickymorty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RickYMortyCharacterDto {

	private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    
    private AddedAtributesRMDto origin;
    private AddedAtributesRMDto location;


    @JsonProperty("image")
    private String portraitPath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPortraitPath() {
		return portraitPath;
	}

	public void setPortraitPath(String portraitPath) {
		this.portraitPath = portraitPath;
	}

	public AddedAtributesRMDto getOrigin() {
		return origin;
	}

	public void setOrigin(AddedAtributesRMDto origin) {
		this.origin = origin;
	}

	public AddedAtributesRMDto getLocation() {
		return location;
	}

	public void setLocation(AddedAtributesRMDto location) {
		this.location = location;
	}
	

}
