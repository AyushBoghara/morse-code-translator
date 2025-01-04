package com.example.morsecodetranslator.Models;

public class NumberModel {

    String number ;
    String pattern ;

    public NumberModel(String number, String pattern) {
        this.number = number;
        this.pattern = pattern;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
