package com.alek0m0m.aicookbookbackend.model;

import com.Alek0m0m.library.jpa.BaseEntity;
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
public class Recipe extends BaseEntity {

    private String name;


}
