package com.alek0m0m.aicookbookbackend.config;

import com.alek0m0m.aicookbookbackend.dto.RecipeDTOMapper;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.model.User;
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

    @Autowired
    public initData(UserService userService, UserDTOMapper userDTOMapper, RecipeService recipeService, RecipeDTOMapper recipeDTOMapper) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
        this.recipeService = recipeService;
        this.recipeDTOMapper = recipeDTOMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Init data");

        userData();
        recipeData();
    }

    private void recipeData() {
        // Pasta recipe
        Recipe recipe = new Recipe();
        recipe.setName("Pasta");
        recipe.setInstructions("Cook pasta in boiling water for 10 minutes");
        recipe.setTags("pasta, italian");
        recipe.setServings(2);
        recipe.setPrepTime(5);
        recipe.setCookTime(10);
        recipe.setTotalTime(15);
        recipe.setIngredients(List.of(
                new Ingredient("Pasta", 200, "g"),
                new Ingredient("Salt", 1, "tsp")
        ));

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
