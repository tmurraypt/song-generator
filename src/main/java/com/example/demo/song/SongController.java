package com.example.demo.song;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/demo/song")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
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
        catch(Exception ex)
        {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping
    public List<Song> getAllSongs()
    {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSongById(@PathVariable UUID id)
    {
        try
        {
            return ResponseEntity.ok().body(songService.getSongById(id));
        }
        catch(IllegalArgumentException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch(Exception ex)
        {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSongById(@PathVariable UUID id)
    {
        songService.deleteSongById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSong(@RequestBody SongDTO song, @PathVariable UUID id)
    {
        try
        {
            return ResponseEntity.ok().body(songService.updateSong(song, id));
        }
        catch(IllegalArgumentException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch(Exception ex)
        {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
