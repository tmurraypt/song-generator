package com.example.demo.song.section;

import com.example.demo.song.chord.ChordDTO;

import java.util.List;


public class SectionDTO
{
    private Character sectionLetter;
    private List<ChordDTO> chordList;



    public Character getSectionLetter()
    {
        return sectionLetter;
    }

    public void setSectionLetter(Character sectionLetter)
    {
        this.sectionLetter = sectionLetter;
    }

    public List<ChordDTO> getChordList()
    {
        return chordList;
    }

    public void setChordList(List<ChordDTO> chordList)
    {
        this.chordList = chordList;
    }
}
