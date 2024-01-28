package com.surveyForm.survey.services;

import com.surveyForm.survey.dao.SurveyRepo;
import com.surveyForm.survey.entities.Survey;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepo sRepo;

    public List<Survey> getAll(){
        return sRepo.findAll();
    }
    @Transactional
    public List<Survey> getByKeyword(String keyword){
        return sRepo.getByKeyword(keyword);
    }

    public Survey findSurveyEntry(Long id){
        Optional<Survey> opt = sRepo.findById(id);
        Survey srv = null;
        if(opt.isPresent())
            srv = opt.get();
        else
            throw new RuntimeException("Employee not found");
        return srv;
    }
    public Survey addSurveyEntry(Survey survey){
        return sRepo.save(survey);
    }
    public void deleteSurveyEntry(Long id){
        sRepo.deleteById(id);
    }
    public Page<Survey> paginationWithSorting(int currentPage, int size, String field, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending() : Sort.by(field).descending();
        Pageable pageable = PageRequest.of(currentPage - 1, size, sort);
        return this.sRepo.findAll(pageable);
    }
}