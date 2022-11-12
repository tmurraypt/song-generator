package com.example.demo.song;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Song> getSongById(@PathVariable UUID id)
    {
        return songService.getSongById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSongById(@PathVariable UUID id)
    {
        songService.deleteSongById(id);
    }

    @PutMapping("/{id}")
    public Optional<Song> updateSong(@RequestBody SongDTO song, @PathVariable UUID id)
    {
        return songService.updateSong(song, id);
    }
}
