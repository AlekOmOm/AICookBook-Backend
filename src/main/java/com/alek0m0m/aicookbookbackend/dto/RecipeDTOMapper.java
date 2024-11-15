package com.alek0m0m.aicookbookbackend.dto;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeDTOMapper extends EntityToDTOMapperImpl<RecipeDTOInput, RecipeDTO, Recipe> {

    private final IngredientDTOMapper ingredientDTOMapper;
    @Autowired
    public RecipeDTOMapper(IngredientDTOMapper ingredientDTOMapper) {
        this.ingredientDTOMapper = ingredientDTOMapper;
    }

    // ------------------ Interface methods ------------------

    // map methods implemented from Abstract class



    // ------------------ Concrete mappings ------------------

    @Override
    public RecipeDTO toDTO(RecipeDTOInput recipeDTOInput) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipeDTOInput.getId());
        recipeDTO.setName(recipeDTOInput.getName());
        recipeDTO.setInstructions(recipeDTOInput.getInstructions());
        recipeDTO.setTags(recipeDTOInput.getTags());
        recipeDTO.setServings(recipeDTOInput.getServings());
        recipeDTO.setPrepTime(recipeDTOInput.getPrepTime());
        recipeDTO.setCookTime(recipeDTOInput.getCookTime());
        recipeDTO.setTotalTime(recipeDTOInput.getTotalTime());

        if (recipeDTOInput.getIngredients() == null) {
            return recipeDTO;
        }
        recipeDTO.setIngredients(recipeDTOInput.getIngredients());
        return recipeDTO;
    }

    public Recipe toEntity(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setName(recipeDTO.getName());
        recipe.setInstructions(recipeDTO.getInstructions());
        recipe.setTags(recipeDTO.getTags());
        recipe.setServings(recipeDTO.getServings());
        recipe.setPrepTime(recipeDTO.getPrepTime());
        recipe.setCookTime(recipeDTO.getCookTime());
        recipe.setTotalTime(recipeDTO.getTotalTime());

        if (recipeDTO.getIngredients() != null) {
            recipe.setIngredients(recipeDTO.getIngredients()
                    .stream().map(ingredientDTO -> ingredientDTOMapper.map(ingredientDTO))
                    .collect(Collectors.toList())
            );
        } else {
            recipe.setIngredients(null);
            System.out.println("debug check for"+ recipeDTO.getName());
            System.out.println("RecipeDTOMapper.mapDTOToRecipe: ingredients is null");
        }
        return recipe;
    }

    @Override
    public RecipeDTO entityToDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setInstructions(recipe.getInstructions());
        recipeDTO.setTags(recipe.getTags());
        recipeDTO.setServings(recipe.getServings());
        recipeDTO.setPrepTime(recipe.getPrepTime());
        recipeDTO.setCookTime(recipe.getCookTime());
        recipeDTO.setTotalTime(recipe.getTotalTime());

        if (recipe.getIngredients() != null) {
            recipeDTO.setIngredients(recipe.getIngredients()
                    .stream().map(ingredientDTOMapper::map)
                    .collect(Collectors.toList())
            );
        } else {
            recipeDTO.setIngredients(null);
            System.out.println("debug check for"+ recipe.getName());
            System.out.println("RecipeDTOMapper.mapRecipeToDTO: ingredients is null");
        }

        return recipeDTO;
    }








}
