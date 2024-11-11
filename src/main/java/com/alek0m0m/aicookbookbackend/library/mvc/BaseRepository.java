package com.alek0m0m.aicookbookbackend.library.mvc;


import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
