package sdu.libraryApp.service;

import sdu.libraryApp.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> findAllBooks();

    BookDTO findById(Long theId) throws Exception;

    BookDTO save(BookDTO theBookDTO);

    void deleteById(Long theId);
}
