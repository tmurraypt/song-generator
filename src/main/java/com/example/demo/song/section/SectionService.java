package com.example.demo.song.section;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class SectionService
{
    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository)
    {
        this.sectionRepository = sectionRepository;
    }

//    private void validateDTO(SectionDTO sectionDto){
//        if(sectionDto == null || sectionDto.getTitle() == null || sectionDto.getTitle().isBlank()){
//            throw new IllegalArgumentException("You need to include a title.");
//        }
//    }

    @Transactional
    public Section createSection(SectionDTO sectionDto){
//        validateDTO(sectionDto);
        var section = new Section(sectionDto);
        return sectionRepository.save(section);
    }

    public List<Section> getAllSections(){
        return sectionRepository.findAll();
    }

    public Optional<Section> getSectionById(UUID id){
        return sectionRepository.findById(id);
    }

    @Transactional
    public void deleteSectionById(UUID id){
        sectionRepository.deleteById(id);
    }

    @Transactional
    public Section updateSection(SectionDTO sectionDto, UUID id)
    {
        if(!sectionRepository.existsById(id))
        {
            throw new IllegalArgumentException("Section does not exist");
        }
        return sectionRepository.save(new Section(sectionDto));


    }
}
