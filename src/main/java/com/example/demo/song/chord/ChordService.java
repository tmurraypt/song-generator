package com.example.demo.song.chord;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ChordService
{
    private final ChordRepository chordRepository;

    public ChordService(ChordRepository chordRepository)
    {
        this.chordRepository = chordRepository;
    }

//    private void validateDTO(ChordDTO chordDto){
//        if(chordDto == null || chordDto.getTitle() == null || chordDto.getTitle().isBlank()){
//            throw new IllegalArgumentException("You need to include a title.");
//        }
//    }

    public Chord createChord(ChordDTO chordDto){
//        validateDTO(chordDto);
        var chord = new Chord(chordDto);
        return chordRepository.save(chord);
    }

    public List<Chord> getAllChords(){
        return chordRepository.findAll();
    }

    public Optional<Chord> getChordById(UUID id){
        return chordRepository.findById(id);
    }

    public void deleteChordById(UUID id){
        chordRepository.deleteById(id);
    }

    public Optional<Chord> updateChord(ChordDTO chordDto, UUID id)
    {
        return chordRepository.findById(id)
                .map(chord -> {
                    chord.setChordNumber(chordDto.getChordNumber());
                    chord.setChordQuality(chordDto.getChordQuality());
                    chord.setChordExtension(chordDto.getChordExtension());
                    chord.setAdditionalInfo(chordDto.getAdditionalInfo());
//                    song.setProgression(songDto.getProgression());
                    return chordRepository.save(chord);
                });
//                .orElseGet(() -> {
//                    songDto.setId(id);
//                    return songRepository.save(songDto);
//                });


    }
}
