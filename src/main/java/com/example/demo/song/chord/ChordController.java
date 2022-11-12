package com.example.demo.song.chord;

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
@RequestMapping("api/demo/song/chord")
@Validated
public class ChordController
{
    private final static Logger logger = LogManager.getLogger(ChordController.class);
    private final ChordService chordService;

    public ChordController(ChordService chordService)
    {
        this.chordService = chordService;
    }

    @PostMapping
    public ResponseEntity<?> createChord(@Valid @RequestBody ChordDTO chord){
        try
        {
            return ResponseEntity.ok().body(chordService.createChord(chord));
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
    public List<Chord> getAllChords()
    {
        return chordService.getAllChords();
    }

    @GetMapping("/{id}")
    public Optional<Chord> getChordById(@PathVariable UUID id)
    {
        return chordService.getChordById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteChordById(@PathVariable UUID id)
    {
        chordService.deleteChordById(id);
    }

    @PutMapping("/{id}")
    public Optional<Chord> updateChord(@RequestBody ChordDTO chord, @PathVariable UUID id)
    {
        return chordService.updateChord(chord, id);
    }
}
