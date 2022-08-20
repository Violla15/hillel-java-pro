package ua.ithillel.lectures.lecture_18.xml.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Book {
    private String id;
    private String author;
    private String title;
    private String genre;
    private String price;
    private String publishDate;
    private String description;
}
