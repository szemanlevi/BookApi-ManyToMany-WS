package com.example.bookapimanytomany.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {
    private String title;

    private List<Long> authorIdList;
}
