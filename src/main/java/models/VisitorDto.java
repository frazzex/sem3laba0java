package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitorDto {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    List<BookDto> favoriteBooks;
}
