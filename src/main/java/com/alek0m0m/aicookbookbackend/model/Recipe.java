package com.alek0m0m.aicookbookbackend.model;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe extends BaseEntity {

    private String name;
    private String instructions;
    private String tags;
    private int servings;
    private int prepTime;
    private int cookTime;
    private int totalTime;

    @OneToMany
    private List<Ingredient> ingredients;

}
