package com.alek0m0m.aicookbookbackend.library.mvc;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public abstract class BaseService<T extends BaseEntity, R extends BaseEntityDTO<T>, RepositoryClass extends BaseRepository<T>> implements BaseServiceInterface<T,R> {

    private final RepositoryClass repository;
    private final EntityToDTOMapper<T, R> entityToDtoMapper;


    @Autowired
    protected BaseService(RepositoryClass repository, EntityToDTOMapper<T,R> entityToDtoMapper) {
        this.repository = repository;
        this.entityToDtoMapper = entityToDtoMapper;
    }

    public BaseRepository<T> getRepository() {
        return repository;
    }

    @Transactional
    @Before("execution(* com.alek0m0m.aicookbookbackend.service.*.*(..))")
    public void before() {
        repository.resetAutoIncrement();
    }

    // --------------------- CRUD ---------------------
    @Transactional
    public R save(BaseEntityDTO<T> entityDTO) {
        System.out.println("Saving entity: " + entityDTO);

        T entity = entityDTO.toEntity();

        System.out.println("Entity saved: " + entity);

        return entityToDtoMapper.apply(
                getRepository()
                        .save(entity));
    }

    @Transactional
    public List<R> saveAll(List<BaseEntityDTO<T>> entityDTOs) {
        return getRepository().saveAll(
                entityDTOs.stream()
                        .map(BaseEntityDTO::toEntity)
                        .collect(Collectors.toList()))
                .stream()
                .map(entityToDtoMapper)
                .collect(Collectors.toList());
    }

    @Transactional
    public R update(BaseEntityDTO<T> entityDTO) {
        return entityToDtoMapper.apply(
                getRepository()
                        .save(entityDTO.toEntity()));
    }

    @Override
    public List<R> findAll() {
        return getRepository().findAll().stream()
                .map(entityToDtoMapper)
                .collect(Collectors.toList());
    }

    public List<R> findAll(Predicate<R> filter) {
        return repository.findAll().stream()
                .map(entityToDtoMapper)
                .filter(filter)
                .collect(Collectors.toList());
    }

    public List<R> findAllAndConvertToDTO() {
        return repository.findAll().stream()
                .map(entityToDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public R findById(long id) {
        return getRepository().findById(id)
                .map(entityToDtoMapper)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }


    @Override
    public void deleteById(long id) {
        getRepository().deleteById(id);
    }


    // delete all
    public void deleteAll() { getRepository().deleteAll(); }


}
