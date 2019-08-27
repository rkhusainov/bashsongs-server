package com.github.rkhusainov.bashsongs.controller;

import com.github.rkhusainov.bashsongs.model.Song;
import com.github.rkhusainov.bashsongs.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SongController {

    private @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/singers/{singerId}/songs")
    public List<Song> getAllSongsBySingerId(@PathVariable("singerId") int id) {
        return songRepository.findBySingerId(id);
    }

    @GetMapping("/songs/{songId}")
    public List<Song> getSongById(@PathVariable("songId") int id) {
        return songRepository.findAllById(Collections.singleton(id));
    }
}
