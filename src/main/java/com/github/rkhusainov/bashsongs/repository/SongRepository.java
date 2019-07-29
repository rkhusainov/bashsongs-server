package com.github.rkhusainov.bashsongs.repository;

import com.github.rkhusainov.bashsongs.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}
