package com.alek0m0m.aicookbookbackend.model;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipe extends BaseEntity {

    private String name;
    @Column(columnDefinition = "TEXT")
    private String instructions;
    private String tags;
    private int servings;
    private int prepTime;
    private int cookTime;
    private int totalTime;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Ingredient> ingredients;

}
