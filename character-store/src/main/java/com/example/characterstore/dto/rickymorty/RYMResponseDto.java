package com.example.characterstore.dto.rickymorty;

import java.util.List;

public class RYMResponseDto {

	private RYMInfoDto info;
	private List<RickYMortyCharacterDto> results;
	
	public RYMInfoDto getInfo() {
		return info;
	}
	public void setInfo(RYMInfoDto info) {
		this.info = info;
	}
	public List<RickYMortyCharacterDto> getResults() {
		return results;
	}
	public void setResults(List<RickYMortyCharacterDto> results) {
		this.results = results;
	}
	
	
}
