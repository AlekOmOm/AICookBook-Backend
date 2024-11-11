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
    public RecipeDTO save(BaseEntityDTO<Recipe> entityDTO) {
        Recipe recipe = entityDTO.toEntity();

        // Save ingredients
        List<Ingredient> savedIngredients = recipe.getIngredients().stream()
                .map(ingredient -> ingredientService.save(ingredientDTOMapper.apply(ingredient)).toEntity())
                .collect(Collectors.toList());

        // Set saved ingredients to the recipe
        recipe.setIngredients(savedIngredients);

        // Save recipe
        return super.save(recipeDTOMapper.apply(recipe));
    }

    @Override
    public List<RecipeDTO> findAll() {
        return super.findAll().stream()
                .map(recipeDTO -> {
                    recipeDTO.setIngredients(recipeDTO.getIngredients().stream()
                            .map(ingredientDTO -> ingredientService.findById(ingredientDTO.getId()).toEntity())
                            .collect(Collectors.toList()));
                    return recipeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO findById(long id) {
        RecipeDTO recipeDTO = super.findById(id);
        recipeDTO.setIngredients(recipeDTO.getIngredients().stream()
                .map(ingredientDTO -> ingredientService.findById(ingredientDTO.getId()).toEntity())
                .collect(Collectors.toList()));
        return recipeDTO;
    }

    @Override
    public void deleteById(long id) {
        RecipeDTO recipeDTO = findById(id);
        recipeDTO.getIngredients().forEach(ingredient -> ingredientService.deleteById(ingredient.getId()));
        super.deleteById(id);
    }

}
