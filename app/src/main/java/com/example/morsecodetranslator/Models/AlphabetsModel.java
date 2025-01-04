package com.example.morsecodetranslator.Models;

public class AlphabetsModel {

    String alphabet;
    String alphabetPattern;

    public AlphabetsModel(String alphabet, String alphabetPattern) {
        this.alphabet = alphabet;
        this.alphabetPattern = alphabetPattern;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getAlphabetPattern() {
        return alphabetPattern;
    }

    public void setAlphabetPattern(String alphabetPattern) {
        this.alphabetPattern = alphabetPattern;
    }
}
