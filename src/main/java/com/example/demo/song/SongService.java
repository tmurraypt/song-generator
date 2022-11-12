package com.example.demo.song;

import org.springframework.stereotype.Service;

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

    public Song createSong(SongDTO songDto){
        validateDTO(songDto);
        var song = new Song(songDto);
        return songRepository.save(song);
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(UUID id){
        return songRepository.findById(id);
    }

    public void deleteSongById(UUID id){
        songRepository.deleteById(id);
    }

    public Optional<Song> updateSong(SongDTO songDto, UUID id)
    {
        return songRepository.findById(id)
                .map(song -> {
                    song.setTitle(songDto.getTitle());
                    song.setArtist(songDto.getArtist());
                    song.setKey(songDto.getKey());
                    song.setBpm(songDto.getBpm());
//                    song.setProgression(songDto.getProgression());
                    return songRepository.save(song);
                });
//                .orElseGet(() -> {
//                    songDto.setId(id);
//                    return songRepository.save(songDto);
//                });


    }
}
