package com.example.demo.song;

import com.example.demo.song.section.Section;
import com.example.demo.song.section.SectionDTO;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "song")
public class Song
{

    private @Id @GeneratedValue UUID id;
    private String title;
    private String artist;
    private String key;
    private int bpm;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Section> progression;

    public Song(){

    }

    public Song(SongDTO songDto){
        setArtist(songDto.getArtist());
        setBpm(songDto.getBpm());
        setKey(songDto.getKey());
        setProgression(sectionDtoToSection(songDto.getProgression()));
        setId(songDto.getId());
        setTitle(songDto.getTitle());
    }

    public List<Section> sectionDtoToSection(List<SectionDTO> sectionDTOS){
        return sectionDTOS.stream().map(Section::new).collect(Collectors.toList());
    }



//    private String genre;
//    private List<String> composer;
//    private List<String> producer;
//    private LocalDate releaseDate;
//    private String album;
//    private BigInteger playTimeInSeconds;
//    private BigInteger streams;

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

    public List<Section> getProgression()
    {
        return progression;
    }

    public void setProgression(List<Section> progression)
    {
        this.progression = progression;
    }
}
