package com.example.characterstore.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.characterstore.dto.rickymorty.*;
import com.example.characterstore.model.PersonajeRickYMorty;
import com.example.characterstore.repository.ProductoRepository;

@Service

public class RickYMortyMigrationService {

	private static final String UNIVERSO = "RICKANDMORTY";

    private final RickYMortyApiService apiService;
    private final ProductoRepository repository;

    public RickYMortyMigrationService(
    		RickYMortyApiService apiService,
            ProductoRepository repository) {
        this.apiService = apiService;
        this.repository = repository;
    }

    @Transactional
    public int migrarTodos() {
        int insertados = 0;
        int pagina = 1;
        int totalPaginas;

        do {
        	RYMResponseDto respuesta = apiService.obtenerPagina(pagina);
            if (respuesta == null || respuesta.getResults() == null || respuesta.getInfo() == null) {
                break;
            }

            totalPaginas = respuesta.getInfo().getPages() == null
                    ? pagina
                    : respuesta.getInfo().getPages();

            for (RickYMortyCharacterDto dto : respuesta.getResults()) {
                if (dto.getId() == null) continue;

                boolean existe = repository
                    .existsByUniversoAndApiId(UNIVERSO, dto.getId());

                if (!existe) {
                    repository.save(convertir(dto));
                    insertados++;
                }
            }

            System.out.println("Rick y Morty página " + pagina
                    + " de " + totalPaginas + " procesada");
            pagina++;

        } while (pagina <= totalPaginas);

        return insertados;
    }

    private PersonajeRickYMorty convertir(RickYMortyCharacterDto dto) {
    	PersonajeRickYMorty p = new PersonajeRickYMorty();
        p.setApiId(dto.getId());
        p.setNombre(dto.getName());
        p.setUniverso(UNIVERSO);
        p.setEstado(dto.getStatus());
        p.setEspecie(dto.getSpecies());
        p.setTipo(dto.getType());
        p.setGenero(dto.getGender());
        p.setOrigen(dto.getOrigin() == null ? null : dto.getOrigin().getNombre());
        p.setLocacion(dto.getLocation() == null ? null : dto.getLocation().getNombre());
        
        

        if (dto.getPortraitPath() != null) {
            p.setImagen(dto.getPortraitPath());
        }

        p.setPrecio(precioDidactico(dto.getId()));
        p.setStock(5 + (dto.getId() % 21));
        return p;
    }

    private BigDecimal precioDidactico(int apiId) {
        double valor = 19.99 + ((apiId % 15) * 2.00);
        return BigDecimal.valueOf(valor);
    }

}
