package com.example.demo.song;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class SongService
{
    private SongRepository songRepository;

    public SongService(SongRepository songRepository)
    {
        this.songRepository = songRepository;
    }

    private void validateDTO(SongDTO songDto){
        if(songDto == null || songDto.getTitle() == null || songDto.getTitle().isBlank()){
            throw new IllegalArgumentException("You need to include a title.");
        }
    }

    @Transactional
    public Song createSong(SongDTO songDto){
        validateDTO(songDto);
        var song = new Song(songDto);
        return songRepository.save(song);
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(UUID id){

        if(!songRepository.existsById(id)){
            throw new IllegalArgumentException("Song does not exist");
        }
        return songRepository.findById(id);
    }

    @Transactional
    public void deleteSongById(UUID id){
        if(!songRepository.existsById(id)){
            throw new IllegalArgumentException("Song does not exist");
        }
        songRepository.deleteById(id);
    }

    @Transactional
    public Song updateSong(SongDTO songDto, UUID id)
    {
        if(!songRepository.existsById(id)){
            throw new IllegalArgumentException("Song does not exist");
        }
        return songRepository.save(new Song(songDto));
    }
}
