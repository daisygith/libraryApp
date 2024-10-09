package sdu.libraryApp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import sdu.libraryApp.exception.ElementNotFoundException;
import sdu.libraryApp.repository.BookRepository;
import sdu.libraryApp.dto.BookDTO;
import sdu.libraryApp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> findAllBooks() {

        Pageable pageable = PageRequest.of(0, 20);
        Page<Book> bookList = bookRepository.findAll(pageable);

        List<Book> books = bookRepository.findAll();

        List<BookDTO> bookListDTO = new ArrayList<>();

        books.forEach((Book item) -> {
            bookListDTO.add(BookDTO.builder()
                            .id(item.getId())
                            .title(item.getTitle())
                            .author(item.getAuthor())
                            .releaseYear(item.getReleaseYear())
                    .build());
        });

        return bookListDTO;
    }

    @Override
    public BookDTO findById(Long theId) throws Exception {

        Book book = bookRepository.findById(theId).orElseThrow(()
        -> new ElementNotFoundException(theId));

        BookDTO bookDTO = BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .releaseYear(book.getReleaseYear())
                .build();

        return bookDTO;
    }

    @Transactional
    @Override
    public BookDTO save(BookDTO theBookDTO) {
        Book book = bookRepository.save(Book.builder()
                        .id(theBookDTO.getId())
                        .title(theBookDTO.getTitle())
                        .author(theBookDTO.getAuthor())
                        .releaseYear(theBookDTO.getReleaseYear())
                .build());

        BookDTO bookDTO = BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .releaseYear(book.getReleaseYear())
                .build();

        return bookDTO;
    }

    @Transactional
    @Override
    public void deleteById(Long theId) {
        bookRepository.deleteById(theId);
    }
}
