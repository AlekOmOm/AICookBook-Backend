package com.alek0m0m.aicookbookbackend.controller;


import com.alek0m0m.aicookbookbackend.dto.RecipeDTOInput;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTOMapper;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
import com.alek0m0m.aicookbookbackend.repository.RecipeRepository;
import com.alek0m0m.aicookbookbackend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/recipes")
public class RecipeRESTController extends BaseRESTController<RecipeDTOInput, RecipeDTO, Recipe, RecipeDTOMapper, RecipeService, RecipeRepository> {

    @Autowired
    public RecipeRESTController(RecipeService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> create(@RequestBody RecipeDTOInput dtoinput) {
        if (dtoinput == null) {
            return ResponseEntity.badRequest().build();
        }

        dtoinput.setIngredients(dtoinput.getIngredients().stream()
                        .peek(ingredientDTO -> { ingredientDTO.setId(0); })
                        .collect(Collectors.toList()));

        return ResponseEntity.ok(getService().save(mapper.toDTO(dtoinput)));
    }

}
