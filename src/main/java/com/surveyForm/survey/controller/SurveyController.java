package com.surveyForm.survey.controller;

import com.surveyForm.survey.constants.CurrentRole;
import com.surveyForm.survey.constants.FavFeature;
import com.surveyForm.survey.constants.Feedback;
import com.surveyForm.survey.constants.Recommendation;
import com.surveyForm.survey.entities.Survey;
import com.surveyForm.survey.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/surveyForm/db")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/new")
    public String viewSurveyForm(Model model){
        Survey survey = new Survey();
        model.addAttribute("survey", survey);
        model.addAttribute("Roles", CurrentRole.values());
        model.addAttribute("favFeature", FavFeature.values());
        model.addAttribute("feedback", Feedback.values());
        model.addAttribute("recommendation", Recommendation.values());
        return "Survey";
    }

    @PostMapping("/save")
    public String saveSurveyEntry(Survey survey){
        surveyService.addSurveyEntry(survey);
        return "thankyou_page";
    }

    @GetMapping
    public String surveyDb(Model model){
        return getPageWithSort(model, 1, "name", "asc");
    }

    @GetMapping("/search")
    public String searchForSurveyEntry(Model model, @Param("keyword") String keyword){
        List<Survey> surveyList = new ArrayList<>();
        if(keyword == null){
            surveyList.addAll(surveyService.getAll());
        }
        else{
            surveyList.addAll(surveyService.getByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("surveyList", surveyList);
        return "searchList";
    }

    @GetMapping("/page/{pageNo}")
    public String getPageWithSort(Model model, @PathVariable("pageNo") int currentPage,
                                  @RequestParam("field") String field,
                                  @RequestParam("sortDir") String sortDir){
        int size = 4;

        Page<Survey> page = surveyService.paginationWithSorting(currentPage, size, field, sortDir);
        List<Survey> surveys = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("field", field);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        model.addAttribute("surveys", surveys);

        return "surveyDatabase";
    }
}
