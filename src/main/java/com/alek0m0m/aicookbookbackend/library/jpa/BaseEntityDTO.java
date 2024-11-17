package com.alek0m0m.aicookbookbackend.library.jpa;


import com.alek0m0m.aicookbookbackend.library.mvc.BaseRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;



@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntityDTO<T extends BaseEntity>{

    private long id;

    public abstract  T toEntity();

}
