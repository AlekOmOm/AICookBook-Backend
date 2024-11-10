package com.alek0m0m.aicookbookbackend;

import com.Alek0m0m.library.jpa.BaseEntityDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


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
