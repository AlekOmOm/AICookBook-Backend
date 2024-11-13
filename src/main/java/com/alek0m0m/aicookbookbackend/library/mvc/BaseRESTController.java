package com.alek0m0m.aicookbookbackend.library.mvc;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.function.Predicate;

@RestController
public abstract class BaseRESTController<dto, R extends BaseEntityDTO<T>, T extends BaseEntity, DtoMapper extends EntityToDTOMapper<dto, R, T>, ServiceClass extends BaseService<dto, R,T, DtoMapper, RepositoryClass>, RepositoryClass extends BaseRepository<T>> implements BaseRESTControllerInterface<dto, R, T, DtoMapper> {

    private final BaseService<dto,R, T, DtoMapper, RepositoryClass> baseService;
    protected final ServiceClass service;

    @Autowired
    protected BaseRESTController(ServiceClass service) {
        this.baseService = service;
        this.service = service;
    }

    public BaseService <dto,R, T, DtoMapper, BaseRepository<T>> getService() {
        return (BaseService<dto, R, T, DtoMapper, BaseRepository<T>>) baseService;
    }

    private R convertToDTO(dto dtoInput) {
        return service.getDtoMapper().map(dtoInput);
    }

    // ------------------- CRUD -------------------

    @PostMapping
    public ResponseEntity<R> create(@RequestBody dto dto) {
        if (dto == null) {
            return ResponseEntity.badRequest().build();
        }

        R dtoConverted = convertToDTO(dto);

        System.out.println("BaseRESTController.create: " + dto);

        return ResponseEntity.ok(getService().save(convertToDTO(dto)));
    }

    @GetMapping
    public ResponseEntity<List<R>> getAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /* example:
    @GetMapping("/filter")
    public ResponseEntity<List<T>> getFilteredEntities() {
        return getAllEntities(BaseEntity::condition);
    }
     */
      /* example:
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllActiveUsers() {
        // Filter only active users and transform into UserDTO
        return getAllAndConvert(user -> user.isActive() ? new UserDTO(user) : null);
    } */

    public ResponseEntity<List<R>> getAllFiltered(Predicate<R> filter) {
        return ResponseEntity.ok(getService().findAll(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<R> getById(@PathVariable long id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<R> update(@PathVariable long id, @RequestBody dto dto) {
        R existingEntity = getService().findById(id);
        existingEntity.setId(id);
        return ResponseEntity.ok(getService().save(existingEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (getService().findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        getService().deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // delete all
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        getService().deleteAll();
        return ResponseEntity.noContent().build();
    }

    // ------------------- Helper methods -------------------

    @PostMapping("/reset-auto-increment")
    public ResponseEntity<Void> resetAutoIncrement() {
        getService().resetAutoIncrement();
        return ResponseEntity.noContent().build();
    }
}
