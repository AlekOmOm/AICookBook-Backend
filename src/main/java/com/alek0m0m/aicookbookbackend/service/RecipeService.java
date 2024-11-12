package com.alek0m0m.aicookbookbackend.service;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTO;
import com.alek0m0m.aicookbookbackend.dto.IngredientDTOMapper;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTOMapper;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
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
public class RecipeService extends BaseService<Recipe, RecipeDTO, RecipeRepository> {

    private final IngredientService ingredientService;
    private final IngredientDTOMapper ingredientDTOMapper;
    private final RecipeDTOMapper recipeDTOMapper;

    @Autowired
    protected RecipeService(RecipeRepository repository, RecipeDTOMapper recipeDTOMapper, IngredientService ingredientService, IngredientDTOMapper ingredientDTOMapper) {
        super(repository, recipeDTOMapper);
        this.ingredientService = ingredientService;
        this.ingredientDTOMapper = ingredientDTOMapper;
        this.recipeDTOMapper = recipeDTOMapper;
    }

    // --------------------- CRUD ---------------------
    @Override
    @Transactional
    public RecipeDTO save(BaseEntityDTO<Recipe> entityDTO) {
        Recipe recipe = entityDTO.toEntity();

        List<IngredientDTO> ingredientDTOs = ingredientDTOMapper.applyAll(recipe.getIngredients());

        // Set saved ingredients to the recipe
        recipe.setIngredients(ingredientService.saveAllIngredients(recipe.getIngredients()));

        System.out.println("RecipeService.save: " + recipe);

        RecipeDTO dto = new RecipeDTO();
        // Save recipe
        return dto;
    }

    @Override
    public List<RecipeDTO> findAll() {
        return super.findAll().stream()
                .map(recipeDTO -> {
                    setIngredients(recipeDTO);
                    return recipeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO findById(long id) {
        RecipeDTO recipeDTO = super.findById(id);
        setIngredients(recipeDTO);
        return recipeDTO;
    }

    @Override
    public void deleteById(long id) {
        RecipeDTO recipeDTO = findById(id);
        recipeDTO.getIngredients().forEach(ingredient -> ingredientService.deleteById(ingredient.getId()));
        super.deleteById(id);
    }


    // --------------------- Helper methods ---------------------

    private void setIngredients(RecipeDTO recipeDTO) {
        recipeDTO.setIngredients(recipeDTO.getIngredients().stream()
                .map(ingredientDTO -> ingredientService.findById(ingredientDTO.getId()))
                .collect(Collectors.toList()));
    }
}
