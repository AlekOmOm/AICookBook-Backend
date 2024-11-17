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
}