package com.example.demo.song;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/demo/song")
public class SongController
{
    private final static Logger logger = LogManager.getLogger(SongController.class);
    private final SongService songService = new SongService();

    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody SongDTO song){
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
