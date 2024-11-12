package com.alek0m0m.aicookbookbackend.dto;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RecipeDTOMapper implements EntityToDTOMapper<Recipe, RecipeDTO> {

    @Autowired
    private IngredientDTOMapper ingredientDTOMapper;

    @Override
    public RecipeDTO map(Recipe recipe) {
        return mapRecipeToDTO(recipe);
    }

    @Override
    public RecipeDTO apply(Recipe recipe) {
        return EntityToDTOMapper.super.apply(recipe);
    }

    // ------------------ Concrete mappings ------------------


    public RecipeDTO mapRecipeToDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setInstructions(recipe.getInstructions());
        recipeDTO.setTags(recipe.getTags());
        recipeDTO.setServings(recipe.getServings());
        recipeDTO.setPrepTime(recipe.getPrepTime());
        recipeDTO.setCookTime(recipe.getCookTime());
        recipeDTO.setTotalTime(recipe.getTotalTime());
        recipeDTO.setIngredients(recipe.getIngredients()
                .stream().map(ingredient -> ingredientDTOMapper.map(ingredient))
                .collect(Collectors.toList())
        );

        return recipeDTO;
    }

    public Recipe mapDTOToRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setName(recipeDTO.getName());
        recipe.setInstructions(recipeDTO.getInstructions());
        recipe.setTags(recipeDTO.getTags());
        recipe.setServings(recipeDTO.getServings());
        recipe.setPrepTime(recipeDTO.getPrepTime());
        recipe.setCookTime(recipeDTO.getCookTime());
        recipe.setTotalTime(recipeDTO.getTotalTime());
        recipe.setIngredients(recipeDTO.getIngredients()
                .stream().map(ingredientDTO -> ingredientDTOMapper.apply(ingredientDTO))
                .collect(Collectors.toList())
        );
        return recipe;
    }

}
