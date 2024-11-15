package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntityDTO;
import com.alek0m0m.aicookbookbackend.model.User;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTOInput {

    private String username;
    private String password;

}
