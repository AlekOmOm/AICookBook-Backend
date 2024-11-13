package com.alek0m0m.aicookbookbackend.controller;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTO;
import com.alek0m0m.aicookbookbackend.dto.IngredientDTOInput;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.repository.IngredientRepository;
import com.alek0m0m.aicookbookbackend.service.IngredientService;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientRESTController extends BaseRESTController<Ingredient, IngredientDTOInput, IngredientDTO, IngredientService, IngredientRepository> {

    protected IngredientRESTController(IngredientService service) {
        super(service);
    }

    @Override
    protected IngredientDTO convertToDTO(IngredientDTOInput dtoInput) {
        return null;
    }

}
