package com.alek0m0m.aicookbookbackend.library.mvc;


import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {


    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE #{#entityName} AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();




}
