package com.surveyForm.survey.apiController;

import com.surveyForm.survey.entities.Survey;
import com.surveyForm.survey.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/db")
public class ApiController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Survey> viewAllEntries(){
        return surveyService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Survey viewSurveyEntry(@PathVariable("id") long id){
        return surveyService.findSurveyEntry(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Survey addSurveyEntry(@RequestBody Survey survey){
        return surveyService.addSurveyEntry(survey);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Survey updateSurveyEntry(@RequestBody Survey survey){
        return surveyService.addSurveyEntry(survey);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSurveyEntry(@PathVariable("id") long id) throws EmptyResultDataAccessException{
            surveyService.deleteSurveyEntry(id);
    }
}
