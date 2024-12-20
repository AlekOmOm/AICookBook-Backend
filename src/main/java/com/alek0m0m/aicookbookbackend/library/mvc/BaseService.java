package com.alek0m0m.aicookbookbackend.library.mvc;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public abstract class BaseService<dtoinput, R extends BaseEntityDTO<T>, T extends BaseEntity, DtoMapper extends EntityToDTOMapperImpl<dtoinput, R, T>, RepositoryClass extends BaseRepository<T>> implements BaseServiceInterface<R,T> {

    private final RepositoryClass repository;
    private final DtoMapper mapper;
    private final BaseService subServiceClass;

    @Autowired
    protected BaseService(RepositoryClass repository, DtoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.subServiceClass = null;
    }
    @Autowired
    protected BaseService(BaseService subServiceClass, RepositoryClass repository, DtoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.subServiceClass = subServiceClass;
    }

    public BaseRepository<T> getRepository() {
        return repository;
    }
    public EntityToDTOMapper<dtoinput, R, T> getDtoMapper() {
        return mapper;
    }
    public BaseService getSubServiceClass() {
        return subServiceClass;
    }

    protected void resetAutoIncrement() {
        repository.resetAutoIncrement();
    }

    // --------------------- CRUD ---------------------
    @Transactional
    public R save(BaseEntityDTO<T> entityDTO) {
        resetAutoIncrement();

        T t = entityDTO.toEntity();
            debugPrint("save()", t.toString());

        R e = mapper.entityToDTO(
                getRepository()
                .save(entityDTO.toEntity()));

            debugPrint("save()", e.toString());
        return e;
    }

    @Transactional
    public List<R> saveAll(List<BaseEntityDTO<T>> entityDTOs) {
        resetAutoIncrement();
        return getRepository().saveAll(
                entityDTOs.stream()
                        .map(BaseEntityDTO::toEntity)
                        .collect(Collectors.toList()))
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    @Transactional
    public R update(BaseEntityDTO<T> entityDTO) {
        resetAutoIncrement();
        return mapper.apply(
                getRepository()
                        .save(entityDTO.toEntity()));
    }

    @Override
    public List<R> findAll() {
        return getRepository().findAll().stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public List<R> findAll(Predicate<R> filter) {
        return repository.findAll().stream()
                .map(mapper)
                .filter(filter)
                .collect(Collectors.toList());
    }

    @Override
    public R findById(long id) {
        return getRepository().findById(id)
                .map(mapper)
                .orElseThrow(()
                        -> new EntityNotFoundException("Entity not found"));
    }


    @Override
    public void deleteById(long id) {
        getRepository().deleteById(id);
    }


    // delete all
    public void deleteAll() {
        resetAutoIncrement();
        getRepository().deleteAll();
    }

    // ------------------- Helper methods -------------------

    private void debugPrint(String method, String message) {
        System.out.println();
        System.out.println("debug check for "+ method);
        System.out.println(" "+message);
        System.out.println();
    }

}
