package com.alek0m0m.aicookbookbackend.controller;


import com.Alek0m0m.library.spring.web.mvc.BaseRESTController;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
import com.alek0m0m.aicookbookbackend.repository.RecipeRepository;
import com.alek0m0m.aicookbookbackend.service.RecipeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeRESTController extends BaseRESTController<Recipe, RecipeDTO, RecipeService, RecipeRepository> {
    public RecipeRESTController( RecipeService service) {
        super(service);
    }

}
