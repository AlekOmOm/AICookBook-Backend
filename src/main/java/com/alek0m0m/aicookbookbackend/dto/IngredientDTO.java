package com.alek0m0m.aicookbookbackend.dto;


import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(as = IngredientDTO.class)
public class IngredientDTO extends BaseEntityDTO<Ingredient> {

    private String name;
    private int amount;
    private String unit;

    @Override
    public Ingredient toEntity() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(getId());
        ingredient.setName(getName());
        ingredient.setAmount(getAmount());
        ingredient.setUnit(getUnit());
        return ingredient;
    }
}
