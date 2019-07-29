package com.github.rkhusainov.bashsongs.repository;

import com.github.rkhusainov.bashsongs.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Integer> {
}
