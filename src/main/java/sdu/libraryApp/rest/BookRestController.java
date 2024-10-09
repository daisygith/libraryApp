package sdu.libraryApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.libraryApp.dto.BookDTO;
import sdu.libraryApp.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<BookDTO> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public BookDTO getBook(@PathVariable Long bookId) throws Exception {

        BookDTO book = bookService.findById(bookId);

        return book;

    }

    @PostMapping("/books")
    public BookDTO addBook(@RequestBody BookDTO bookDTO){

//        bookDTO.setId(0L);

        BookDTO dbBook = bookService.save(bookDTO);

        return dbBook;
    }

    @PutMapping("/books")
    public BookDTO updateBooks(@RequestBody BookDTO bookDTO){

        BookDTO dbBook = bookService.save(bookDTO);

        return dbBook;

    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBooks(@PathVariable Long bookId) throws Exception {

        BookDTO tempBook = bookService.findById(bookId);

        if(tempBook == null){
            throw new RuntimeException("Book is not found " + bookId);
        }

        bookService.deleteById(bookId);

        return "Delete book id - " + bookId;
    }
}
