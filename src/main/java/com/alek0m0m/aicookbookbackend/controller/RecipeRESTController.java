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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/recipes")
public class RecipeRESTController extends BaseRESTController<RecipeDTOInput, RecipeDTO, Recipe, RecipeDTOMapper, RecipeService, RecipeRepository> {

    @Autowired
    public RecipeRESTController( RecipeService service) {
        super(service);
    }

}
