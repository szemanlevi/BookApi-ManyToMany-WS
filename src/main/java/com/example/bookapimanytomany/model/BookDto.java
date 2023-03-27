package com.example.bookapimanytomany.model;

import java.util.List;

public class BookDto {
    private String title;

    private List<Long> authorIdList;

    public List<Long> getAuthorIdList() {
        return authorIdList;
    }

    public void setAuthorIdList(List<Long> authorIdList) {
        this.authorIdList = authorIdList;
    }

    public BookDto(String title) {
        this.title = title;
    }

    public BookDto(String title, List<Long> authorIdList) {
        this.title = title;
        this.authorIdList = authorIdList;
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
