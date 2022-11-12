package com.example.demo.song.section;

import com.example.demo.song.chord.ChordDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SectionDTO
{
    private Character key;
    private List<ChordDTO> chordList;
}
