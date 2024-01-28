package com.surveyForm.survey.constants;

public enum Recommendation {
    DEFINITELY("Definitely"),
    MAYBE("Maybe"),
    NOT_SURE("Not Sure");

    private final String value;

    Recommendation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


