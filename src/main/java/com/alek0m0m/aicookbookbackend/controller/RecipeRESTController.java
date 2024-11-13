package com.alek0m0m.aicookbookbackend.controller;


import com.alek0m0m.aicookbookbackend.dto.RecipeDTOInput;
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
public class RecipeRESTController extends BaseRESTController<Recipe, RecipeDTOInput, RecipeDTO, RecipeService, RecipeRepository> {
    public RecipeRESTController( RecipeService service) {
        super(service);
    }

    @Override
    protected RecipeDTO convertToDTO(RecipeDTOInput recipeDTOInput) {

        System.out.println("RecipeDTOInput id check: " + recipeDTOInput.getId());

        RecipeDTO dto = recipeDTOInput.toDTO();

        System.out.println("RecipeDTO id check: " + dto.getId());

        return dto;
    }


//    @PostMapping
//    public ResponseEntity<RecipeDTO> create(@RequestBody RecipeDTO recipeDTO) {
//        if (recipeDTO == null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        System.out.println("RecipeRESTController.create: " + recipeDTO);
//        System.out.println("ingredients in recipeDTO: " + recipeDTO.getIngredients());
//
//        return ResponseEntity.ok(this.getService().save(recipeDTO));
//    }

}
