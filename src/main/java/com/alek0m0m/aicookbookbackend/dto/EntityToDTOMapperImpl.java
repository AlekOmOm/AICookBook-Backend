package com.alek0m0m.aicookbookbackend.dto;

import com.Alek0m0m.library.jpa.EntityToDTOMapper;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import org.springframework.stereotype.Service;

@Service
public class EntityToDTOMapperImpl implements EntityToDTOMapper<Recipe, RecipeDTO> {

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
//        recipeDTO.setIngredients(recipe.getIngredients());
//        recipeDTO.setInstructions(recipe.getInstructions());
//        recipeDTO.setCategory(recipe.getCategory());
//        recipeDTO.setPreparationTime(recipe.getPreparationTime());
//        recipeDTO.setCookingTime(recipe.getCookingTime());
//        recipeDTO.setServings(recipe.getServings());
//        recipeDTO.setDifficulty(recipe.getDifficulty());
//        recipeDTO.setRating(recipe.getRating());
//        recipeDTO.setAuthor(recipe.getAuthor());
//        recipeDTO.setCreated(recipe.getCreated());
//        recipeDTO.setUpdated(recipe.getUpdated());
        return recipeDTO;
    }

    public Recipe mapDTOToRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setName(recipeDTO.getName());
//        recipe.setIngredients(recipeDTO.getIngredients());
//        recipe.setInstructions(recipeDTO.getInstructions());
//        recipe.setCategory(recipeDTO.getCategory());
//        recipe.setPreparationTime(recipeDTO.getPreparationTime());
//        recipe.setCookingTime(recipeDTO.getCookingTime());
//        recipe.setServings(recipeDTO.getServings());
//        recipe.setDifficulty(recipeDTO.getDifficulty());
//        recipe.setRating(recipeDTO.getRating());
//        recipe.setAuthor(recipeDTO.getAuthor());
//        recipe.setCreated(recipeDTO.getCreated());
//        recipe.setUpdated(recipeDTO.getUpdated());
        return recipe;
    }

}
