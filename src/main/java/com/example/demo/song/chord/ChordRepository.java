package com.example.demo.song.chord;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChordRepository extends JpaRepository<Chord, UUID>
{
}
