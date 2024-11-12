package com.alek0m0m.aicookbookbackend.controller;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
import com.alek0m0m.aicookbookbackend.repository.RecipeRepository;
import com.alek0m0m.aicookbookbackend.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recipes")
public class RecipeRESTController extends BaseRESTController<Recipe, RecipeDTO, RecipeService, RecipeRepository> {
    public RecipeRESTController( RecipeService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity<RecipeDTO> create(@RequestBody RecipeDTO recipeDTO) {
        return ResponseEntity.ok(this.getService().save(recipeDTO));
    }




}
