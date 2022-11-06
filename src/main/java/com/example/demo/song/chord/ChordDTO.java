package com.example.demo.song.chord;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChordDTO
{
    private UUID id;
    private int chordNumber;
    private ChordQuality chordQuality;
    private int chordExtension;
    private String additionalInfo;

}
