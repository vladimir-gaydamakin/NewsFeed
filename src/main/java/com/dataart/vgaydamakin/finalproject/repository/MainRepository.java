package com.dataart.vgaydamakin.finalproject.repository;

import com.dataart.vgaydamakin.finalproject.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends JpaRepository<News, Long> {

    @Query("select n from News n order by n.id desc")
    @Override
    List<News> findAll();

    @Query("select n from News n order by n.id desc")
    @Override
    Page<News> findAll(Pageable pageable);

}
