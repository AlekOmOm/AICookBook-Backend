package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(as = RecipeDTO.class)
public class RecipeDTO extends BaseEntityDTO<Recipe> {

    private String name;
    private String instructions;
    private String tags;
    private int servings;
    private int prepTime;
    private int cookTime;
    private int totalTime;

    @OneToMany
    private List<Ingredient> ingredients;


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
        recipe.setIngredients(getIngredients());

        return recipe;
    }
}
