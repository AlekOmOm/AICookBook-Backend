package com.alek0m0m.aicookbookbackend.library.jpa;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTO;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public interface EntityToDTOMapper<dtoinput, R extends BaseEntityDTO<T>, T extends BaseEntity> extends Function<T, R> {
    R map(dtoinput dtoinput);

    T map(R dto);

    R map(T entity);

    @Override
    default R apply(T t) {
        return map(t);
    }

}