package com.example.characterstore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.characterstore.dto.rickymorty.RYMResponseDto;

@Service
public class RickYMortyApiService {

	private final RestClient restClient;
	
	public RickYMortyApiService() {
        this.restClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com")
            .build();
    }

    public RYMResponseDto obtenerPagina(int pagina) {
    	try {
	        return restClient.get()
	            .uri(uriBuilder -> uriBuilder
	                .path("api/character")
	                .queryParam("page", pagina)
	                .build())
	            .retrieve()
	            .body(RYMResponseDto.class);
        } catch (Exception e) {
        	try {
        		
        		for(int i = 0; i < 10; i++) {
            		Thread.sleep((2500*i));
            	}
        	} catch (InterruptedException ie) {
        		Thread.currentThread().interrupt();
        		throw e;
        	}
        }
    	return null;
    }

}
