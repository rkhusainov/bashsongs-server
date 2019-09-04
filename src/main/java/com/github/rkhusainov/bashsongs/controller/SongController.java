package com.github.rkhusainov.bashsongs.controller;

import com.github.rkhusainov.bashsongs.model.Song;
import com.github.rkhusainov.bashsongs.repository.SearchRepository;
import com.github.rkhusainov.bashsongs.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SearchRepository searchRepository;

    /**
     * Index main page.
     */
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Попробуйте найти в поиске: " +
                "<a href='/songs/search?name=урал'>/songs/search?name=Урал</a>";
    }

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
//        String lowerName = name.toLowerCase();
        if (name == null) {
            return searchRepository.findAll();
        } else {
            return searchRepository.findByName(name);
        }
    }
}
