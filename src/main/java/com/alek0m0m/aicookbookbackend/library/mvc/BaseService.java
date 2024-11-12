package com.alek0m0m.aicookbookbackend.library.mvc;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public abstract class BaseService<T extends BaseEntity, R extends BaseEntityDTO<T>, RepositoryClass extends BaseRepository<T>> implements BaseServiceInterface<T,R> {

    private final RepositoryClass baseRepository;
    private final EntityToDTOMapper<T, R> entityToDtoMapper;

    @Autowired
    protected BaseService(RepositoryClass repository, EntityToDTOMapper<T,R> entityToDtoMapper) {
        this.baseRepository = repository;

        this.entityToDtoMapper = entityToDtoMapper;
    }

    public BaseRepository<T> getRepository() {
        return baseRepository;
    }

    @Transactional
    public R save(BaseEntityDTO<T> entityDTO) {
        System.out.println("Saving entity: " + entityDTO);
        return entityToDtoMapper.apply(
                getRepository()
                        .save(entityDTO.toEntity()));
    }
    // save all

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
        return baseRepository.findAll().stream()
                .map(entityToDtoMapper)
                .filter(filter)
                .collect(Collectors.toList());
    }

    public List<R> findAllAndConvertToDTO() {
        return baseRepository.findAll().stream()
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


}
