package sdu.libraryApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.lang.Nullable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    private String title;

    private String author;

    private int releaseYear;

}
