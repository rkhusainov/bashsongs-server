package com.github.rkhusainov.bashsongs.controller;

import com.github.rkhusainov.bashsongs.model.Song;
import com.github.rkhusainov.bashsongs.repository.SearchRepository;
import com.github.rkhusainov.bashsongs.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SongController implements WebMvcConfigurer {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SearchRepository searchRepository;

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

    @GetMapping("/songs/search")
    public List<Song> findSongByName(
            @RequestParam("name") String name) {
        return searchRepository.findByNameLikeIgnoreCase("%" + name + "%");
    }
}
