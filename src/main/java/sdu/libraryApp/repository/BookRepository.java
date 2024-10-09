package sdu.libraryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdu.libraryApp.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    List<Book> findAllBooks();
//
//    Optional<Book> findById(Long theId);
//
//    Book save(Book theBook);
//
//    void deleteById(Long theId);

}
