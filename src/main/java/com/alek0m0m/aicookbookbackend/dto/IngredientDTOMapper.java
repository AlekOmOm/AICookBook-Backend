package com.alek0m0m.aicookbookbackend.dto;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientDTOMapper extends EntityToDTOMapperImpl<IngredientDTOInput, IngredientDTO, Ingredient> {

    @Override
    public IngredientDTO toDTO(IngredientDTOInput dtoInput) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(dtoInput.getId());
        ingredientDTO.setName(dtoInput.getName());
        ingredientDTO.setAmount(dtoInput.getAmount());
        ingredientDTO.setUnit(dtoInput.getUnit());
        return ingredientDTO;
    }

    @Override
    public Ingredient toEntity(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDTO.getId());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setAmount(ingredientDTO.getAmount());
        ingredient.setUnit(ingredientDTO.getUnit());
        return ingredient;
    }

    @Override
    public IngredientDTO entityToDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setAmount(ingredient.getAmount());
        ingredientDTO.setUnit(ingredient.getUnit());
        return ingredientDTO;
    }
}
