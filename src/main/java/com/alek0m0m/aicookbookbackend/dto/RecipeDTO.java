package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonDeserialize(as = RecipeDTO.class)
public class RecipeDTO extends BaseEntityDTO<Recipe> {

    private long id;
    private String name;
    private String instructions;
    private String tags;
    private int servings;
    private int prepTime;
    private int cookTime;
    private int totalTime;

    @JsonProperty("ingredients")
    private List<IngredientDTO> ingredients;

    @Override
    public Recipe toEntity() {
        Recipe recipe = new Recipe();
        recipe.setId(this.id);
        recipe.setName(getName());
        recipe.setInstructions(getInstructions());
        recipe.setTags(getTags());
        recipe.setServings(getServings());
        recipe.setPrepTime(getPrepTime());
        recipe.setCookTime(getCookTime());
        recipe.setTotalTime(getTotalTime());

        if (getIngredients() != null) {
            recipe.setIngredients(getIngredients().stream().map(IngredientDTO::toEntity).collect(Collectors.toList()));
        } else {
            recipe.setIngredients(null);
            System.out.println("debug check for"+ recipe.getName());
            System.out.println("RecipeDTO.toEntity: ingredients is null");
        }

        return recipe;
    }

    private List<Ingredient> mapIngredients(List<IngredientDTO> ingredients) {
        return ingredients.stream().map(this::mapIngredient).collect(Collectors.toList());
    }

    private Ingredient mapIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName());
        ingredient.setAmount(ingredientDTO.getAmount());
        ingredient.setUnit(ingredientDTO.getUnit());
        return ingredient;
    }
}
