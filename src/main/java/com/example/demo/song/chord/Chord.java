package com.example.demo.song.chord;

import com.example.demo.song.section.Section;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Chord
{
    private @Id @GeneratedValue
    UUID id;
    private int chordNumber;
    private ChordQuality chordQuality;
    private int chordExtension;
    private String additionalInfo;
    @ManyToMany(mappedBy = "chordList")
    private List<Section> sections;

    public Chord(){

    }

    public Chord(ChordDTO chordDto){
        setChordNumber(chordDto.getChordNumber());
        setChordQuality(chordDto.getChordQuality());
        setChordExtension(chordDto.getChordExtension());
        setAdditionalInfo(chordDto.getAdditionalInfo());
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public int getChordNumber()
    {
        return chordNumber;
    }

    public void setChordNumber(int chordNumber)
    {
        this.chordNumber = chordNumber;
    }

    public ChordQuality getChordQuality()
    {
        return chordQuality;
    }

    public void setChordQuality(ChordQuality chordQuality)
    {
        this.chordQuality = chordQuality;
    }

    public int getChordExtension()
    {
        return chordExtension;
    }

    public void setChordExtension(int chordExtension)
    {
        this.chordExtension = chordExtension;
    }

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
    }

    public List<Section> getSections()
    {
        return sections;
    }

    public void setSections(List<Section> sections)
    {
        this.sections = sections;
    }
}

