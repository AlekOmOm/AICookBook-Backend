package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntityDTO;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonDeserialize(as = IngredientDTO.class)
public class IngredientDTO extends BaseEntityDTO<Ingredient> {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("unit")
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