package com.alek0m0m.aicookbookbackend.service;

import com.alek0m0m.aicookbookbackend.dto.*;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class RecipeService extends BaseService<RecipeDTOInput, RecipeDTO, Recipe, RecipeDTOMapper, RecipeRepository> {

    private final IngredientService ingredientService;
    private final RecipeRepository recipeRepository;

    @Autowired
    protected RecipeService(RecipeRepository repository, RecipeDTOMapper recipeDTOMapper, IngredientService ingredientService, RecipeRepository recipeRepository) {
        super(repository, recipeDTOMapper);
        this.ingredientService = ingredientService;
        this.recipeRepository = recipeRepository;
    }

    @Override
    protected void resetAutoIncrement() {
        ingredientService.getRepository().resetAutoIncrement();
        recipeRepository.resetAutoIncrement();
    }

    // --------------------- CRUD ---------------------

    @Override
    public List<RecipeDTO> findAll() {
        return super.findAll().stream()
                .peek(this::setIngredients)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO findById(long id) {
        RecipeDTO recipeDTO = super.findById(id);
        setIngredients(recipeDTO);
        return recipeDTO;
    }

//    @Override
//    public void deleteById(long id) {
//        RecipeDTO recipeDTO = findById(id);
//        recipeDTO.getIngredients().forEach(ingredient
//                -> ingredientService.deleteById(ingredient.getId()));
//        super.deleteById(id);
//    }


    // --------------------- Helper methods ---------------------

    private void setIngredients(RecipeDTO recipeDTO) {
        recipeDTO.setIngredients(recipeDTO.getIngredients().stream()
                .map(ingredientDTO -> ingredientService.findById(ingredientDTO.getId()))
                .collect(Collectors.toList()));
    }

}
