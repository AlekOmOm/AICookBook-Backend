package com.alek0m0m.aicookbookbackend.dto.serialization;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTO;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntityDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class BaseEntityDTODeserializer extends JsonDeserializer<BaseEntityDTO<?>> {

    @Override
    public BaseEntityDTO<?> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);

        // Identify RecipeDTO based on specific fields (or a type indicator, if available)
        if (node.has("instructions") && node.has("servings")) {
            RecipeDTO recipeDTO = new RecipeDTO();
            recipeDTO.setName(node.get("name").asText());
            recipeDTO.setInstructions(node.get("instructions").asText());
            recipeDTO.setTags(node.get("tags").asText());
            recipeDTO.setServings(node.get("servings").asInt());
            recipeDTO.setPrepTime(node.get("prepTime").asInt());
            recipeDTO.setCookTime(node.get("cookTime").asInt());
            recipeDTO.setTotalTime(node.get("totalTime").asInt());
            return recipeDTO;

        } else if (node.has("unit") && node.has("amount")) { // Identifies IngredientDTO
            IngredientDTO ingredientDTO = new IngredientDTO();
            ingredientDTO.setName(node.get("name").asText());
            ingredientDTO.setAmount(node.get("amount").asInt());
            ingredientDTO.setUnit(node.get("unit").asText());
            return ingredientDTO;
        }

        throw new IllegalArgumentException("Unknown type for BaseEntityDTO");
    }
}
