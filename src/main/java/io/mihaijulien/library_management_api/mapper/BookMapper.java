package io.mihaijulien.library_management_api.mapper;

import io.mihaijulien.library_management_api.model.dto.BookDto;
import io.mihaijulien.library_management_api.model.entity.Book;

public class BookMapper {

    public static Book fromDto(BookDto dto){
        return Book.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .copies(dto.copies())
                .copiesAvailable(dto.copiesAvailable())
                .category(dto.bookCategory())
                .img(dto.img())
                .build();
    }

    public static BookDto toDto(Book entity){
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .copies(entity.getCopies())
                .copiesAvailable(entity.getCopiesAvailable())
                .bookCategory(entity.getCategory())
                .img(entity.getImg())
                .build();
    }
}
