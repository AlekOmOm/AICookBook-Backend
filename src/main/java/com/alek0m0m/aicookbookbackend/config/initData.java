package com.alek0m0m.aicookbookbackend.config;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTOMapper;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTOMapper;
import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntityDTO;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.model.User;
import com.alek0m0m.aicookbookbackend.service.IngredientService;
import com.alek0m0m.aicookbookbackend.service.RecipeService;
import com.alek0m0m.aicookbookbackend.service.UserService;
import com.alek0m0m.aicookbookbackend.dto.UserDTOMapper;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class initData implements CommandLineRunner {
    private final UserService userService;
    private final UserDTOMapper userDTOMapper;
    private final RecipeService recipeService;
    private final RecipeDTOMapper recipeDTOMapper;
    private final IngredientService ingredientService;
    private final IngredientDTOMapper ingredientDTOMapper;

    @Autowired
    public initData(UserService userService, UserDTOMapper userDTOMapper, RecipeService recipeService, RecipeDTOMapper recipeDTOMapper, IngredientService ingredientService, IngredientDTOMapper ingredientDTOMapper) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
        this.recipeService = recipeService;
        this.recipeDTOMapper = recipeDTOMapper;
        this.ingredientService = ingredientService;
        this.ingredientDTOMapper = ingredientDTOMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Init data");

        userData();
        recipeData();
    }

    private void recipeData() {
        Recipe recipe = new Recipe();
        recipe.setName("Pasta");
        recipe.setInstructions("Cook pasta in boiling water for 10 minutes");
        recipe.setTags("pasta, italian");
        recipe.setServings(2);
        recipe.setPrepTime(5);
        recipe.setCookTime(10);
        recipe.setTotalTime(15);
        Ingredient i1 = new Ingredient("Cucumber", 200, "g");
        Ingredient i2 = new Ingredient("Spinach", 1, "tsp");
        recipe.setIngredients(List.of(i1, i2));

        // Save recipe
        recipeService.save(recipeDTOMapper.apply(recipe));
    }

    private void userData() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");

        userService.save(userDTOMapper.apply(user));
    }
}
