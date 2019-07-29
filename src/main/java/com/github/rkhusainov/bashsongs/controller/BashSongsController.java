package com.github.rkhusainov.bashsongs.controller;

import com.github.rkhusainov.bashsongs.model.Singer;
import com.github.rkhusainov.bashsongs.model.Song;
import com.github.rkhusainov.bashsongs.repository.SingerRepository;
import com.github.rkhusainov.bashsongs.repository.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BashSongsController {

    private static final Logger log = LoggerFactory.getLogger(BashSongsController.class);

    @Autowired
    private SingerRepository singerRepository;

    private @Autowired
    SongRepository songRepository;

    @GetMapping("/singers")
    public Iterable<Singer> getSingers() {
        return singerRepository.findAll();
    }

    @GetMapping("/songs/{id}")
    public List<Song> getSongList(@PathVariable("id") int id) {
        List<Song> songs = songRepository.findAllById(Collections.singleton(id));

        log.info("Размер полученных песен {}", songs.size());
        return songs;
    }


}
