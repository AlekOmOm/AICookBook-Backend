package com.alek0m0m.aicookbookbackend.dto;

import com.Alek0m0m.library.jpa.BaseEntityDTO;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RecipeDTO extends BaseEntityDTO<Recipe> {

    private String name;
    //private List<Ingredient> ingredients;
    //private List<String> instructions;

    @Override
    public Recipe toEntity() {
        Recipe recipe = new Recipe();
        recipe.setId(getId());
        recipe.setName(getName());
        return recipe;
    }
}
