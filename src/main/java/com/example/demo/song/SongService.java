package com.example.demo.song;

import org.springframework.stereotype.Service;

@Service
public class SongService
{
    private SongRepository songRepository;

    public SongService(SongRepository songRepository)
    {
        this.songRepository = songRepository;
    }

    public Song createSong(SongDTO songDto){
        var song = new Song(songDto);
        return songRepository.save(song);
    }
}
