package com.example.characterstore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.characterstore.dto.rickymorty.RickYMortyPageDto;

@Service
public class RickYMortyApiService {

	private final RestClient restClient;
	
	public RickYMortyApiService() {
        this.restClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com")
            .build();
    }

    public RickYMortyPageDto obtenerPagina(int pagina) {
        return restClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("api/character")
                .queryParam("page", pagina)
                .build())
            .retrieve()
            .body(RickYMortyPageDto.class);
    }

}
