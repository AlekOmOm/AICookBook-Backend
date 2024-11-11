package com.alek0m0m.aicookbookbackend.model;

// import from library AlekOmOm
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Component
@Getter
@Setter
public class User extends BaseEntity {

    private String username;
    private String password;


}