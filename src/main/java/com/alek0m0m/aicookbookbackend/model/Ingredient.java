package com.alek0m0m.aicookbookbackend.model;

import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient extends BaseEntity{

    private String name;
    private int amount;
    private String unit;

}

