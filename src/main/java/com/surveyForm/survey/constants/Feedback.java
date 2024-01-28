package com.surveyForm.survey.constants;

import lombok.Getter;

@Getter
public enum Feedback {
    FRONTEND_PROJECTS("Front-end Projects"),
    BACKEND_PROJECTS("Back-end Projects"),
    DATA_VISUALIZATION("Data Visualization"),
    CHALLENGES("Challenges"),
    OPEN_SOURCE_COMMUNITY("Open Source Community"),
    GITTER_HELP_ROOMS("Gitter help rooms"),
    VIDEOS("Videos"),
    CITY_MEETUPS("City Meetups"),
    WIKI("Wiki"),
    FORUMS("Forums"),
    ADDITIONAL_COURSES("Additional Courses");

    private final String value;

    Feedback(String value) {
        this.value = value;
    }
}