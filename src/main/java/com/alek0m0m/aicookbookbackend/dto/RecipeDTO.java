package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.dto.serialization.BaseEntityDTODeserializer;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonProperty("ingredients")
    private List<IngredientDTO> ingredients;

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
        recipe.setIngredients(mapIngredients());

        return recipe;
    }

    private List<Ingredient> mapIngredients() {
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
