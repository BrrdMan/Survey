package com.surveyForm.survey.constants;

public enum FavFeature {
    CHALLENGES("Challenges"),
    PROJECTS("Projects"),
    COMMUNITY("Community"),
    OPEN_SOURCE("Open Source");

    private final String value;

    FavFeature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
