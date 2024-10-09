package sdu.libraryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdu.libraryApp.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
