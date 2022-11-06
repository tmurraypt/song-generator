package com.example.demo.song.section;

import com.example.demo.song.chord.Chord;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Section
{
    private @Id @GeneratedValue UUID id;
    @Column(name = "letter")
    private Character sectionLetter;
    @ManyToMany
    @JoinTable(name = "chord_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "chord_id")
    )
    private List<Chord> chordList;

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public Character getSectionLetter()
    {
        return sectionLetter;
    }

    public void setSectionLetter(Character sectionLetter)
    {
        this.sectionLetter = sectionLetter;
    }

    public List<Chord> getChordList()
    {
        return chordList;
    }

    public void setChordList(List<Chord> chordList)
    {
        this.chordList = chordList;
    }
}
