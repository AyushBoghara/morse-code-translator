package com.example.morsecodetranslator.Models;

public class SymbolsModel {
    String symbol;
    String patternSymbol;

    public SymbolsModel(String symbol, String patternSymbol) {
        this.symbol = symbol;
        this.patternSymbol = patternSymbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPatternSymbol() {
        return patternSymbol;
    }

    public void setPatternSymbol(String patternSymbol) {
        this.patternSymbol = patternSymbol;
    }
}
