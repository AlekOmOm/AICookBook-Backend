package com.alek0m0m.aicookbookbackend.library.jpa;


import com.alek0m0m.aicookbookbackend.library.mvc.BaseRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public abstract class BaseEntityDTO<T extends BaseEntity>{

    private long id;

    public abstract  T toEntity();

    public void setId(long id) {
        this.id = id;
    }

}
