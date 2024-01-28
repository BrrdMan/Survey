package com.surveyForm.survey.constants;

public enum CurrentRole {
    STUDENT("Student"),
    FULL_TIME_JOB("Full Time Job"),
    FULL_TIME_STUDENT("Full Time Student"),
    PREFER_NOT_TO_SAY("Prefer not to say"),
    OTHER("Other");

    private final String value;

    CurrentRole(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
