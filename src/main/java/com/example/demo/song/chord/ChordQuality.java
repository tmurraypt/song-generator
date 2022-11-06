package com.example.demo.song.chord;

public enum ChordQuality
{

    MAJOR("maj"), MINOR("min"), DIMINISHED("dim"), AUGMENTED("aug");

    private final String displayName;

    ChordQuality(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }
}
