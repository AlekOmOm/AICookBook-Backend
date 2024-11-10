package com.alek0m0m.aicookbookbackend.controller;


import com.Alek0m0m.library.spring.web.mvc.BaseRESTController;
import com.alek0m0m.aicookbookbackend.Recipe;
import com.alek0m0m.aicookbookbackend.RecipeDTO;
import com.alek0m0m.aicookbookbackend.RecipeRepository;
import com.alek0m0m.aicookbookbackend.RecipeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeRESTController extends BaseRESTController<Recipe, RecipeDTO, RecipeService, RecipeRepository> {
    public RecipeRESTController() {
        super(null);
    }
}
