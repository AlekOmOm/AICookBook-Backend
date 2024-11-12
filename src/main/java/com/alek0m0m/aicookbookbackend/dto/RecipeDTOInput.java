package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.dto.serialization.BaseEntityDTODeserializer;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
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
@JsonDeserialize(as = RecipeDTOInput.class)
public class RecipeDTOInput {

    private long id;
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

    public RecipeDTO toDTO() {
        RecipeDTO recipeDTO = new RecipeDTO();
//        recipeDTO.setId(getId());
//        recipeDTO.setName(getName());
//        recipeDTO.setInstructions(getInstructions());
//        recipeDTO.setTags(getTags());
//        recipeDTO.setServings(getServings());
//        recipeDTO.setPrepTime(getPrepTime());
//        recipeDTO.setCookTime(getCookTime());
//        recipeDTO.setTotalTime(getTotalTime());
//        recipeDTO.setIngredients(ingredients.stream().map(ingredientDTO -> {
//            Ingredient ingredient = new Ingredient();
//            ingredient.setName(ingredientDTO.getName());
//            ingredient.setAmount(ingredientDTO.getAmount());
//            ingredient.setUnit(ingredientDTO.getUnit());
//            return ingredient;
//        }).collect(Collectors.toList()));
        return recipeDTO;
    }
}
