package com.alek0m0m.aicookbookbackend.dto;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientDTOMapper implements EntityToDTOMapper<Ingredient, IngredientDTO> {

    @Override
    public IngredientDTO map(Ingredient ingredient) {
        return mapRecipeToDTO(ingredient);
    }

    public Ingredient map(IngredientDTO ingredientDTO) {
        return mapDTOToRecipe(ingredientDTO);
    }

    @Override
    public IngredientDTO apply(Ingredient ingredient) {
        return EntityToDTOMapper.super.apply(ingredient);
    }

    private IngredientDTO mapRecipeToDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setAmount(ingredient.getAmount());
        ingredientDTO.setUnit(ingredient.getUnit());
        return ingredientDTO;
    }

    private Ingredient mapDTOToRecipe(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDTO.getId());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setAmount(ingredientDTO.getAmount());
        ingredient.setUnit(ingredientDTO.getUnit());
        return ingredient;
    }

    public List<IngredientDTO> applyAll(List<Ingredient> ingredients) {
        return ingredients.stream().map(this::mapRecipeToDTO).toList();
    }
}
