package com.alek0m0m.aicookbookbackend.test;


import com.alek0m0m.aicookbookbackend.controller.RecipeRESTController;
import com.alek0m0m.aicookbookbackend.dto.*;
import com.alek0m0m.aicookbookbackend.service.*;
import com.alek0m0m.aicookbookbackend.repository.*;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTOInput;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
import com.alek0m0m.aicookbookbackend.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeRESTController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    public void testCreateRecipe() throws Exception {
        RecipeDTOInput recipeDTOInput = new RecipeDTOInput();
        // Set properties of recipeDTOInput

        RecipeDTO recipeDTO = new RecipeDTO();
        // Set properties of recipeDTO

        when(recipeService.save(any(RecipeDTO.class))).thenReturn(recipeDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Pasta\", \"instructions\": \"Cook pasta in boiling water for 10 minutes\" }"))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateRecipe() throws Exception {
        RecipeDTOInput recipeDTOInput = new RecipeDTOInput();
        // Set properties of recipeDTOInput

        RecipeDTO recipeDTO = new RecipeDTO();
        // Set properties of recipeDTO

        when(recipeService.findById(any(Long.class))).thenReturn(recipeDTO);
        when(recipeService.save(any(RecipeDTO.class))).thenReturn(recipeDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/recipes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Updated Pasta\", \"instructions\": \"Cook pasta in boiling water for 12 minutes\" }"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllRecipes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/recipes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteRecipe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/recipes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
