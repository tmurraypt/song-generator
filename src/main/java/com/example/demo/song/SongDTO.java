package com.example.demo.song;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SongDTO
{
    private UUID id;
    private String title;
    private String artist;
    private String key;
    private int bpm;

    private List<SectionDTO> progression = new ArrayList<>();

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public int getBpm()
    {
        return bpm;
    }

    public void setBpm(int bpm)
    {
        this.bpm = bpm;
    }

    public List<SectionDTO> getProgression()
    {
        return progression;
    }

    public void setProgression(List<SectionDTO> progression)
    {
        this.progression = progression;
    }
//    private String genre;
//    private List<String> composer;
//    private List<String> producer;
//    private LocalDate releaseDate;
//    private String album;
//    private BigInteger playTimeInSeconds;
//    private BigInteger streams;

}
