package com.example.bookapimanytomany.model;

import com.example.bookapimanytomany.validator.NoSingleWord;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {
    @NotBlank(message = "{errors.book.title}")
    @NoSingleWord(message = "{errors.book.nosingle}")
    private String title;

    private List<Long> authorIdList;
}
