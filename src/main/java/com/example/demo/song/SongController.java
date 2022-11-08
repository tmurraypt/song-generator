package com.example.demo.song;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/demo/song")
@Validated
public class SongController
{
    private final static Logger logger = LogManager.getLogger(SongController.class);
    private final SongService songService;

    public SongController(SongService songService)
    {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<?> createSong(@Valid @RequestBody SongDTO song){
        try
        {
            return ResponseEntity.ok().body(songService.createSong(song));
        }
        catch(IllegalArgumentException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
