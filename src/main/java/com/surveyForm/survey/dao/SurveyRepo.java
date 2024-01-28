package com.surveyForm.survey.dao;

import com.surveyForm.survey.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepo extends JpaRepository<Survey, Long> {
    @Query(value = "select * from survey s where lower(s.name) like lower(concat('%', :keyword, '%'))", nativeQuery = true)
    List<Survey> getByKeyword(@Param("keyword") String keyword);

}
