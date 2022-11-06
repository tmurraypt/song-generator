package com.example.demo.song;

import com.example.demo.song.section.Section;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "song")
@NoArgsConstructor
public class Song
{

    private @Id @GeneratedValue UUID id;
    private String title;
    private String artist;
    private String key;
    private int bpm;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "progression_mapping",
            joinColumns = {@JoinColumn(name = "song_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "section_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "chordList")
    private Map<Character, Section> progression;

    public Song(SongDTO songDto){
        setArtist(songDto.getArtist());
        setBpm(songDto.getBpm());
        setKey(songDto.getKey());
//        setProgression(songDto.getProgression());
        setId(songDto.getId());
        setTitle(songDto.getTitle());
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

    public Map<Character, Section> getProgression()
    {
        return progression;
    }

    public void setProgression(Map<Character, Section> progression)
    {
        this.progression = progression;
    }
}
