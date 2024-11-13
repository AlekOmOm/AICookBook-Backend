package com.alek0m0m.aicookbookbackend.service;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTO;
import com.alek0m0m.aicookbookbackend.dto.IngredientDTOMapper;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService extends BaseService<Ingredient, IngredientDTO, IngredientRepository> {

    private final IngredientDTOMapper ingredientDTOMapper;

    protected IngredientService(IngredientRepository repository, EntityToDTOMapper<Ingredient, IngredientDTO> entityToDtoMapper, IngredientDTOMapper ingredientDTOMapper) {
        super(repository, entityToDtoMapper);
        this.ingredientDTOMapper = ingredientDTOMapper;
    }

    public IngredientDTO save(IngredientDTO ingredientDTO) {
        return super.save(ingredientDTO);
    }

    // saveAll

    public List<Ingredient> saveAllIngredients(List<Ingredient> ingredients) {

        ingredients.stream().map(ingredient ->
                save(ingredientDTOMapper.apply(ingredient)));

        return ingredients;
    }

    public IngredientDTO update(IngredientDTO ingredientDTO) {
        return super.update(ingredientDTO);
    }

}
