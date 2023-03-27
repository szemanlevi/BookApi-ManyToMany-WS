package com.example.bookapimanytomany.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorDto {
    private String name;
    private List<Long> bookIdList;
}
