package com.alek0m0m.aicookbookbackend.library.mvc;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface BaseRESTControllerInterface<dtoinput, R extends BaseEntityDTO<T>, T extends BaseEntity, DtoMapper extends EntityToDTOMapperImpl<dtoinput, R, T>> {
    BaseService<dtoinput,R,T, DtoMapper,BaseRepository<T>> getService();

    // ------------------- CRUD -------------------

    // @PostMapping()
    // public ResponseEntity<R> create(BaseEntityDTO<T> entityDTO);

    @GetMapping()
    public ResponseEntity<List<R>> getAll();

    @GetMapping("/{id}")
    public ResponseEntity<R> getById(long id);

//    @PutMapping("/{id}")
//    public ResponseEntity<R> update(long id, R entityDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(long id);
}
