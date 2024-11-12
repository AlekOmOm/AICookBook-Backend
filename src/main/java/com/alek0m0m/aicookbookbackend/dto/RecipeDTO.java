package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.dto.serialization.BaseEntityDTODeserializer;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = BaseEntityDTODeserializer.class)
public class RecipeDTO extends BaseEntityDTO<Recipe> {

    private String name;
    private String instructions;
    private String tags;
    private int servings;
    private int prepTime;
    private int cookTime;
    private int totalTime;
    @OneToMany
    @JsonProperty("ingredients")
    private List<IngredientDTO> ingredients;

    /*
    POST /api/recipes
    {
  "name": "Pasta",
  "instructions": "Cook pasta, add tomato sauce",
    "tags": "pasta, italian",
    "servings": 2,
    "prepTime": 5,
    "cookTime": 10,
    "totalTime": 15,

  "ingredients": [
    {
      "name": "Pasta",
      "quantity": 200,
      "unit": "g"
    },
    {
      "name": "Tomato sauce",
      "quantity": 100,
      "unit": "g"
    }
  ]
}
     */


    @Override
    public Recipe toEntity() {
        Recipe recipe = new Recipe();
        recipe.setId(getId());
        recipe.setName(getName());
        recipe.setInstructions(getInstructions());
        recipe.setTags(getTags());
        recipe.setServings(getServings());
        recipe.setPrepTime(getPrepTime());
        recipe.setCookTime(getCookTime());
        recipe.setTotalTime(getTotalTime());
        recipe.setIngredients(ingredients.stream().map(ingredientDTO -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDTO.getName());
            ingredient.setAmount(ingredientDTO.getAmount());
            ingredient.setUnit(ingredientDTO.getUnit());
            return ingredient;
        }).collect(Collectors.toList()));

        return recipe;
    }
}
