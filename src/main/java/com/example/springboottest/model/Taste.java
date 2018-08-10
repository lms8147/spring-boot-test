package com.example.springboottest.model;

public class Taste {
    public final int salty;
    public final int sour;
    public final int sweet;
    public final int bitter;
    public final int spicy;

    public Taste(int salty, int sour, int sweet, int bitter, int spicy) {
        this.salty = salty;
        this.sour = sour;
        this.sweet = sweet;
        this.bitter = bitter;
        this.spicy = spicy;
    }
}
