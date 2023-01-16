package com.example.demo.song.chord;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
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

    @Transactional
    public void deleteChordById(UUID id){
        chordRepository.deleteById(id);
    }

    @Transactional
    public Chord updateChord(ChordDTO chordDto, UUID id)
    {
        if(!chordRepository.existsById(id))
        {
            throw new IllegalArgumentException("Chord does not exist");
        }

        return chordRepository.save(new Chord(chordDto));


    }
}
