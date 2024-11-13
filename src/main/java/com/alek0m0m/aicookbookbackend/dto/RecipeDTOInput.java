package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonDeserialize(as = RecipeDTOInput.class)
public class RecipeDTOInput {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("instructions")
    private String instructions;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("servings")
    private int servings;

    @JsonProperty("prepTime")
    private int prepTime;

    @JsonProperty("cookTime")
    private int cookTime;

    @JsonProperty("totalTime")
    private int totalTime;

    @OneToMany
    @JsonProperty("ingredients")
    private List<IngredientDTO> ingredients;

    public RecipeDTO toDTO() {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(this.id);
        recipeDTO.setName(this.name);
        recipeDTO.setInstructions(this.instructions);
        recipeDTO.setTags(this.tags);
        recipeDTO.setServings(this.servings);
        recipeDTO.setPrepTime(this.prepTime);
        recipeDTO.setCookTime(this.cookTime);
        recipeDTO.setTotalTime(this.totalTime);
        if (this.ingredients == null) {
            return recipeDTO;
        }
        recipeDTO.setIngredients(this.ingredients);
        return recipeDTO;
    }
}