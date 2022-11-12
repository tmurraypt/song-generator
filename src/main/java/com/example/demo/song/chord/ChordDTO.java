package com.example.demo.song.chord;

import java.util.UUID;


public class ChordDTO
{
    private UUID id;
    private int chordNumber;
    private ChordQuality chordQuality;
    private int chordExtension;
    private String additionalInfo;

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
}
