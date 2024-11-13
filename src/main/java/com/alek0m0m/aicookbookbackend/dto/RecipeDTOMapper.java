package com.alek0m0m.aicookbookbackend.dto;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeDTOMapper implements EntityToDTOMapper<RecipeDTOInput, RecipeDTO, Recipe> {

    private final IngredientDTOMapper ingredientDTOMapper;
    @Autowired
    public RecipeDTOMapper(IngredientDTOMapper ingredientDTOMapper) {
        this.ingredientDTOMapper = ingredientDTOMapper;
    }

    // ------------------ Interface methods ------------------

    @Override
    public RecipeDTO map(RecipeDTOInput recipeDTOInput) {
        return recipeDTOInput.toDTO();
    }

    @Override
    public RecipeDTO map(Recipe recipe) {
        return mapRecipeToDTO(recipe);
    }

    @Override
    public Recipe map(RecipeDTO dto) {
        return dto.toEntity();
    }


    public List<RecipeDTO> mapAll(List<Recipe> RecipeDTOs) {
        return RecipeDTOs.stream().map(this::mapRecipeToDTO).toList();
    }




    // ------------------ Concrete mappings ------------------


    public RecipeDTO mapRecipeToDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        System.out.println("mapRecipeToDTO: " + recipe.getId());
        System.out.println(" on entity:"+ recipe);
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

}
