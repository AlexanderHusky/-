package com.twu.biblioteca;

public class Movie {
    private String tittle;
    private String author;
    private int pubYear;

    public Movie(){};
    public Movie(String tittle, String author, int pubYear){
        this.author = author;
        this.pubYear = pubYear;
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }
}
