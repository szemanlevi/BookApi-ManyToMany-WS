package com.example.bookapimanytomany.model;

import com.example.bookapimanytomany.controller.NoSingleWord;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {
    @NotBlank(message = "henlo benlo legyszi ne hagyd uresen")
    @NoSingleWord
    private String title;

    private List<Long> authorIdList;
}
