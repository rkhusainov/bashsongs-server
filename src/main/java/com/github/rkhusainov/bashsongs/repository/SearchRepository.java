package com.github.rkhusainov.bashsongs.repository;

import com.github.rkhusainov.bashsongs.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Song, Integer> {

    List<Song> findByName(String name);
}
