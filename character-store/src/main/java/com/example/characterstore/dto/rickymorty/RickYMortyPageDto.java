package com.example.characterstore.dto.rickymorty;

import java.util.List;

public class RickYMortyPageDto {

	private Integer count;
    private String next;
    private String prev;
    private Integer pages;
    
    private List<RickYMortyCharacterDto> results;
    
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public List<RickYMortyCharacterDto> getResults() {
		return results;
	}
	public void setResults(List<RickYMortyCharacterDto> results) {
		this.results = results;
	}

}
