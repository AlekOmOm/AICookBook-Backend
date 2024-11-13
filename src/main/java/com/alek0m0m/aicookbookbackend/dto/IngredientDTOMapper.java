package com.alek0m0m.aicookbookbackend.dto;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientDTOMapper implements EntityToDTOMapper<Ingredient, IngredientDTO> {

    // ------------------ Interface methods ------------------
    @Override
    public IngredientDTO map(Ingredient ingredient) {
        return mapIngredientToDTO(ingredient);
    }
    public List<IngredientDTO> mapAll(List<Ingredient> ingredients) {
        return ingredients.stream().map(this::mapIngredientToDTO).toList();
    }

    public Ingredient map(IngredientDTO ingredientDTO) {
        return mapDTOToIngredient(ingredientDTO);
    }

    public List<Ingredient> mapAllDTOs(List<IngredientDTO> ingredientDTOs) {
        return ingredientDTOs.stream().map(this::mapDTOToIngredient).toList();
    }

    @Override
    public IngredientDTO apply(Ingredient ingredient) {
        return EntityToDTOMapper.super.apply(ingredient);
    }

    // ------------------ Concrete mappings ------------------
    private IngredientDTO mapIngredientToDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setAmount(ingredient.getAmount());
        ingredientDTO.setUnit(ingredient.getUnit());
        return ingredientDTO;
    }

    private Ingredient mapDTOToIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDTO.getId());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setAmount(ingredientDTO.getAmount());
        ingredient.setUnit(ingredientDTO.getUnit());
        return ingredient;
    }

}
