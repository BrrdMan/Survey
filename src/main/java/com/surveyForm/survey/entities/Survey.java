package com.surveyForm.survey.entities;

import com.surveyForm.survey.constants.CurrentRole;
import com.surveyForm.survey.constants.FavFeature;
import com.surveyForm.survey.constants.Feedback;
import com.surveyForm.survey.constants.Recommendation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Email(message = "Enter valid email")
    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private CurrentRole currentRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "recommendation")
    private Recommendation recommendation;

    @Enumerated(EnumType.STRING)
    @Column(name = "fav_feature")
    private FavFeature favFeature;

    @Enumerated(EnumType.STRING)
    private List<Feedback> feedback;

    private String comment;
}
