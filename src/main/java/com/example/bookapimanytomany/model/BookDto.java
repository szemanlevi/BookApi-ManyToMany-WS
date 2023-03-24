package com.example.bookapimanytomany.model;

public class BookDto {
    private String title;

    public BookDto(String title) {
        this.title = title;
    }

    public BookDto() {
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
