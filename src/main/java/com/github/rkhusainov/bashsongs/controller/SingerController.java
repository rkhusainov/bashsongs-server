package com.github.rkhusainov.bashsongs.controller;

import com.github.rkhusainov.bashsongs.model.Singer;
import com.github.rkhusainov.bashsongs.repository.SingerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SingerController {

    private static final Logger log = LoggerFactory.getLogger(SingerController.class);

    @Autowired
    private SingerRepository singerRepository;

    @GetMapping("/singers")
    public Iterable<Singer> getSingers() {
        return singerRepository.findAll();
    }
}
