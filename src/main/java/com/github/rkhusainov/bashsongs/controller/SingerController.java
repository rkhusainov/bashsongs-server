package com.github.rkhusainov.bashsongs.controller;

import com.github.rkhusainov.bashsongs.model.Singer;
import com.github.rkhusainov.bashsongs.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SingerController {

    @Autowired
    private SingerRepository singerRepository;

    @GetMapping("/singers")
    public List<Singer> getSingers() {
        return singerRepository.findAll();
    }

}
