package com.github.rkhusainov.bashsongs.repository;

import com.github.rkhusainov.bashsongs.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findBySingerId(Integer singerId);

}
