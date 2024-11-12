package com.alek0m0m.aicookbookbackend.model;

import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ingredient extends BaseEntity{

    private String name;
    private int amount;
    private String unit;

}

