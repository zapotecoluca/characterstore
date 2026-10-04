package com.example.characterstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.characterstore.service.SimpsonsMigrationService;
import com.example.characterstore.service.RickYMortyMigrationService;

@Controller
@RequestMapping("/admin/migraciones")

public class MigrationController {
	private final SimpsonsMigrationService simpsonsMigrationService;
	private final RickYMortyMigrationService rickYMortyMigrationService;
	
    public MigrationController(
            SimpsonsMigrationService simpsonsMigrationService,
            RickYMortyMigrationService rickYMortyMigrationService) {
        this.simpsonsMigrationService = simpsonsMigrationService;
        this.rickYMortyMigrationService = rickYMortyMigrationService;
    }

    @GetMapping
    public String pantalla() {
        return "migraciones";
    }

    @PostMapping("/simpsons")
    public String migrarSimpsons(Model model) {
        int insertados = simpsonsMigrationService.migrarTodos();
        model.addAttribute("mensaje",
            "Migración terminada. Nuevos registros: " + insertados);
        return "migraciones";
    }
    
    @PostMapping("/rickymorty")
    public String migrarRickYMorty(Model model) {
        int insertados = rickYMortyMigrationService.migrarTodos();
        model.addAttribute("mensaje",
            "Migración terminada. Nuevos registros: " + insertados);
        return "migraciones";
    }


}
