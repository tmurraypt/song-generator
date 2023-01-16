package com.example.demo.song.section;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/demo/song/section")
@Validated
public class SectionController
{
    private final static Logger logger = LogManager.getLogger(SectionController.class);
    private final SectionService sectionService;

    public SectionController(SectionService sectionService)
    {
        this.sectionService = sectionService;
    }


    @PostMapping
    public ResponseEntity<?> createSection(@Valid @RequestBody SectionDTO section){
        try
        {
            return ResponseEntity.ok().body(sectionService.createSection(section));
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
    public List<Section> getAllSections()
    {
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSectionById(@PathVariable UUID id)
    {
        try
        {
            return ResponseEntity.ok().body(sectionService.getSectionById(id));
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
    public void deleteSectionById(@PathVariable UUID id)
    {
        sectionService.deleteSectionById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSection(@RequestBody SectionDTO section, @PathVariable UUID id)
    {
        try
        {
            return ResponseEntity.ok().body(sectionService.updateSection(section, id));
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
